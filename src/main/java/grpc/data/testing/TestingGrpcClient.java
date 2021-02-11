package grpc.data.testing;

import io.grpc.ManagedChannel;
import io.grpc.Metadata;
import io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.NettyChannelBuilder;
import io.netty.handler.ssl.SslProvider;
import sample.protbuf.Message;
import sample.protbuf.MessageSenderGrpc;
import org.json.simple.parser.ParseException;
import sample.protbuf.Response;

import javax.net.ssl.SSLException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestingGrpcClient {

    public ManagedChannel channel;
    public MessageSenderGrpc.MessageSenderBlockingStub stub;
    public Message request;
    Message.Builder MessageBuilder;
    public Metadata header;
    public String resp = "Response: ";
    private static SimpleDateFormat gmtDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:" + "00");
    private static final Logger LOGGER = Logger.getLogger(TestingGrpcClient.class.getName());

    public TestingGrpcClient() {

    }

    public static void main(String args[]) {

    }

    public TestingGrpcClient(String host, int port) throws SSLException {
        this.channel = createChannel(host, port);
        this.stub = createBlockingStub(this.channel);
    }

    public ManagedChannel createChannel(String host, int port) throws SSLException {
        channel = NettyChannelBuilder.forAddress(host, port)
                .sslContext(GrpcSslContexts
                        .forClient()
                        .sslProvider(SslProvider.OPENSSL)
                        .build())
                .build();
        return channel;
    }

    public MessageSenderGrpc.MessageSenderBlockingStub createBlockingStub(ManagedChannel channel) {
        stub = MessageSenderGrpc.newBlockingStub(channel);
        return stub;
    }

    public boolean isActiveChannel() {
        if (channel == null) {
            return false;
        }
        return true;
    }

    public String sendRequestToService(String realName, String name, String screenName, String cinematic) throws ParseException {

        try{

            LOGGER.setLevel(Level.INFO);
            LOGGER.info("Logger Name: " + LOGGER.getName());
            LOGGER.info("Real Name : " + realName);
            LOGGER.info("In movie Name : " + name);

            System.out.println("realName: " + realName);

            gmtDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            String Time = gmtDateFormat.format(new Date());

            MessageBuilder = Message.newBuilder();
            Message.Instance.Builder instanceBuilder;
            MessageBuilder.setRealName(realName);

            instanceBuilder = Message.Instance.newBuilder();
            instanceBuilder.setInstanceId(String.valueOf(1));

            Message.Data.Comic comic = null;
            Message.Data data = null;

            switch (cinematic) {
                case "Marvel":
                    comic = Message.Data.Comic.Marvel;
                    break;
                case "DC":
                    comic = Message.Data.Comic.DC;
                    break;
            }

            data = Message.Data.newBuilder()
                    .setComic(comic)
                    .setId(1)
                    .setName(name)
                    .setTimeInGMT(Time)
                    .setScreenName(screenName).build();

            instanceBuilder.addData(data);
            Message.Instance instance = instanceBuilder.build();
            MessageBuilder.addInstances(instance);

            Message message = MessageBuilder.build();

            Response serverResponse = stub.withInterceptors(new grpc.kpi.testing.HeaderClientInterceptor()).sendMessage(message);
            resp = resp.concat(serverResponse.toString());

        }
        catch (Exception e){
            e.printStackTrace();
        }

        return resp;
        }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

}
