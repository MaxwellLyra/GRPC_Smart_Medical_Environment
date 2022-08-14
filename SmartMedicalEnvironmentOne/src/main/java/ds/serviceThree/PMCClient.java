package ds.serviceThree;

import ds.serviceThree.PatientMonitoringControlGrpc;
import ds.serviceThree.PatientMonitoringControlGrpc.PatientMonitoringControlBlockingStub;
import ds.serviceThree.PatientMonitoringControlGrpc.PatientMonitoringControlStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class PMCClient {

	private static PatientMonitoringControlBlockingStub blockingStub;
	private static PatientMonitoringControlStub asyncStub;


	public static void main(String[] args) {

		ManagedChannel channel = ManagedChannelBuilder
				.forAddress("localhost", 50053)
				.usePlaintext()
				.build();

		//stubs -- generate from proto
		blockingStub = PatientMonitoringControlGrpc.newBlockingStub(channel);

		asyncStub = PatientMonitoringControlGrpc.newStub(channel);


		
		VitalsChecker();
		//PatientUpdate();
				
		
	}

	
	public static void VitalsChecker() {
		String text1 = "check";
		String text2 = "heart rate: ok";

		VitCheckerRequest req = VitCheckerRequest.newBuilder().setText(text1).build();

		VitCheckerResponse response = blockingStub.VitalsChecker(req);

		System.out.println("res: " + response.getTextback());
	}
	
	//public static void PatientUpdate() {
		
	//}
}
