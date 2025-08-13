package atm;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Options extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static Options window = new Options();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window.setResizable(false);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Options() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Options.window.setVisible(false);
				Deposit.window.setVisible(true);
				Deposit.window.setResizable(false);
				Deposit.window.setBounds(100, 100, 450, 300);
				Deposit.window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnDeposit.setBounds(123, 28, 164, 23);
		contentPane.add(btnDeposit);
		
		
		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Options.window.setVisible(false);
				Withdraw withdraw = new Withdraw();
				Withdraw.window.setVisible(true);
				Withdraw.window.setResizable(false);
				Withdraw.window.setBounds(100, 100, 450, 300);
				Withdraw.window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnWithdraw.setBounds(123, 73, 164, 23);
		contentPane.add(btnWithdraw);
		
		JButton btnBalanceInquiry = new JButton("Balance Inquiry");
		btnBalanceInquiry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Options.window.setVisible(false);
				BaInq.window.setVisible(true);
				BaInq.window.setResizable(false);
				BaInq.window.setBounds(100, 100, 450, 300);
				BaInq.window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnBalanceInquiry.setBounds(123, 115, 164, 23);
		contentPane.add(btnBalanceInquiry);
		
		JButton btnChangePIN = new JButton("Change PIN");
		btnChangePIN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Options.window.setVisible(false);
				ChangePIN.window.setVisible(true);
				ChangePIN.window.setResizable(false);
				ChangePIN.window.setBounds(100, 100, 450, 300);
				ChangePIN.window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnChangePIN.setBounds(123, 162, 164, 23);
		contentPane.add(btnChangePIN);
		
		JButton Cance = new JButton("Cancel");
		Cance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(ABORT);
			}
		});
		Cance.setBounds(161, 227, 89, 23);
		contentPane.add(Cance);
	}

}
