package atm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BaInq extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static BaInq window = new BaInq();
	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the application.
	 */
	public BaInq() {
		getContentPane().setLayout(null);
		
		JLabel lblBalance = new JLabel("Your balance is \u20b1 "+ MyATM.balance);
		lblBalance.setHorizontalAlignment(SwingConstants.CENTER);
		lblBalance.setBounds(125, 55, 174, 26);
		getContentPane().add(lblBalance);
		
		JButton btnGoBack = new JButton("Go back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.setVisible(false);
				Options options = new Options();
				Options.window.setVisible(true);
				options.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnGoBack.setBounds(168, 153, 89, 23);
		getContentPane().add(btnGoBack);
	}
}
