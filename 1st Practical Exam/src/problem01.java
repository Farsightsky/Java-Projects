public class problem01 {
	private static int numberToConvert=10;
	public static void main(String[] args) {
		toBinary(numberToConvert);
		toOctal(numberToConvert);
		toHex(numberToConvert);
	}
	
	public static void toBinary (int numberToConvert) {
		System.out.println("Binary value = " + Integer.toBinaryString(numberToConvert)+"\n"); return;
	}
	
	public static void toOctal(int numberToConvert) {
	System.out.println("Octal value = " + Integer.toOctalString(numberToConvert)+"\n"); return;
	}
	
	public static void toHex (int numberToConvert) {
		System.out.println("Hexadecimal value = " + Integer.toHexString(numberToConvert)+"\n"); return;
	}
}
