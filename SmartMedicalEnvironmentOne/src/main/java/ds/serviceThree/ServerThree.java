package ds.serviceThree;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Properties;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import ds.serviceThree.PatientMonitoringControlGrpc.PatientMonitoringControlImplBase;
import ds.serviceThree.ServerThree;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;


public class ServerThree extends PatientMonitoringControlImplBase{

	public static void main(String[] args) {
		ServerThree serverThree = new ServerThree();

		Properties prop = serverThree.getProperties();
		
		serverThree.registerService(prop);
		
		int port = Integer.valueOf( prop.getProperty("service_port") );// #.50053;

		try {

			Server server = ServerBuilder.forPort(port)
					.addService(serverThree)
					.build()
					.start();

			System.out.println("ServerThree started, listening on " + port);

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
		
		 try (InputStream input = new FileInputStream("src/main/resources/serverThree.properties")) {

	            prop = new Properties();

	            // load a properties file
	            prop.load(input);

	            // get the property value and print it out
	            System.out.println("ServerThree properies ...");
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
	            
	            String service_type = prop.getProperty("service_type") ;//"_serverThree._tcp.local.";
	            String service_name = prop.getProperty("service_name")  ;// "patientMonitoringControl";
	           
	            // int service_port = 1234;
	            int service_port = Integer.valueOf( prop.getProperty("service_port") );// #.50053;

	            
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
	
	// rpc method for Bidirectional Streaming calls
	public StreamObserver<VitCheckerRequest> VitalsChecker(StreamObserver<VitCheckerResponse> responseObserver) {
		
		return new StreamObserver<VitCheckerRequest>() {
			
			@Override
			public void onNext(VitCheckerRequest request) {
				// In bidirectional stream, both server and client would be sending the stream
				// of messages.
				// Here, for each message in stream from client, server is sending back one
				// response.

				String name = request.getText();
				String output = "";
				
				if (name.equalsIgnoreCase("Heart")) {
					output = "High heart rate";
				}
				else if (name.equalsIgnoreCase("Brain")) {
					output = "Normal brain activity";
				}
				else if (name.equalsIgnoreCase("Pulse")) {
					output = "Low pulse";
				}
				
				// Preparing and sending the reply for the client.				
				VitCheckerResponse reply = VitCheckerResponse.newBuilder().setTextback(output).build();

				responseObserver.onNext(reply);
				;


			}

			@Override
			public void onError(Throwable t) {

			}

			@Override
			public void onCompleted() {
				responseObserver.onCompleted();

			}

		};
	}
		
	// rpc method for Server Streaming calls
		 public void PatientUpdate(PatUpdateRequest request, StreamObserver<PatUpdateResponse> responseObserver) {
				
				System.out.print("Receiving patient updates");
				
				// Retrieve the value from the request of the client
				String patient = (request.getText());
				
				// LOGIC of THE METHOD 
				// NOTE: YOU MAY NEED TO MODIFY THIS LOGIC HERE.
				String update = patient + "Status: Patient in observation";
				
				
				// Preparing the reply for the client. Here, response is build and with the value (output) computed by above logic.  
				PatUpdateResponse reply = PatUpdateResponse.newBuilder().setTextback(update).build();
				
				// Sending the reply for each request.
				responseObserver.onNext(reply);
				
				responseObserver.onCompleted();
			}
}
		 
		 
		 
		 
		