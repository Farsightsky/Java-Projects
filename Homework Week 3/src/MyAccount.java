
public class MyAccount {
	private static double balance = 1520.02;																		//input for balance
	static double debit(double debit_amount) {
			if (balance >= debit_amount) {
				System.out.format("Your balance after debit is: \u20b1 %.2f\n", balance-debit_amount);
			}
			else {
				System.out.println("\nInvalid debit amount. Please try again.");
			}
			return balance;
		}
	
	static double credit(double credit_amount) {
		if (credit_amount >=0) {
			System.out.format("Your balance after credit is: \u20b1 %.2f\n", balance+credit_amount);
		}
		else {
			System.out.println("Invalid credit amount. Please try again.");
		}
		return balance;
	}
	
		public static void main(String[] args) {																	//input for debit, and credit
			double debit_amount=1000, credit_amount=1000;
			getBalance(balance);
			credit(credit_amount);
			debit(debit_amount);
		}

		public static double getBalance(double balance) {
			if (balance >= 0) {
				System.out.format("Your balance is: \u20b1 %.2f\n", balance);
			}
			else if (balance < 0){
				balance = 0;
				System.out.format("Your balance is: \u20b1 %.2f\n", balance);
			}
			else {
			}
			return balance;
		}
}
		
