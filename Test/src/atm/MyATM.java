package atm;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyATM {

	JFrame frame;
	private JPasswordField passwordPIN;
	static String curPIN="1234567890";
	static int balance;
	
	
	
	static MyATM window = new MyATM();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window.frame.setResizable(false);
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
	public MyATM() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbPIN = new JLabel("PIN");
		lbPIN.setBounds(41, 49, 32, 14);
		frame.getContentPane().add(lbPIN);
		
		passwordPIN = new JPasswordField();
		passwordPIN.setBounds(83, 46, 198, 20);
		frame.getContentPane().add(passwordPIN);
		
		JButton btnProceed = new JButton("Proceed");
		btnProceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String setPIN = String.valueOf(passwordPIN.getPassword());
				if(setPIN.equals(curPIN)){ 
					window.frame.setVisible(false);
					Options options = new Options();
					Options.window.setVisible(true);
					options.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}
				else if(!setPIN.equals(curPIN)) {
					JFrame frame = new JFrame("frame");
					JOptionPane.showMessageDialog(frame,"Invalid PIN.");

				}
			}
		});
		btnProceed.setBounds(81, 92, 89, 23);
		frame.getContentPane().add(btnProceed);
	}
}
