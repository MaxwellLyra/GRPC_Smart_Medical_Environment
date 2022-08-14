package ds.serviceOne;

import ds.serviceOne.PulseReadRequest;
import ds.serviceOne.PulseReadResponse;
import ds.serviceOne.WellBeingCheckerGrpc.WellBeingCheckerBlockingStub;
import ds.serviceOne.WellBeingCheckerGrpc.WellBeingCheckerStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;


public class WBCClient {

	private static WellBeingCheckerBlockingStub blockingStub;
	private static WellBeingCheckerStub asyncStub;


	public static void main(String[] args) {

		ManagedChannel channel = ManagedChannelBuilder
				.forAddress("localhost", 50051)
				.usePlaintext()
				.build();

		//stubs -- generated from proto
		blockingStub = WellBeingCheckerGrpc.newBlockingStub(channel);

		asyncStub = WellBeingCheckerGrpc.newStub(channel);

		
		PulseReading();
		//StepsCalculator();
		
	}
	
	public static void PulseReading() {
		int num1 = 1;
		
		
		PulseReadRequest req = PulseReadRequest.newBuilder().setNum(num1).build();

		PulseReadResponse response = blockingStub.PulseReading(req);

		System.out.println("res: " + response.getTextback());
	}

	
	//public static void StepsCalculator() {
		
	//}
	
	}