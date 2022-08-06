package ds.serviceOne;

import java.io.IOException;
import java.util.logging.Logger;

import ds.serviceOne.WellBeingCheckerGrpc.WellBeingCheckerImplBase;
import grpc.examples.clientstreamstrings.LengthResponse;
import grpc.examples.clientstreamstrings.StringRequest;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class ServerOne extends WellBeingCheckerImplBase{

	// First we create a logger to show server side logs in the console. logger instance will be used to log different events at the server console.
		private static final Logger logger = Logger.getLogger(ServerOne.class.getName());

		// Main method would contain the logic to start the server.	For throws keyword refer https://www.javatpoint.com/throw-keyword
				// NOTE: THIS LOGIC WILL BE SAME FOR ALL THE TYPES OF SERVICES
		 public static void main(String[] args) throws IOException, InterruptedException {
			    
			// The StringServer is the current file name/ class name. Using an instance of this class different methods could be invoked by the client.
			 ServerOne serverOne = new ServerOne();
			   
			 // This is the port number where server will be listening to clients. Refer - https://en.wikipedia.org/wiki/Port_(computer_networking)
			    int port = 50051;
			    
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
		 
		 public StreamObserver<PulseReadRequest> reverseStream(StreamObserver<PulseReadResponse> responseObserver) {
				return new StreamObserver<PulseReadRequest>() {

					// For each message in the stream, get one stream at a time.
					// NOTE: YOU MAY MODIFY THE LOGIC OF onNext, onError, onCompleted BASED ON YOUR PROJECT.
					@Override
					public void onNext(PulseReadRequest request) {
						// In bidirectional stream, both server and  client would be sending the stream of messages.
						// Here, for each message in stream from client, server is sending back one response.
							StringBuilder input1 = new StringBuilder(); 
						  
				            input1.append(request.getText()); 
				           
				        
				         // Preparing and sending the reply for the client. Here, response is build and with the value (input1.toString()) computed by above logic.
				            PulseReadResponse reply = PulseReadResponse.newBuilder().setTextback("testing").build();
				            
				            responseObserver.onNext(reply);
						
					}

					@Override
					public void onError(Throwable t) {
						
						
					}

					@Override
					public void onCompleted() {
						 responseObserver.onCompleted();
						
					}
					
				};}
				
				public StreamObserver<StepsCalcRequest> string(StreamObserver<StepsCalcResponse> responseObserver) {
					
					// Retrieve the value from the stream of requests of the client. 
					return new StreamObserver<StepsCalcRequest>() {
						
						
						// For each message in the stream, get one stream at a time.
						// NOTE: YOU MAY MODIFY THE LOGIC OF onNext, onError, onCompleted BASED ON YOUR PROJECT.
						
						
						public void onNext(StepsCalcRequest value) {
							// In bidirectional stream, both server and  client would be sending the stream of messages.
							// Here, for each message in stream from client, server is sending back one response.
								StringBuilder input2 = new StringBuilder(); 
							  
					            input2.append(value.getText()); 
					           
					        
					         // Preparing and sending the reply for the client. Here, response is build and with the value (input1.toString()) computed by above logic.
					            StepsCalcResponse reply2 = StepsCalcResponse.newBuilder().setTextback("testing2").build();
					            
					            responseObserver.onNext(reply2);;
							
						}

						@Override
						public void onError(Throwable t) {
							
							
						}

						@Override
						public void onCompleted() {
							 responseObserver.onCompleted();
							
						}

					
						
					};}
}