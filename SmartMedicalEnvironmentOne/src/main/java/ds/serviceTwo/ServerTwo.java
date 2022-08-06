package ds.serviceTwo;

import java.io.IOException;
import java.util.logging.Logger;

import ds.serviceTwo.PersonalHealthAssistantGrpc.PersonalHealthAssistantImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class ServerTwo extends PersonalHealthAssistantImplBase{

	// First we create a logger to show server side logs in the console. logger instance will be used to log different events at the server console.
		private static final Logger logger = Logger.getLogger(ServerTwo.class.getName());

		// Main method would contain the logic to start the server.	For throws keyword refer https://www.javatpoint.com/throw-keyword
				// NOTE: THIS LOGIC WILL BE SAME FOR ALL THE TYPES OF SERVICES
		 public static void main(String[] args) throws IOException, InterruptedException {
			    
			// The StringServer is the current file name/ class name. Using an instance of this class different methods could be invoked by the client.
			 ServerTwo serverOne = new ServerTwo();
			   
			 // This is the port number where server will be listening to clients. Refer - https://en.wikipedia.org/wiki/Port_(computer_networking)
			    int port = 50052;
			    
			    // Here, we create a server on the port defined in in variable "port" and attach a service "stringserver" (instance of the class) defined above.
			    Server server = ServerBuilder.forPort(port) // Port is defined in line 34
			        .addService(serverOne) // Service is defined in line 31
			        .build() // Build the server
			        .start(); // Start the server and keep it running for clients to contact.
			    
			    // Giving a logging information on the server console that server has started
			    logger.info("Server started, listening on " + port);
			    		    
			    // Server will be running until externally terminated.
			    server.awaitTermination();
		 }
		 
		 
		 public StreamObserver<BMICalcRequest> BMICalculator(StreamObserver<BMICalcResponse> responseObserver) {
				
				// Retrieve the value from the stream of requests of the client. 
				return new StreamObserver<BMICalcRequest>() {
					
					int result = 0;
					
					// For each message in the stream, get one stream at a time.
					// NOTE: YOU MAY MODIFY THE LOGIC OF onNext, onError, onCompleted BASED ON YOUR PROJECT.
					
					public void onNext(BMICalcRequest value) {
						// Here, in this example we compute the value of string length for each message in the stream. 
						System.out.println("receive -> " + value.getHeight());
						System.out.println("receive -> " + value.getWeigth());
						// Keep on adding all the length values to compute the total length of strings sent by the client in the stream 
						result = value.getWeigth() / (value.getHeight()*2);
						
					}

					@Override
					public void onError(Throwable t) {
						// TODO Auto-generated method stub
						
					}

					// Once the complete stream is received this logic will be executed.
					@Override
					public void onCompleted() {
						// Preparing and sending the reply for the client. Here, response is build and with the value (length) computed by above logic.
						 // Here, response is sent once the client is done with sending the stream.
						BMICalcResponse response = BMICalcResponse.newBuilder().setResult(result).build();
				          responseObserver.onNext(response);
				          responseObserver.onCompleted();
					}
				};

				}
				
				public void MedicineStock(MedStockRequest request, StreamObserver<MedStockResponse> responseObserver2) {
					 System.out.println("receiving split");
					 
					// Retrieve the value from the request of the client and convert it to array
					 String search = request.getText();
					 
					// LOGIC of THE METHOD 
						// NOTE: YOU MAY NEED TO MODIFY THIS LOGIC HERE.
					 if (search.equalsIgnoreCase("Paracetamol")) {
						 responseObserver2.onNext(MedStockResponse.newBuilder().setTextback("32, Jervis St. - Shamroock Pharmacy").build());
					 }
					 else if (search.equalsIgnoreCase("Panadol")) {
						 responseObserver2.onNext(MedStockResponse.newBuilder().setTextback("101, Dame St. - Boots Pharmacy").build());
					 }
										 
					 responseObserver2.onCompleted();
				}
			}
		 
		