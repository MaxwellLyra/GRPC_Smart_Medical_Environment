// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: PersonalHealthAssistant.proto

package ds.serviceTwo;

public final class ServiceTwoImpl {
  private ServiceTwoImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_service2_BMICalcRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_service2_BMICalcRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_service2_BMICalcResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_service2_BMICalcResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_service2_MedStockRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_service2_MedStockRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_service2_MedStockResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_service2_MedStockResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\035PersonalHealthAssistant.proto\022\010service" +
      "2\"0\n\016BMICalcRequest\022\016\n\006weigth\030\001 \001(\005\022\016\n\006h" +
      "eight\030\002 \001(\005\"!\n\017BMICalcResponse\022\016\n\006result" +
      "\030\001 \001(\005\"\037\n\017MedStockRequest\022\014\n\004text\030\001 \001(\t\"" +
      "$\n\020MedStockResponse\022\020\n\010textback\030\001 \001(\t2\257\001" +
      "\n\027PersonalHealthAssistant\022H\n\rBMICalculat" +
      "or\022\030.service2.BMICalcRequest\032\031.service2." +
      "BMICalcResponse\"\000(\001\022J\n\rMedicineStock\022\031.s" +
      "ervice2.MedStockRequest\032\032.service2.MedSt" +
      "ockResponse\"\0000\001B!\n\rds.serviceTwoB\016Servic" +
      "eTwoImplP\001b\006proto3"
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
    internal_static_service2_BMICalcRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_service2_BMICalcRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_service2_BMICalcRequest_descriptor,
        new java.lang.String[] { "Weigth", "Height", });
    internal_static_service2_BMICalcResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_service2_BMICalcResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_service2_BMICalcResponse_descriptor,
        new java.lang.String[] { "Result", });
    internal_static_service2_MedStockRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_service2_MedStockRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_service2_MedStockRequest_descriptor,
        new java.lang.String[] { "Text", });
    internal_static_service2_MedStockResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_service2_MedStockResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_service2_MedStockResponse_descriptor,
        new java.lang.String[] { "Textback", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
