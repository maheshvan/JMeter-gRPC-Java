// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: sample.proto

package sample.protbuf;

public final class SampleMessageProtos {
  private SampleMessageProtos() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_protbuf_Message_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_protbuf_Message_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_protbuf_Message_Data_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_protbuf_Message_Data_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_protbuf_Message_Instance_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_protbuf_Message_Instance_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_protbuf_Response_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_protbuf_Response_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\014sample.proto\022\007protbuf\"\241\002\n\007Message\022\020\n\010R" +
      "ealName\030\001 \001(\t\022,\n\tinstances\030\002 \003(\0132\031.protb" +
      "uf.Message.Instance\032\220\001\n\004Data\022\n\n\002id\030\001 \001(\005" +
      "\022\014\n\004name\030\002 \001(\t\022\021\n\ttimeInGMT\030\003 \001(\t\022*\n\005com" +
      "ic\030\004 \001(\0162\033.protbuf.Message.Data.Comic\022\022\n" +
      "\nScreenName\030\005 \001(\t\"\033\n\005Comic\022\n\n\006Marvel\020\000\022\006" +
      "\n\002DC\020\001\032C\n\010Instance\022\022\n\ninstanceId\030\001 \001(\t\022#" +
      "\n\004data\030\002 \003(\0132\025.protbuf.Message.Data\"r\n\010R" +
      "esponse\0220\n\nreturnCode\030\001 \001(\0162\034.protbuf.Re" +
      "sponse.ReturnCode\022\023\n\013description\030\002 \001(\t\"\037" +
      "\n\nReturnCode\022\006\n\002OK\020\000\022\t\n\005ERROR\020\0012E\n\rMessa" +
      "geSender\0224\n\013sendMessage\022\020.protbuf.Messag" +
      "e\032\021.protbuf.Response\"\000B\'\n\016sample.protbuf" +
      "B\023SampleMessageProtosP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_protbuf_Message_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_protbuf_Message_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_protbuf_Message_descriptor,
        new java.lang.String[] { "RealName", "Instances", });
    internal_static_protbuf_Message_Data_descriptor =
      internal_static_protbuf_Message_descriptor.getNestedTypes().get(0);
    internal_static_protbuf_Message_Data_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_protbuf_Message_Data_descriptor,
        new java.lang.String[] { "Id", "Name", "TimeInGMT", "Comic", "ScreenName", });
    internal_static_protbuf_Message_Instance_descriptor =
      internal_static_protbuf_Message_descriptor.getNestedTypes().get(1);
    internal_static_protbuf_Message_Instance_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_protbuf_Message_Instance_descriptor,
        new java.lang.String[] { "InstanceId", "Data", });
    internal_static_protbuf_Response_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_protbuf_Response_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_protbuf_Response_descriptor,
        new java.lang.String[] { "ReturnCode", "Description", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
