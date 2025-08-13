
public class problem03 {
	private static String data; private static int maxinput=1024;
	public static void main(String[] args) {
		getData();
		countAlphaNumeric();
		listNonAlphanumeric();
		mostSeentAlphaNumeric();
	}
	public static String getData() {
		data="a5f 4a65ggr5ggGGgg201a436^$$b";																					//input
		return data;
	}
	public static void countAlphaNumeric(){
	char[] temp = data.toCharArray();
	int alpha = 0, numeric = 0;
	for(int i = 0; i < data.length(); i++){
		if(Character.isLetter(temp[i])){
			alpha ++ ;
		}
		else if(Character.isDigit(temp[i])){
			numeric ++ ;
		}
		else{
		}
	}
	System.out.println("alphanumeric count: "+(alpha+numeric));
		return;
	}
	public static void listNonAlphanumeric(){
		String symbol = data.replaceAll("[^\\p{Punct}\\p{Space}\\p{Blank}]","");										//find symbols and spaces and store it in symbol
		System.out.println("other characters = " + symbol);
		return;
	}
	
	public static void mostSeentAlphaNumeric(){
		int[] count = new int[maxinput];
		for(int i = 0; i < data.length(); i++){
			count[data.charAt(i)]++;
		}
		int max = -1;
		char result = ' ';
		for (int i = 0; i < data.length(); i++) {
			if (max < count[data.charAt(i)]) {
				max = count[data.charAt(i)];
				result = data.charAt(i);												//only prints the first letter on the left if there is a tie
			}
		}
		System.out.println("most seen character is " +result);	
	}
	
}