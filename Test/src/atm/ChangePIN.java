package atm;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class ChangePIN extends JFrame{

	private static final long serialVersionUID = 1L;
	static ChangePIN window = new ChangePIN();
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ChangePIN() {
		getContentPane().setLayout(null);
		
		JLabel lblOLDPIN = new JLabel("OLD PIN");
		lblOLDPIN.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOLDPIN.setBounds(88, 23, 53, 14);
		getContentPane().add(lblOLDPIN);
		
		JLabel lblNEWPIN = new JLabel("NEW PIN");
		lblNEWPIN.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNEWPIN.setBounds(88, 53, 53, 14);
		getContentPane().add(lblNEWPIN);
		
		JLabel lblConfirmNewPin = new JLabel("CONFIRM NEW PIN");
		lblConfirmNewPin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConfirmNewPin.setBounds(23, 83, 118, 14);
		getContentPane().add(lblConfirmNewPin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(150, 20, 195, 20);
		getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(150, 50, 195, 20);
		getContentPane().add(passwordField_1);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(150, 80, 195, 20);
		getContentPane().add(passwordField_2);
		
		JButton btnGoBack = new JButton("Go back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.setVisible(false);
				Options options = new Options();
				Options.window.setVisible(true);
				options.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnGoBack.setBounds(36, 140, 89, 23);
		getContentPane().add(btnGoBack);
		
		JButton btnProceed = new JButton("Proceed");
		btnProceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String setPIN0=String.valueOf(passwordField.getPassword());
				String setPIN1=String.valueOf(passwordField_1.getPassword());
				String setPIN2=String.valueOf(passwordField_2.getPassword());
				if(MyATM.curPIN.equals(setPIN1)){
					passwordField.setText("");
					passwordField_1.setText("");
					passwordField_2.setText("");
					ChangePIN.window.setVisible(true);
					JFrame frame = new JFrame("frame");
					JOptionPane.showMessageDialog(frame,"Old PIN is the same as the new PIN. Please try again.");
				}
				else if(!MyATM.curPIN.equals(setPIN0)||!setPIN1.equals(setPIN2)){
					passwordField.setText("");
					passwordField_1.setText("");
					passwordField_2.setText("");
					ChangePIN.window.setVisible(true);
					JFrame frame = new JFrame("frame");
					JOptionPane.showMessageDialog(frame,"Something is incorrect. Please try again.");
				}
				else if(MyATM.curPIN.equals(setPIN0) && setPIN1.equals(setPIN2)) {
					MyATM.curPIN=setPIN1;
					ChangePIN.window.setVisible(false);
					JFrame frame = new JFrame("frame");
					JOptionPane.showMessageDialog(frame,"PIN has been changed.");
					MyATM.window.frame.setVisible(true);
				}
			}
		});
		btnProceed.setBounds(150, 140, 89, 23);
		getContentPane().add(btnProceed);
	}
}
