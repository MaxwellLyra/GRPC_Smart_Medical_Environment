package ds.serviceOne;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Properties;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import ds.serviceOne.WellBeingCheckerGrpc.WellBeingCheckerImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class ServerOne extends WellBeingCheckerImplBase {


	public static void main(String[] args) {
		ServerOne serverOne = new ServerOne();

		Properties prop = serverOne.getProperties();
		
		serverOne.registerService(prop);
		
		int port = Integer.valueOf( prop.getProperty("service_port") );// #.50051;

		try {

			Server server = ServerBuilder.forPort(port)
					.addService(serverOne)
					.build()
					.start();

			System.out.println("ServerOne started, listening on " + port);

			server.awaitTermination();


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	
	private Properties getProperties() {
		
		Properties prop = null;		
		
		 try (InputStream input = new FileInputStream("src/main/resources/serverOne.properties")) {

	            prop = new Properties();

	            // load a properties file
	            prop.load(input);

	            // get the property value and print it out
	            System.out.println("ServerOne properies ...");
	            System.out.println("\t service_type: " + prop.getProperty("service_type"));
	            System.out.println("\t service_name: " +prop.getProperty("service_name"));
	            System.out.println("\t service_description: " +prop.getProperty("service_description"));
		        System.out.println("\t service_port: " +prop.getProperty("service_port"));

	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	
		 return prop;
	}
	
	
	private  void registerService(Properties prop) {
		
		 try {
	            // Create a JmDNS instance
	            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
	            
	            String service_type = prop.getProperty("service_type") ;//"_serverOne._tcp.local.";
	            String service_name = prop.getProperty("service_name")  ;// "wellBeingChecker";
	           // int service_port = 1234;
	            int service_port = Integer.valueOf( prop.getProperty("service_port") );// #.50051;

	            
	            String service_description_properties = prop.getProperty("service_description")  ;//"path=index.html";
	            
	            // Register a service
	            ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port, service_description_properties);
	            jmdns.registerService(serviceInfo);
	            
	            System.out.printf("registrering service with type %s and name %s \n", service_type, service_name);
	            
	            // Wait a bit
	            Thread.sleep(1000);

	            // Unregister all services
	            //jmdns.unregisterAllServices();

	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    
	}
	
		 
		 public StreamObserver<PulseReadRequest> PulseReading(StreamObserver<PulseReadResponse> responseObserver) {
				return new StreamObserver<PulseReadRequest>() {

					// For each message in the stream, get one stream at a time.
					// NOTE: YOU MAY MODIFY THE LOGIC OF onNext, onError, onCompleted BASED ON YOUR PROJECT.
					@Override
					public void onNext(PulseReadRequest request) {
						// In bidirectional stream, both server and  client would be sending the stream of messages.
						// Here, for each message in stream from client, server is sending back one response.
							StringBuilder input1 = new StringBuilder(); 
						  
				            input1.append(request.getNum());
				           
				        
				         // Preparing and sending the reply for the client. Here, response is build and with the value (input1.toString()) computed by above logic.
				            PulseReadResponse reply = PulseReadResponse.newBuilder().setTextback("").build();
				            
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
				
				public StreamObserver<StepsCalcRequest> StepsCalculator(StreamObserver<StepsCalcResponse> responseObserver) {
					
					// Retrieve the value from the stream of requests of the client. 
					return new StreamObserver<StepsCalcRequest>() {
						
						
						// For each message in the stream, get one stream at a time.
						// NOTE: YOU MAY MODIFY THE LOGIC OF onNext, onError, onCompleted BASED ON YOUR PROJECT.
						
						
						public void onNext(StepsCalcRequest value) {
							// In bidirectional stream, both server and  client would be sending the stream of messages.
							// Here, for each message in stream from client, server is sending back one response.
								StringBuilder input = new StringBuilder(); 
							  
					            input.append(value.getNum()); 
					           
					        
					         // Preparing and sending the reply for the client. Here, response is build and with the value (input1.toString()) computed by above logic.
					            StepsCalcResponse reply = StepsCalcResponse.newBuilder().setTextback("testing2").build();
					            
					            responseObserver.onNext(reply);;
							
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