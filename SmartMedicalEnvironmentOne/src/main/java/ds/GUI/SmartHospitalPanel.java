package ds.GUI;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ds.serviceOne.WellBeingCheckerGrpc;
import ds.serviceOne.WellBeingCheckerGrpc.WellBeingCheckerBlockingStub;
import ds.serviceThree.PatientMonitoringControlGrpc.PatientMonitoringControlStub;
import ds.serviceTwo.PersonalHealthAssistantGrpc;
import ds.serviceTwo.PersonalHealthAssistantGrpc.PersonalHealthAssistantBlockingStub;
import ds.serviceTwo.PersonalHealthAssistantGrpc.PersonalHealthAssistantStub;
import ds.serviceThree.PatientMonitoringControlGrpc;
import ds.serviceThree.PatientMonitoringControlGrpc.PatientMonitoringControlBlockingStub;
import ds.serviceThree.PatientMonitoringControlGrpc.PatientMonitoringControlStub;
//import ds.service3.Service3Grpc;
//import ds.service4.Service4Grpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;


public class SmartHospitalPanel implements ActionListener{


	private JTextField entry1, reply1;
	private JTextField entry2, reply2;
	private JTextField entry3, reply3;
	private JTextField entry4, reply4;
	private JTextField entry5, reply5;
	private JTextField entry6, reply6;


	private JPanel getService1JPanel() {

		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		JLabel label = new JLabel("Enter pulse");
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry1 = new JTextField("",10);
		panel.add(entry1);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button = new JButton("Check blood pressure");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		reply1 = new JTextField("", 10);
		reply1 .setEditable(false);
		panel.add(reply1 );

		panel.setLayout(boxlayout);

		return panel;
		
		
	}	

	private JPanel getService2JPanel() {

		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		JLabel label = new JLabel("Enter height")	;
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry2 = new JTextField("",10);
		panel.add(entry2);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button = new JButton("Check IBM");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		reply2 = new JTextField("", 10);
		reply2 .setEditable(false);
		panel.add(reply2 );

		panel.setLayout(boxlayout);

		return panel;

	}

	private JPanel getService3JPanel() {

		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		JLabel label = new JLabel("Patient Vitals")	;
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry3 = new JTextField("",10);
		panel.add(entry3);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button = new JButton("Check");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		reply3 = new JTextField("", 10);
		reply3 .setEditable(false);
		panel.add(reply3 );

		panel.setLayout(boxlayout);

		return panel;

	}

	private JPanel getService4JPanel() {

		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		JLabel label = new JLabel("Enter value")	;
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry4 = new JTextField("",10);
		panel.add(entry4);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button = new JButton("Invoke Service 4");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		reply4 = new JTextField("", 10);
		reply4 .setEditable(false);
		panel.add(reply4 );

		panel.setLayout(boxlayout);

		return panel;

	}
	
	private JPanel getService5JPanel() {

		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		JLabel label = new JLabel("Enter value")	;
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry5 = new JTextField("",10);
		panel.add(entry5);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button = new JButton("Invoke Service 5");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		reply5 = new JTextField("", 10);
		reply5 .setEditable(false);
		panel.add(reply5 );

		panel.setLayout(boxlayout);

		return panel;

	}
	
	private JPanel getService6JPanel() {

		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		JLabel label = new JLabel("Enter value")	;
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry6 = new JTextField("",10);
		panel.add(entry6);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button = new JButton("Invoke Service 6");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		reply6 = new JTextField("", 10);
		reply6 .setEditable(false);
		panel.add(reply6 );

		panel.setLayout(boxlayout);

		return panel;

	}
	
	
	public static void main(String[] args) {

		SmartHospitalPanel gui = new SmartHospitalPanel();

		gui.build();
	}

	private void build() { 

		JFrame frame = new JFrame("Smart Medical Environment");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set the panel to add buttons
		JPanel panel = new JPanel();

		// Set the BoxLayout to be X_AXIS: from left to right
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

		panel.setLayout(boxlayout);

		// Set border for the panel
		panel.setBorder(new EmptyBorder(new Insets(50, 100, 50, 100)));
	
		panel.add( getService1JPanel() );
		panel.add( getService2JPanel() );
		panel.add( getService3JPanel() );
		panel.add( getService4JPanel() );
		panel.add( getService5JPanel() );
		panel.add( getService6JPanel() );

		// Set size for the frame
		frame.setSize(300, 300);

		// Set the window to be visible as the default to be false
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		String label = button.getActionCommand();  

		if (label.equals("Invoke Service 1")) {
			System.out.println("Pulse Reading ...");
			
			
			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
			WellBeingCheckerBlockingStub blockingStub = WellBeingCheckerGrpc.newBlockingStub(channel);

			//preparing message to send
			ds.serviceOne.PulseReadRequest request = ds.serviceOne.PulseReadRequest.newBuilder().setText(entry1.getText()).build();

			//retrieving reply from service
			ds.serviceOne.PulseReadResponse response = ds.serviceOne.PulseReadResponse.newBuilder().setTextback("High blood pressure").build();
			
			reply1.setText(String.valueOf( response.getTextback()));
			
			////
						
			ds.serviceOne.StepsCalcRequest request2 = ds.serviceOne.StepsCalcRequest.newBuilder().setText(entry4.getText()).build();

			//retrieving reply from service
			ds.serviceOne.StepsCalcResponse response2 = ds.serviceOne.StepsCalcResponse.newBuilder().setTextback("3000 steps").build();
			
			reply4.setText(String.valueOf( response2.getTextback()));
			
			
		}else if (label.equals("Invoke Service 2")) {
			System.out.println("BMI calculator ...");

					 
			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
			PersonalHealthAssistantBlockingStub blockingStub = PersonalHealthAssistantGrpc.newBlockingStub(channel);
			
			//preparing message to send
			ds.serviceTwo.BMICalcRequest request1 = ds.serviceTwo.BMICalcRequest.newBuilder().setHeight(entry2.getHeight()).build();
			ds.serviceTwo.BMICalcRequest request2 = ds.serviceTwo.BMICalcRequest.newBuilder().setWeigth(75).build();
			
			//retrieving reply from service
			ds.serviceTwo.BMICalcResponse response = ds.serviceTwo.BMICalcResponse.newBuilder().setResult(25).build();

			reply2.setText( String.valueOf( response.getResult()));
	
			
		}else if (label.equals("Invoke Service 3")) {
			System.out.println("Vitals checker ...");
		
			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50053).usePlaintext().build();
			PatientMonitoringControlBlockingStub blockingStub = PatientMonitoringControlGrpc.newBlockingStub(channel);

			//preparing message to send
			ds.serviceThree.VitCheckerRequest request = ds.serviceThree.VitCheckerRequest.newBuilder().setText(entry3.getText()).build();

			//retreving reply from service
			ds.serviceThree.VitCheckerResponse response = ds.serviceThree.VitCheckerResponse.newBuilder().setTextback("Pressure: Ok | Heart: ok").build();

			reply3.setText( String.valueOf( response.getTextback()));
		
		}
		
	}
}
	

	
