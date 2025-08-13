import java.lang.Math;
public class week07ME {

	static void factorialAge(String num) {																			//note: put quotation marks to denote strings in the test class
		try {
			int j=Integer.parseInt(num);																			//converting String to Integer. If the error is thrown, the catch statement will commence
			int f = 1;
			for (int i = j; i > 0; i--) {																			//a non-recursive factorial algorithm.
				f *= i;
			}
			System.out.println("Your factorial age is "+ f);														//prints the factorial age if there is no error
		}
		catch(NumberFormatException e) {
			System.out.println("Error: Input is not an integer.");													//prints an message if the specific error is thrown
		}
	}
	
	static void arraySearch(int myarray[], int index) {																//need these two parameters for the method to initiate
		try {
			System.out.println("The value is "+myarray[index]);														//prints the value of a specified element
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Error: The index is outside of the array.");										//prints an message if the specific error is thrown
		}
	}
	
	static void myPower(double base, double exp) throws ArithmeticException{
		try {
			int numerator=(int)base;
			int denumerator=(int)exp;																				//down-casted double to int to reproduce the error
			if(exp<0) {
				int checker=numerator/denumerator;																	//checker will not be used locally. It is only aimed for error reproduction.
			}
			else if (base<0) {
				int checker=denumerator/numerator;
			}
			else if(exp==0 && base==0) {																			//this will reproduce an ArithmeticException error if the inputs of both base and exponents are 
				int checker=denumerator/numerator;
			}
			double power=Math.pow(base, exp);
			System.out.println("Power: "+power);																	//prints the value of a specified element
		}
		catch (ArithmeticException e) {
			System.out.println("Error: Zero raised to zero is undefined");											//prints an message if the specific error is thrown
			
		}
	}
}

