package ds.serviceThree;

import java.io.IOException;
import java.util.logging.Logger;

import ds.serviceThree.PatientMonitoringControlGrpc.PatientMonitoringControlImplBase;
import grpc.examples.bidirectionstreamstrings.StringRequest;
import grpc.examples.bidirectionstreamstrings.StringResponse;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class ServerThree extends PatientMonitoringControlImplBase{

	// First we create a logger to show server side logs in the console. logger instance will be used to log different events at the server console.
		private static final Logger logger = Logger.getLogger(ServerThree.class.getName());

		// Main method would contain the logic to start the server.	For throws keyword refer https://www.javatpoint.com/throw-keyword
				// NOTE: THIS LOGIC WILL BE SAME FOR ALL THE TYPES OF SERVICES
		 public static void main(String[] args) throws IOException, InterruptedException {
			    
			// The StringServer is the current file name/ class name. Using an instance of this class different methods could be invoked by the client.
			 ServerThree serverOne = new ServerThree();
			   
			 // This is the port number where server will be listening to clients. Refer - https://en.wikipedia.org/wiki/Port_(computer_networking)
			    int port = 50053;
			    
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
		 
		 public StreamObserver<StringRequest> reverseStream(StreamObserver<StringResponse> responseObserver) {
				return new StreamObserver<StringRequest>() {

					// For each message in the stream, get one stream at a time.
					// NOTE: YOU MAY MODIFY THE LOGIC OF onNext, onError, onCompleted BASED ON YOUR PROJECT.
					@Override
					public void onNext(StringRequest request) {
						// In bidirectional stream, both server and  client would be sending the stream of messages.
						// Here, for each message in stream from client, server is sending back one response.
							StringBuilder input1 = new StringBuilder(); 
						  
				            input1.append(request.getVal()); 
				            input1 = input1.reverse();
				        
				         // Preparing and sending the reply for the client. Here, response is build and with the value (input1.toString()) computed by above logic.
				            StringResponse reply = StringResponse.newBuilder().setVal(input1.toString()).build();
				      
				            responseObserver.onNext(reply);
						
					}

					@Override
					public void onError(Throwable t) {
						// TODO Auto-generated method stubal
						
					}

					@Override
					public void onCompleted() {
						 responseObserver.onCompleted();
						
					}
					
				};
			}
}
		 
		 
		 
		 
		