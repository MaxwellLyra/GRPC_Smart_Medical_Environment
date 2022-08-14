package ds.serviceThree;


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

import ds.serviceOne.StepsCalcRequest;
import ds.serviceOne.StepsCalcResponse;
import ds.serviceThree.PatientMonitoringControlGrpc.PatientMonitoringControlBlockingStub;
import ds.serviceThree.PatientMonitoringControlGrpc.PatientMonitoringControlStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;


import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

public class GUIPatientMonitoringControl {

	private static PatientMonitoringControlBlockingStub blockingStub;
	private static PatientMonitoringControlStub asyncStub;

	private ServiceInfo serviceInfo;
	
	
	private JFrame frame;
	private JTextField textNumber1;
	private JTextField textNumber2;
	private JTextArea textResponse ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIPatientMonitoringControl window = new GUIPatientMonitoringControl();
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
	public GUIPatientMonitoringControl() {
		
		String service_type = "_serverThree._tcp.local.";
		discoverService(service_type);
		
		String host = serviceInfo.getHostAddresses()[0];
		int port = serviceInfo.getPort();
		
		ManagedChannel channel = ManagedChannelBuilder
				.forAddress(host, port)
				.usePlaintext()
				.build();

		//stubs -- generate from proto
		blockingStub = PatientMonitoringControlGrpc.newBlockingStub(channel);

		asyncStub = PatientMonitoringControlGrpc.newStub(channel);

		
		initialize();
	}

	
	
	private void discoverService(String service_type) {
		
		
		try {
			// Create a JmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

				
			jmdns.addServiceListener(service_type, new ServiceListener() {
				
				@Override
				public void serviceResolved(ServiceEvent event) {
					System.out.println("Math Service resolved: " + event.getInfo());

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
					System.out.println("Math Service removed: " + event.getInfo());

					
				}
				
				@Override
				public void serviceAdded(ServiceEvent event) {
					System.out.println("Math Service added: " + event.getInfo());

					
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
		
		JLabel lblNewLabel_1 = new JLabel("Check");
		panel_service_1.add(lblNewLabel_1);
		
		textNumber1 = new JTextField();
		panel_service_1.add(textNumber1);
		textNumber1.setColumns(10);
				
		JButton btnCheck = new JButton("Check now");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String text = textNumber1.getText();
				
				
				VitCheckerRequest req = VitCheckerRequest.newBuilder().setText(text).build();

				VitCheckerResponse response = blockingStub.VitalsChecker(req);

								
				textResponse.append(response.getTextback());
				
				System.out.println("res: " + response.getTextback());

			}
		});
		panel_service_1.add(btnCheck);
		
		textResponse = new JTextArea(3, 20);
		textResponse .setLineWrap(true);
		textResponse.setWrapStyleWord(true);
		
		JScrollPane scrollPane = new JScrollPane(textResponse);
		
		//textResponse.setSize(new Dimension(15, 30));
		panel_service_1.add(scrollPane);
		
		
		JPanel panel_service_2 = new JPanel();
		frame.getContentPane().add(panel_service_2);
		panel_service_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_2 = new JLabel("Pulse");
		panel_service_2.add(lblNewLabel_2);
		
		textNumber2 = new JTextField();
		panel_service_2.add(textNumber2);
		textNumber2.setColumns(10);
		
		JButton btnCalculate2 = new JButton("Count steps");
		btnCalculate2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int steps = Integer.parseInt(textNumber2.getText());
						
								
				StepsCalcRequest req = StepsCalcRequest.newBuilder().setSteps(num1).build();
						
				StepsCalcResponse response = blockingStub.StepsCalculator(req);

				textResponse.append(response.getTextback() + response.getStepsleft());
				
				System.out.println("res: " + response.getTextback() + response.getStepsleft());

			}
		});
		
		panel_service_2.add(btnCalculate2);
		
		textResponse = new JTextArea(3, 20);
		textResponse .setLineWrap(true);
		textResponse.setWrapStyleWord(true);
		
		JScrollPane scrollPane2 = new JScrollPane(textResponse);
		
		//textResponse.setSize(new Dimension(15, 30));
		panel_service_1.add(scrollPane);
		
		
		
		
	}

}
