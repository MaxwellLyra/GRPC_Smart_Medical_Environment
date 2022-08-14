package ds.serviceThree;

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
    comments = "Source: PatientMonitoringControl.proto")
public final class PatientMonitoringControlGrpc {

  private PatientMonitoringControlGrpc() {}

  public static final String SERVICE_NAME = "service3.PatientMonitoringControl";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.serviceThree.VitCheckerRequest,
      ds.serviceThree.VitCheckerResponse> getVitalsCheckerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "VitalsChecker",
      requestType = ds.serviceThree.VitCheckerRequest.class,
      responseType = ds.serviceThree.VitCheckerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<ds.serviceThree.VitCheckerRequest,
      ds.serviceThree.VitCheckerResponse> getVitalsCheckerMethod() {
    io.grpc.MethodDescriptor<ds.serviceThree.VitCheckerRequest, ds.serviceThree.VitCheckerResponse> getVitalsCheckerMethod;
    if ((getVitalsCheckerMethod = PatientMonitoringControlGrpc.getVitalsCheckerMethod) == null) {
      synchronized (PatientMonitoringControlGrpc.class) {
        if ((getVitalsCheckerMethod = PatientMonitoringControlGrpc.getVitalsCheckerMethod) == null) {
          PatientMonitoringControlGrpc.getVitalsCheckerMethod = getVitalsCheckerMethod = 
              io.grpc.MethodDescriptor.<ds.serviceThree.VitCheckerRequest, ds.serviceThree.VitCheckerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "service3.PatientMonitoringControl", "VitalsChecker"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.serviceThree.VitCheckerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.serviceThree.VitCheckerResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new PatientMonitoringControlMethodDescriptorSupplier("VitalsChecker"))
                  .build();
          }
        }
     }
     return getVitalsCheckerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.serviceThree.PatUpdateRequest,
      ds.serviceThree.PatUpdateResponse> getPatientUpdateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PatientUpdate",
      requestType = ds.serviceThree.PatUpdateRequest.class,
      responseType = ds.serviceThree.PatUpdateResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.serviceThree.PatUpdateRequest,
      ds.serviceThree.PatUpdateResponse> getPatientUpdateMethod() {
    io.grpc.MethodDescriptor<ds.serviceThree.PatUpdateRequest, ds.serviceThree.PatUpdateResponse> getPatientUpdateMethod;
    if ((getPatientUpdateMethod = PatientMonitoringControlGrpc.getPatientUpdateMethod) == null) {
      synchronized (PatientMonitoringControlGrpc.class) {
        if ((getPatientUpdateMethod = PatientMonitoringControlGrpc.getPatientUpdateMethod) == null) {
          PatientMonitoringControlGrpc.getPatientUpdateMethod = getPatientUpdateMethod = 
              io.grpc.MethodDescriptor.<ds.serviceThree.PatUpdateRequest, ds.serviceThree.PatUpdateResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "service3.PatientMonitoringControl", "PatientUpdate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.serviceThree.PatUpdateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.serviceThree.PatUpdateResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new PatientMonitoringControlMethodDescriptorSupplier("PatientUpdate"))
                  .build();
          }
        }
     }
     return getPatientUpdateMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PatientMonitoringControlStub newStub(io.grpc.Channel channel) {
    return new PatientMonitoringControlStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PatientMonitoringControlBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new PatientMonitoringControlBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PatientMonitoringControlFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new PatientMonitoringControlFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class PatientMonitoringControlImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * rpc method for Bidirectional Streaming calls
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ds.serviceThree.VitCheckerRequest> vitalsChecker(
        io.grpc.stub.StreamObserver<ds.serviceThree.VitCheckerResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getVitalsCheckerMethod(), responseObserver);
    }

    /**
     * <pre>
     * rpc method for Server Streaming calls
     * </pre>
     */
    public void patientUpdate(ds.serviceThree.PatUpdateRequest request,
        io.grpc.stub.StreamObserver<ds.serviceThree.PatUpdateResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getPatientUpdateMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getVitalsCheckerMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                ds.serviceThree.VitCheckerRequest,
                ds.serviceThree.VitCheckerResponse>(
                  this, METHODID_VITALS_CHECKER)))
          .addMethod(
            getPatientUpdateMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.serviceThree.PatUpdateRequest,
                ds.serviceThree.PatUpdateResponse>(
                  this, METHODID_PATIENT_UPDATE)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class PatientMonitoringControlStub extends io.grpc.stub.AbstractStub<PatientMonitoringControlStub> {
    private PatientMonitoringControlStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PatientMonitoringControlStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PatientMonitoringControlStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PatientMonitoringControlStub(channel, callOptions);
    }

    /**
     * <pre>
     * rpc method for Bidirectional Streaming calls
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ds.serviceThree.VitCheckerRequest> vitalsChecker(
        io.grpc.stub.StreamObserver<ds.serviceThree.VitCheckerResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getVitalsCheckerMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * rpc method for Server Streaming calls
     * </pre>
     */
    public void patientUpdate(ds.serviceThree.PatUpdateRequest request,
        io.grpc.stub.StreamObserver<ds.serviceThree.PatUpdateResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPatientUpdateMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class PatientMonitoringControlBlockingStub extends io.grpc.stub.AbstractStub<PatientMonitoringControlBlockingStub> {
    private PatientMonitoringControlBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PatientMonitoringControlBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PatientMonitoringControlBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PatientMonitoringControlBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * rpc method for Server Streaming calls
     * </pre>
     */
    public ds.serviceThree.PatUpdateResponse patientUpdate(ds.serviceThree.PatUpdateRequest request) {
      return blockingUnaryCall(
          getChannel(), getPatientUpdateMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class PatientMonitoringControlFutureStub extends io.grpc.stub.AbstractStub<PatientMonitoringControlFutureStub> {
    private PatientMonitoringControlFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PatientMonitoringControlFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PatientMonitoringControlFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PatientMonitoringControlFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * rpc method for Server Streaming calls
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.serviceThree.PatUpdateResponse> patientUpdate(
        ds.serviceThree.PatUpdateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getPatientUpdateMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PATIENT_UPDATE = 0;
  private static final int METHODID_VITALS_CHECKER = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PatientMonitoringControlImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PatientMonitoringControlImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PATIENT_UPDATE:
          serviceImpl.patientUpdate((ds.serviceThree.PatUpdateRequest) request,
              (io.grpc.stub.StreamObserver<ds.serviceThree.PatUpdateResponse>) responseObserver);
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
        case METHODID_VITALS_CHECKER:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.vitalsChecker(
              (io.grpc.stub.StreamObserver<ds.serviceThree.VitCheckerResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class PatientMonitoringControlBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PatientMonitoringControlBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.serviceThree.ServiceThreeImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PatientMonitoringControl");
    }
  }

  private static final class PatientMonitoringControlFileDescriptorSupplier
      extends PatientMonitoringControlBaseDescriptorSupplier {
    PatientMonitoringControlFileDescriptorSupplier() {}
  }

  private static final class PatientMonitoringControlMethodDescriptorSupplier
      extends PatientMonitoringControlBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PatientMonitoringControlMethodDescriptorSupplier(String methodName) {
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
      synchronized (PatientMonitoringControlGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PatientMonitoringControlFileDescriptorSupplier())
              .addMethod(getVitalsCheckerMethod())
              .addMethod(getPatientUpdateMethod())
              .build();
        }
      }
    }
    return result;
  }
}
