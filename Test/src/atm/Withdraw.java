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

public class Withdraw extends JFrame{

	private static final long serialVersionUID = 1L;
	static Withdraw window = new Withdraw();
	private JTextField WithdrawAmount;


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
	public Withdraw() {
		getContentPane().setLayout(null);
		
		JButton btnGoBack = new JButton("Go back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Withdraw.window.setVisible(false);
				Options options = new Options();
				Options.window.setVisible(true);
				options.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnGoBack.setBounds(133, 176, 89, 23);
		getContentPane().add(btnGoBack);
		
		JLabel lblWithdrawAmount = new JLabel("Withdraw Amount");
		lblWithdrawAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblWithdrawAmount.setBounds(10, 37, 102, 14);
		getContentPane().add(lblWithdrawAmount);
		
		WithdrawAmount = new JTextField();
		WithdrawAmount.setBounds(133, 34, 159, 20);
		getContentPane().add(WithdrawAmount);
		WithdrawAmount.setColumns(10);
		
		JButton btnProceed = new JButton("Proceed");
		btnProceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int WitAm=Integer.valueOf(WithdrawAmount.getText());
					if (WitAm<MyATM.balance) {
						MyATM.balance=MyATM.balance-WitAm;
						JFrame frame = new JFrame("frame");
						JOptionPane.showMessageDialog(frame,"Successfully deposited.");
						Deposit.window.setVisible(false);
						Options.window.setVisible(true);
					}
					else if(WitAm>MyATM.balance) {
						JFrame frame = new JFrame("frame");
						JOptionPane.showMessageDialog(frame,"Amount is larger than your current balance. Please try again.");
						WithdrawAmount.setText("");
					}
					else if(WitAm==0) {
						JFrame frame = new JFrame("frame");
						JOptionPane.showMessageDialog(frame,"No withdrawn amount. Please try again.");
						WithdrawAmount.setText("");
					}
					
				}
				catch (NumberFormatException ex) {
					JFrame frame = new JFrame("frame");
					JOptionPane.showMessageDialog(frame,"Invalid amount. Please try again.");
					WithdrawAmount.setText("");
				}
			}
		});
		btnProceed.setBounds(133, 133, 89, 23);
		getContentPane().add(btnProceed);
	}
}
