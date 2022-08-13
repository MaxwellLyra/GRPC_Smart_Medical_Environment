package ds.serviceTwo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Properties;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import ds.serviceTwo.ServerTwo;
import ds.serviceTwo.PersonalHealthAssistantGrpc.PersonalHealthAssistantImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class ServerTwo extends PersonalHealthAssistantImplBase{

	public static void main(String[] args) {
		ServerTwo serverTwo = new ServerTwo();

		Properties prop = serverTwo.getProperties();
		
		serverTwo.registerService(prop);
		
		int port = Integer.valueOf( prop.getProperty("service_port") );// #.50052;

		try {

			Server server = ServerBuilder.forPort(port)
					.addService(serverTwo)
					.build()
					.start();

			System.out.println("ServerTwo started, listening on " + port);

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
		
		 try (InputStream input = new FileInputStream("src/main/resources/serverTwo.properties")) {

	            prop = new Properties();

	            // load a properties file
	            prop.load(input);

	            // get the property value and print it out
	            System.out.println("ServerTwo properies ...");
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
	            
	            String service_type = prop.getProperty("service_type") ;//"_serverTwo._tcp.local.";
	            String service_name = prop.getProperty("service_name")  ;// "personalHelthAssistant";
	           // int service_port = 1234;
	            int service_port = Integer.valueOf( prop.getProperty("service_port") );// #.50052;

	            
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
		 
		