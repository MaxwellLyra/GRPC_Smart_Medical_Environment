package ds.serviceOne;

//libraries' imports
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

// creating a class for ServerOne
public class ServerOne extends WellBeingCheckerImplBase {

	public static void main(String[] args) {
		// instantiating server and registering info
		ServerOne serverOne = new ServerOne();

		Properties prop = serverOne.getProperties();

		serverOne.registerService(prop);

		int port = Integer.valueOf(prop.getProperty("service_port"));// #.50051;

		try {

			Server server = ServerBuilder.forPort(port).addService(serverOne).build().start();

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

			// load properties file
			prop.load(input);

			// get the property value and print it out
			System.out.println("ServerOne properies ...");
			System.out.println("\t service_type: " + prop.getProperty("service_type"));
			System.out.println("\t service_name: " + prop.getProperty("service_name"));
			System.out.println("\t service_description: " + prop.getProperty("service_description"));
			System.out.println("\t service_port: " + prop.getProperty("service_port"));

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return prop;
	}

	private void registerService(Properties prop) {

		try {
			// Create a JmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

			String service_type = prop.getProperty("service_type");// "_http._tcp.local.";
			String service_name = prop.getProperty("service_name");// "wellBeingChecker";
			// int service_port = 1234;
			int service_port = Integer.valueOf(prop.getProperty("service_port"));// #.50051;

			String service_description_properties = prop.getProperty("service_description");// "path=index.html";

			// Register a service
			ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port,
					service_description_properties);
			jmdns.registerService(serviceInfo);

			System.out.printf("registrering service with type %s and name %s \n", service_type, service_name);

			// Wait a bit
			Thread.sleep(1000);

			// Unregister all services
			// jmdns.unregisterAllServices();

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// rpc method for Bidirectional Streaming calls
	public StreamObserver<PulseReadRequest> PulseReading(StreamObserver<PulseReadResponse> responseObserver) {
		return new StreamObserver<PulseReadRequest>() {

			@Override
			public void onNext(PulseReadRequest request) {
				// In bidirectional stream, both server and client would be sending the stream
				// of messages.
				// Here, for each message in stream from client, server is sending back one
				// response.

				int input = request.getNum();
				String msg = "low rate";

				if (input > 28) {
					msg = "high rate";
				}
				else if (input > 25 || input < 28) {
					msg = "normal rate";
				}
				// Preparing and sending the reply for the client.				
				PulseReadResponse reply = PulseReadResponse.newBuilder().setTextback(msg).build();

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

	// rpc method for Client Streaming calls
	public StreamObserver<StepsCalcRequest> StepsCalculator(StreamObserver<StepsCalcResponse> responseObserver) {

		// Retrieve the value from the stream of requests of the client.
		return new StreamObserver<StepsCalcRequest>() {

			// For each message in the stream, get one stream at a time.
			public void onNext(StepsCalcRequest steps) {
				

				int goal = 10000;
				int done = steps.getSteps();
				String text = "";
				int stepsLeft = 0;
				
				if (done > 10000) {
					stepsLeft = goal - done;
					text = "You still have left ";
				}
				else if (done >= 10000) {
					stepsLeft = goal + done;
					text = "Congrats! You've achieved your daily goal!";
				}
				
				// Preparing and sending the reply for the client.				
				StepsCalcResponse reply = StepsCalcResponse.newBuilder().setStepsleft(stepsLeft).setTextback(text).build();

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
}