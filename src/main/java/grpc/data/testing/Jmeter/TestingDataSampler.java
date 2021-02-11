package grpc.data.testing.Jmeter;

import grpc.data.testing.TestingGrpcClient;
import io.grpc.StatusRuntimeException;
import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
import org.json.simple.parser.ParseException;
import javax.net.ssl.SSLException;

public class TestingDataSampler extends AbstractJavaSamplerClient {

    TestingGrpcClient bclient = null;
    String host = "";
    String port = "";
    String realName = "";
    String powerName = "";
    String screenName = "";
    String comicName = "";

    @Override
    public void setupTest(JavaSamplerContext context) {
        host = context.getParameter("host");
        port = context.getParameter("port");

        try {
            this.bclient = new TestingGrpcClient(host, Integer.parseInt(port));
        } catch (SSLException e) {
            e.printStackTrace();
        }
        super.setupTest(context);
    }

    @Override
    public Arguments getDefaultParameters() {
        Arguments defaultParameters = new Arguments();
        defaultParameters.addArgument("host", "192.168.14.88");
        defaultParameters.addArgument("port", "11000");
        defaultParameters.addArgument("RealName", realName);
        defaultParameters.addArgument("Power Name", powerName);
        defaultParameters.addArgument("screen Name", screenName);
        defaultParameters.addArgument("comic Name", comicName);
        return defaultParameters;
    }

    public SampleResult runTest(JavaSamplerContext context) {
        realName = context.getParameter("realName");
        powerName = context.getParameter("powerName");
        screenName = context.getParameter("screenName");
        comicName = context.getParameter("comicName");
        SampleResult result = new SampleResult();
        boolean success = true;
        String response = "";
        result.sampleStart();

        try {
            System.out.println(host + " " + port);
            if (!bclient.isActiveChannel()){
                this.bclient = new TestingGrpcClient(host, Integer.parseInt(port));
            }
            response = this.bclient.sendRequestToService(realName, powerName, screenName, comicName);
            result.sampleEnd();
            result.setSuccessful(success);
            result.setResponseData(response.getBytes());
            result.setResponseMessage("Successfully performed backup healthcheck");
            result.setResponseCodeOK(); // 200 code
        } catch (StatusRuntimeException | ParseException | SSLException e) {
            result.sampleEnd(); // stop stopwatch
            result.setSuccessful(false);
            result.setResponseMessage("Exception: " + e);
            success = false;
            result.setSuccessful(success);
            // get stack trace as a String to return as document data
            java.io.StringWriter stringWriter = new java.io.StringWriter();
            e.printStackTrace(new java.io.PrintWriter(stringWriter));
            result.setResponseData(stringWriter.toString().getBytes());
            result.setDataType(SampleResult.TEXT);
            result.setResponseCode("500");
        }
        return result;
    }

    @Override
    public void teardownTest(JavaSamplerContext context) {
        try {
            bclient.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        super.teardownTest(context);
    }
}
