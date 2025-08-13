
public class ME03 {
	public static void main(String[] args) {
		double money=2540.75;
		int thousandBill = (int) (money/ 1000);
		int fiveHundredBill = (int) (((money)-(thousandBill*1000))/ 500);
		int twoHundredBill = (int) (((money)-(thousandBill*1000)-(fiveHundredBill*500))/ 200);
		int hundredBill = (int) (((money)-(thousandBill*1000)-(fiveHundredBill*500)-(twoHundredBill*200))/ 100);
		int fiftyBill = (int) (((money)-(thousandBill*1000)-(fiveHundredBill*500)-(twoHundredBill*200)-(hundredBill*100))/ 50);
		int twentyBill = (int) (((money)-(thousandBill*1000)-(fiveHundredBill*500)-(twoHundredBill*200)-(hundredBill*100)-(fiftyBill*50))/ 20);
		int tenPeso = (int) (((money)-(thousandBill*1000)-(fiveHundredBill*500)-(twoHundredBill*200)-(hundredBill*100)-(fiftyBill*50)-(twentyBill*20))/ 10);
		int fivePeso = (int) (((money)-(thousandBill*1000)-(fiveHundredBill*500)-(twoHundredBill*200)-(hundredBill*100)-(fiftyBill*50)-(twentyBill*20)-(tenPeso*10))/ 5);
		int peso = (int) (((money)-(thousandBill*1000)-(fiveHundredBill*500)-(twoHundredBill*200)-(hundredBill*100)-(fiftyBill*50)-(twentyBill*20)-(tenPeso*10)-(fivePeso*5))/ 1);
		int quarter = (int) (((money)-(thousandBill*1000)-(fiveHundredBill*500)-(twoHundredBill*200)-(hundredBill*100)-(fiftyBill*50)-(twentyBill*20)-(tenPeso*10)-(fivePeso*5)-(peso))/ 0.25);
		int dime = (int) (((money)-(thousandBill*1000)-(fiveHundredBill*500)-(twoHundredBill*200)-(hundredBill*100)-(fiftyBill*50)-(twentyBill*20)-(tenPeso*10)-(fivePeso*5)-(peso)-(quarter*0.25))/ 0.10);
		int nickel = (int) (((money)-(thousandBill*1000)-(fiveHundredBill*500)-(twoHundredBill*200)-(hundredBill*100)-(fiftyBill*50)-(twentyBill*20)-(tenPeso*10)-(fivePeso*5)-(peso)-(quarter*0.25)-(dime*0.10))/ 0.05);
		int cent = (int) (((money)-(thousandBill*1000)-(fiveHundredBill*500)-(twoHundredBill*200)-(hundredBill*100)-(fiftyBill*50)-(twentyBill*20)-(tenPeso*10)-(fivePeso*5)-(peso)-(quarter*0.25)-(dime*0.10)-(nickel*0.05))/ 0.01);
		System.out.println("Amount: \u20b1 "+money
				+ "\nDenomination:\n"
				+ "\u20b1 1000 = "+thousandBill+"\n"
				+ "\u20b1 500 = "+fiveHundredBill+"\n"
				+ "\u20b1 200 = "+twoHundredBill+"\n"
				+ "\u20b1 100 = "+hundredBill+"\n"
				+ "\u20b1 50 = "+fiftyBill+"\n"
				+ "\u20b1 20 = "+twentyBill+"\n"
				+ "\u20b1 10 = "+tenPeso+"\n"
				+ "\u20b1 5 = "+fivePeso+"\n"
				+ "\u20b1 1 = "+peso+"\n"
				+ "\u20b1 0.25 = "+quarter+"\n"
				+ "\u20b1 0.10 = "+dime+"\n"
				+ "\u20b1 0.05 = "+nickel+"\n"
				+ "\u20b1 0.01 = "+cent+"\n");
	}
}
