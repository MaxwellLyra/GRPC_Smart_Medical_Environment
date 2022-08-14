package ds.serviceOne;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import ds.serviceOne.PulseReadRequest;
import ds.serviceOne.PulseReadResponse;
import ds.serviceOne.WellBeingCheckerGrpc;
import ds.serviceOne.WellBeingCheckerGrpc.WellBeingCheckerBlockingStub;
import ds.serviceOne.WellBeingCheckerGrpc.WellBeingCheckerStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;


import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

public class GUIWellBeingChecker {

		private static WellBeingCheckerBlockingStub blockingStub;
		private static WellBeingCheckerStub asyncStub;

		private ServiceInfo serviceInfo;
		
		
		private JFrame frame;
		private JTextField text1;
		private JTextField text2;
		private JTextArea textResponse ;

		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						GUIWellBeingChecker window = new GUIWellBeingChecker();
						window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		/**
		 * Create the application.
		 */
		public GUIWellBeingChecker() {
			
			String service_type = "_serverOne._tcp.local.";
			discoverService(service_type);
			
			String host = serviceInfo.getHostAddresses()[0];
			int port = serviceInfo.getPort();
			
			ManagedChannel channel = ManagedChannelBuilder
					.forAddress(host, port)
					.usePlaintext()
					.build();

			//stubs -- generate from proto
			blockingStub = WellBeingCheckerGrpc.newBlockingStub(channel);

			asyncStub = WellBeingCheckerGrpc.newStub(channel);

			
			initialize();
		}

		
		
		private void discoverService(String service_type) {
			
			
			try {
				// Create a JmDNS instance
				JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

					
				jmdns.addServiceListener(service_type, new ServiceListener() {
					
					@Override
					public void serviceResolved(ServiceEvent event) {
						System.out.println("Service resolved: " + event.getInfo());

						serviceInfo = event.getInfo();

						int port = serviceInfo.getPort();
						
						System.out.println("resolving " + service_type + " with properties ...");
						System.out.println("\t port: " + port);
						System.out.println("\t type:"+ event.getType());
						System.out.println("\t name: " + event.getName());
						System.out.println("\t description/properties: " + serviceInfo.getNiceTextString());
						System.out.println("\t host: " + serviceInfo.getHostAddresses()[0]);
					
						
					}
					
					@Override
					public void serviceRemoved(ServiceEvent event) {
						System.out.println("Service removed: " + event.getInfo());

						
					}
					
					@Override
					public void serviceAdded(ServiceEvent event) {
						System.out.println("Service added: " + event.getInfo());

						
					}
				});
				
				// Wait a bit
				Thread.sleep(2000);
				
				jmdns.close();

			} catch (UnknownHostException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() {
			frame = new JFrame();
			frame.setTitle("Client - Service Controller");
			frame.setBounds(100, 100, 500, 300);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			BoxLayout bl = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
			
			frame.getContentPane().setLayout(bl);
			
			JPanel panel_service_1 = new JPanel();
			frame.getContentPane().add(panel_service_1);
			panel_service_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			
			JLabel lblNewLabel_1 = new JLabel("Number 1");
			panel_service_1.add(lblNewLabel_1);
			
			text1 = new JTextField();
			panel_service_1.add(text1);
			text1.setColumns(10);
			
			JLabel lblNewLabel_2 = new JLabel("Number 2");
			panel_service_1.add(lblNewLabel_2);
			
			text2 = new JTextField();
			panel_service_1.add(text2);
			text2.setColumns(10);
			
		
			
			JButton btnCalculate = new JButton("Calculate");
			btnCalculate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					int num1 = Integer.parseInt(text1.getText());
									
					PulseReadRequest req = PulseReadRequest.newBuilder().setNum(num1).build();
							
					PulseReadResponse response = PulseReadResponse.newBuilder().setTextback("hi").build();

					textResponse.append("reply:"+ response.getTextback());
					
					System.out.println("res: " + response.getTextback());

				}
			});
			
			panel_service_1.add(btnCalculate);
			
			textResponse = new JTextArea(3, 20);
			textResponse .setLineWrap(true);
			textResponse.setWrapStyleWord(true);
			
			JScrollPane scrollPane = new JScrollPane(textResponse);
			
			//textResponse.setSize(new Dimension(15, 30));
			panel_service_1.add(scrollPane);
			
			
			JPanel panel_service_2 = new JPanel();
			frame.getContentPane().add(panel_service_2);
			
			JPanel panel_service_3 = new JPanel();
			frame.getContentPane().add(panel_service_3);
			
			
			
		}

	}
