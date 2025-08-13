package atm;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class Deposit extends JFrame{

	private static final long serialVersionUID = 1L;
	static Deposit window = new Deposit();
	private JTextField DepositAmount;


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
	public Deposit() {
		getContentPane().setLayout(null);
		
		JButton btnGoBack = new JButton("Go back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.setVisible(false);
				Options options = new Options();
				Options.window.setVisible(true);
				options.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnGoBack.setBounds(133, 176, 89, 23);
		getContentPane().add(btnGoBack);
		
		JLabel lblDepositAmount = new JLabel("Deposit Amount");
		lblDepositAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDepositAmount.setBounds(10, 37, 102, 14);
		getContentPane().add(lblDepositAmount);
		
		DepositAmount = new JTextField();
		DepositAmount.setBounds(133, 34, 159, 20);
		getContentPane().add(DepositAmount);
		DepositAmount.setColumns(10);
		
		JButton btnProceed = new JButton("Proceed");
		btnProceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int DepAm=Integer.valueOf(DepositAmount.getText());
					if (DepAm>0) {
						MyATM.balance=MyATM.balance+DepAm;
						JFrame frame = new JFrame("frame");
						JOptionPane.showMessageDialog(frame,"Successfully deposited.");
						Deposit.window.setVisible(false);
						Options.window.setVisible(true);
					}
					else if(DepAm<0) {
						JFrame frame = new JFrame("frame");
						JOptionPane.showMessageDialog(frame,"Invalid amount. Please try again.");
						DepositAmount.setText("");
					}
					else if(DepAm==0) {
						JFrame frame = new JFrame("frame");
						JOptionPane.showMessageDialog(frame,"No deposited amount. Please try again.");
						DepositAmount.setText("");
					}
					
				}
				catch (NumberFormatException ex) {
					JFrame frame = new JFrame("frame");
					JOptionPane.showMessageDialog(frame,"Invalid amount. Please try again.");
					DepositAmount.setText("");
				}
			}
		});
		btnProceed.setBounds(133, 133, 89, 23);
		getContentPane().add(btnProceed);
	}
}
