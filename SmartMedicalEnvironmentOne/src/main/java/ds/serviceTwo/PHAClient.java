package ds.serviceTwo;

import ds.serviceTwo.BMICalcRequest;
import ds.serviceTwo.BMICalcResponse;
import ds.serviceTwo.PersonalHealthAssistantGrpc;
import ds.serviceTwo.PersonalHealthAssistantGrpc.PersonalHealthAssistantBlockingStub;
import ds.serviceTwo.PersonalHealthAssistantGrpc.PersonalHealthAssistantStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;


public class PHAClient {
	
		private static PersonalHealthAssistantBlockingStub blockingStub;
		private static PersonalHealthAssistantStub asyncStub;


		public static void main(String[] args) {

			ManagedChannel channel = ManagedChannelBuilder
					.forAddress("localhost", 50052)
					.usePlaintext()
					.build();

			//stubs -- generate from proto
			blockingStub = PersonalHealthAssistantGrpc.newBlockingStub(channel);

			asyncStub = PersonalHealthAssistantGrpc.newStub(channel);


			
			BMICalculator();
			//MedicineStock();
			
			
			
		}

		
		public static void BMICalculator() {
			int num1 = 10;
			int num2 = 20;

			BMICalcRequest req = BMICalcRequest.newBuilder().setHeight(num1).setWeigth(num2).build();

			BMICalcResponse response = blockingStub.BMICalculator(req);

			System.out.println("res: " + response.getResult());
		}
		
		//public static void MedicineStock() {
			
		//}
		
}
