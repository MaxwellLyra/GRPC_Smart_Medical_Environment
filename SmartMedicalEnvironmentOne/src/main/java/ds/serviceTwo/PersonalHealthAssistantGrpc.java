package ds.serviceTwo;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * Interface exported by the server.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: PersonalHealthAssistant.proto")
public final class PersonalHealthAssistantGrpc {

  private PersonalHealthAssistantGrpc() {}

  public static final String SERVICE_NAME = "service2.PersonalHealthAssistant";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.serviceTwo.BMICalcRequest,
      ds.serviceTwo.BMICalcResponse> getBMICalculatorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BMICalculator",
      requestType = ds.serviceTwo.BMICalcRequest.class,
      responseType = ds.serviceTwo.BMICalcResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<ds.serviceTwo.BMICalcRequest,
      ds.serviceTwo.BMICalcResponse> getBMICalculatorMethod() {
    io.grpc.MethodDescriptor<ds.serviceTwo.BMICalcRequest, ds.serviceTwo.BMICalcResponse> getBMICalculatorMethod;
    if ((getBMICalculatorMethod = PersonalHealthAssistantGrpc.getBMICalculatorMethod) == null) {
      synchronized (PersonalHealthAssistantGrpc.class) {
        if ((getBMICalculatorMethod = PersonalHealthAssistantGrpc.getBMICalculatorMethod) == null) {
          PersonalHealthAssistantGrpc.getBMICalculatorMethod = getBMICalculatorMethod = 
              io.grpc.MethodDescriptor.<ds.serviceTwo.BMICalcRequest, ds.serviceTwo.BMICalcResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "service2.PersonalHealthAssistant", "BMICalculator"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.serviceTwo.BMICalcRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.serviceTwo.BMICalcResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new PersonalHealthAssistantMethodDescriptorSupplier("BMICalculator"))
                  .build();
          }
        }
     }
     return getBMICalculatorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.serviceTwo.MedStockRequest,
      ds.serviceTwo.MedStockResponse> getMedicineStockMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MedicineStock",
      requestType = ds.serviceTwo.MedStockRequest.class,
      responseType = ds.serviceTwo.MedStockResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ds.serviceTwo.MedStockRequest,
      ds.serviceTwo.MedStockResponse> getMedicineStockMethod() {
    io.grpc.MethodDescriptor<ds.serviceTwo.MedStockRequest, ds.serviceTwo.MedStockResponse> getMedicineStockMethod;
    if ((getMedicineStockMethod = PersonalHealthAssistantGrpc.getMedicineStockMethod) == null) {
      synchronized (PersonalHealthAssistantGrpc.class) {
        if ((getMedicineStockMethod = PersonalHealthAssistantGrpc.getMedicineStockMethod) == null) {
          PersonalHealthAssistantGrpc.getMedicineStockMethod = getMedicineStockMethod = 
              io.grpc.MethodDescriptor.<ds.serviceTwo.MedStockRequest, ds.serviceTwo.MedStockResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "service2.PersonalHealthAssistant", "MedicineStock"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.serviceTwo.MedStockRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.serviceTwo.MedStockResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new PersonalHealthAssistantMethodDescriptorSupplier("MedicineStock"))
                  .build();
          }
        }
     }
     return getMedicineStockMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PersonalHealthAssistantStub newStub(io.grpc.Channel channel) {
    return new PersonalHealthAssistantStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PersonalHealthAssistantBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new PersonalHealthAssistantBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PersonalHealthAssistantFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new PersonalHealthAssistantFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class PersonalHealthAssistantImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * rpc method for Client Streaming calls
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ds.serviceTwo.BMICalcRequest> bMICalculator(
        io.grpc.stub.StreamObserver<ds.serviceTwo.BMICalcResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getBMICalculatorMethod(), responseObserver);
    }

    /**
     * <pre>
     * rpc method for Server Streaming calls
     * </pre>
     */
    public void medicineStock(ds.serviceTwo.MedStockRequest request,
        io.grpc.stub.StreamObserver<ds.serviceTwo.MedStockResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getMedicineStockMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getBMICalculatorMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                ds.serviceTwo.BMICalcRequest,
                ds.serviceTwo.BMICalcResponse>(
                  this, METHODID_BMICALCULATOR)))
          .addMethod(
            getMedicineStockMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                ds.serviceTwo.MedStockRequest,
                ds.serviceTwo.MedStockResponse>(
                  this, METHODID_MEDICINE_STOCK)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class PersonalHealthAssistantStub extends io.grpc.stub.AbstractStub<PersonalHealthAssistantStub> {
    private PersonalHealthAssistantStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PersonalHealthAssistantStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PersonalHealthAssistantStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PersonalHealthAssistantStub(channel, callOptions);
    }

    /**
     * <pre>
     * rpc method for Client Streaming calls
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ds.serviceTwo.BMICalcRequest> bMICalculator(
        io.grpc.stub.StreamObserver<ds.serviceTwo.BMICalcResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getBMICalculatorMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * rpc method for Server Streaming calls
     * </pre>
     */
    public void medicineStock(ds.serviceTwo.MedStockRequest request,
        io.grpc.stub.StreamObserver<ds.serviceTwo.MedStockResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getMedicineStockMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class PersonalHealthAssistantBlockingStub extends io.grpc.stub.AbstractStub<PersonalHealthAssistantBlockingStub> {
    private PersonalHealthAssistantBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PersonalHealthAssistantBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PersonalHealthAssistantBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PersonalHealthAssistantBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * rpc method for Server Streaming calls
     * </pre>
     */
    public java.util.Iterator<ds.serviceTwo.MedStockResponse> medicineStock(
        ds.serviceTwo.MedStockRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getMedicineStockMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class PersonalHealthAssistantFutureStub extends io.grpc.stub.AbstractStub<PersonalHealthAssistantFutureStub> {
    private PersonalHealthAssistantFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PersonalHealthAssistantFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PersonalHealthAssistantFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PersonalHealthAssistantFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_MEDICINE_STOCK = 0;
  private static final int METHODID_BMICALCULATOR = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PersonalHealthAssistantImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PersonalHealthAssistantImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_MEDICINE_STOCK:
          serviceImpl.medicineStock((ds.serviceTwo.MedStockRequest) request,
              (io.grpc.stub.StreamObserver<ds.serviceTwo.MedStockResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_BMICALCULATOR:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.bMICalculator(
              (io.grpc.stub.StreamObserver<ds.serviceTwo.BMICalcResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class PersonalHealthAssistantBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PersonalHealthAssistantBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.serviceTwo.ServiceTwoImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PersonalHealthAssistant");
    }
  }

  private static final class PersonalHealthAssistantFileDescriptorSupplier
      extends PersonalHealthAssistantBaseDescriptorSupplier {
    PersonalHealthAssistantFileDescriptorSupplier() {}
  }

  private static final class PersonalHealthAssistantMethodDescriptorSupplier
      extends PersonalHealthAssistantBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PersonalHealthAssistantMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (PersonalHealthAssistantGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PersonalHealthAssistantFileDescriptorSupplier())
              .addMethod(getBMICalculatorMethod())
              .addMethod(getMedicineStockMethod())
              .build();
        }
      }
    }
    return result;
  }
}
