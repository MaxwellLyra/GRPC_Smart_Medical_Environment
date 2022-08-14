package ds.serviceOne;

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
    comments = "Source: WellBeingChecker.proto")
public final class WellBeingCheckerGrpc {

  private WellBeingCheckerGrpc() {}

  public static final String SERVICE_NAME = "service1.WellBeingChecker";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.serviceOne.PulseReadRequest,
      ds.serviceOne.PulseReadResponse> getPulseReadingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PulseReading",
      requestType = ds.serviceOne.PulseReadRequest.class,
      responseType = ds.serviceOne.PulseReadResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<ds.serviceOne.PulseReadRequest,
      ds.serviceOne.PulseReadResponse> getPulseReadingMethod() {
    io.grpc.MethodDescriptor<ds.serviceOne.PulseReadRequest, ds.serviceOne.PulseReadResponse> getPulseReadingMethod;
    if ((getPulseReadingMethod = WellBeingCheckerGrpc.getPulseReadingMethod) == null) {
      synchronized (WellBeingCheckerGrpc.class) {
        if ((getPulseReadingMethod = WellBeingCheckerGrpc.getPulseReadingMethod) == null) {
          WellBeingCheckerGrpc.getPulseReadingMethod = getPulseReadingMethod = 
              io.grpc.MethodDescriptor.<ds.serviceOne.PulseReadRequest, ds.serviceOne.PulseReadResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "service1.WellBeingChecker", "PulseReading"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.serviceOne.PulseReadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.serviceOne.PulseReadResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new WellBeingCheckerMethodDescriptorSupplier("PulseReading"))
                  .build();
          }
        }
     }
     return getPulseReadingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.serviceOne.StepsCalcRequest,
      ds.serviceOne.StepsCalcResponse> getStepsCalculatorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StepsCalculator",
      requestType = ds.serviceOne.StepsCalcRequest.class,
      responseType = ds.serviceOne.StepsCalcResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<ds.serviceOne.StepsCalcRequest,
      ds.serviceOne.StepsCalcResponse> getStepsCalculatorMethod() {
    io.grpc.MethodDescriptor<ds.serviceOne.StepsCalcRequest, ds.serviceOne.StepsCalcResponse> getStepsCalculatorMethod;
    if ((getStepsCalculatorMethod = WellBeingCheckerGrpc.getStepsCalculatorMethod) == null) {
      synchronized (WellBeingCheckerGrpc.class) {
        if ((getStepsCalculatorMethod = WellBeingCheckerGrpc.getStepsCalculatorMethod) == null) {
          WellBeingCheckerGrpc.getStepsCalculatorMethod = getStepsCalculatorMethod = 
              io.grpc.MethodDescriptor.<ds.serviceOne.StepsCalcRequest, ds.serviceOne.StepsCalcResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "service1.WellBeingChecker", "StepsCalculator"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.serviceOne.StepsCalcRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.serviceOne.StepsCalcResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new WellBeingCheckerMethodDescriptorSupplier("StepsCalculator"))
                  .build();
          }
        }
     }
     return getStepsCalculatorMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static WellBeingCheckerStub newStub(io.grpc.Channel channel) {
    return new WellBeingCheckerStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WellBeingCheckerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new WellBeingCheckerBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static WellBeingCheckerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new WellBeingCheckerFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class WellBeingCheckerImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * rpc method for Bidirectional Streaming calls
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ds.serviceOne.PulseReadRequest> pulseReading(
        io.grpc.stub.StreamObserver<ds.serviceOne.PulseReadResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getPulseReadingMethod(), responseObserver);
    }

    /**
     * <pre>
     * rpc method for Client Streaming calls
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ds.serviceOne.StepsCalcRequest> stepsCalculator(
        io.grpc.stub.StreamObserver<ds.serviceOne.StepsCalcResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getStepsCalculatorMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getPulseReadingMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                ds.serviceOne.PulseReadRequest,
                ds.serviceOne.PulseReadResponse>(
                  this, METHODID_PULSE_READING)))
          .addMethod(
            getStepsCalculatorMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                ds.serviceOne.StepsCalcRequest,
                ds.serviceOne.StepsCalcResponse>(
                  this, METHODID_STEPS_CALCULATOR)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class WellBeingCheckerStub extends io.grpc.stub.AbstractStub<WellBeingCheckerStub> {
    private WellBeingCheckerStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WellBeingCheckerStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WellBeingCheckerStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WellBeingCheckerStub(channel, callOptions);
    }

    /**
     * <pre>
     * rpc method for Bidirectional Streaming calls
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ds.serviceOne.PulseReadRequest> pulseReading(
        io.grpc.stub.StreamObserver<ds.serviceOne.PulseReadResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getPulseReadingMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * rpc method for Client Streaming calls
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ds.serviceOne.StepsCalcRequest> stepsCalculator(
        io.grpc.stub.StreamObserver<ds.serviceOne.StepsCalcResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getStepsCalculatorMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class WellBeingCheckerBlockingStub extends io.grpc.stub.AbstractStub<WellBeingCheckerBlockingStub> {
    private WellBeingCheckerBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WellBeingCheckerBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WellBeingCheckerBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WellBeingCheckerBlockingStub(channel, callOptions);
    }

	public GUIWellBeingChecker service1(PulseReadRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	public PulseReadResponse PulseReading(PulseReadRequest req) {
		// TODO Auto-generated method stub
		return null;
	}
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class WellBeingCheckerFutureStub extends io.grpc.stub.AbstractStub<WellBeingCheckerFutureStub> {
    private WellBeingCheckerFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WellBeingCheckerFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WellBeingCheckerFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WellBeingCheckerFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_PULSE_READING = 0;
  private static final int METHODID_STEPS_CALCULATOR = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final WellBeingCheckerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(WellBeingCheckerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PULSE_READING:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.pulseReading(
              (io.grpc.stub.StreamObserver<ds.serviceOne.PulseReadResponse>) responseObserver);
        case METHODID_STEPS_CALCULATOR:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.stepsCalculator(
              (io.grpc.stub.StreamObserver<ds.serviceOne.StepsCalcResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class WellBeingCheckerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    WellBeingCheckerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.serviceOne.ServiceOneImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("WellBeingChecker");
    }
  }

  private static final class WellBeingCheckerFileDescriptorSupplier
      extends WellBeingCheckerBaseDescriptorSupplier {
    WellBeingCheckerFileDescriptorSupplier() {}
  }

  private static final class WellBeingCheckerMethodDescriptorSupplier
      extends WellBeingCheckerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    WellBeingCheckerMethodDescriptorSupplier(String methodName) {
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
      synchronized (WellBeingCheckerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new WellBeingCheckerFileDescriptorSupplier())
              .addMethod(getPulseReadingMethod())
              .addMethod(getStepsCalculatorMethod())
              .build();
        }
      }
    }
    return result;
  }
}
