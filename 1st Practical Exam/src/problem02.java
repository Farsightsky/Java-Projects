import java.lang.Math;																										//for Math.pow and Math.rounf
public class problem02 {
	public static void main(String[] args) {
		piDigitSum(5);
	}
	private static void piDigitSum(int digitCount) {
		if (digitCount>=0 && digitCount<=6) {
			int sum = 0;
			double pi = Math.round(Math.PI*(Math.pow(10, digitCount)));														//round the pi
			System.out.println("Value of \u03c0 with "+digitCount+" decimal places = "+pi/(Math.pow(10, digitCount)));		//print the pi
			String temp = String.valueOf(pi);
		for (char i : temp.toCharArray()) {
			if(i!='.') {
				sum += Integer.parseInt(String.valueOf(i));
			}
		}	
		System.out.println("Sum of digits = " + sum);																		//print the sum of pi digits
		return;
		}
		else {
			System.out.print("Out of bound");
		}
	}
}
