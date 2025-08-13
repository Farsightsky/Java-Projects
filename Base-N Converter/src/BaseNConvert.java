import java.util.HashMap;
import java.util.Map;

public class BaseNConvert {
	
	static String BaseNConverter(String number, int origBase, int newBase) {

	StringBuilder conNum = new StringBuilder();
	Map<Character, Integer> baseNtoDec;
	Map<Integer, Character> dectoBaseN;
	if(origBase<= 1 || newBase <= 1) {
		System.out.println("Not a valid base number");
	}
	else {
		int sum = 0;
		int pow = 0;
		baseNtoDec = new HashMap<>();
		dectoBaseN = new HashMap<>();
		if (origBase > newBase) {
			for (int i = 0; i <origBase; i++) {
			baseNtoDec.put((char)('A' + i), 10 + i);
			dectoBaseN.put(10 + i, (char)('A' + i));
			}
		}
		if (origBase !=10) {
			String tempVal = number;
			for (int i = tempVal.length() - 1; i >= 0; i--) {
				int val = tempVal.charAt(i) - '0';
				if (baseNtoDec.containsKey(tempVal.charAt(i))) {
					val = baseNtoDec.get(tempVal.charAt(i));
				}
				sum += (val) * (Math.pow(origBase, pow++));
			}
			while (sum != 0) {
				int tempValue = sum % newBase;
				if (dectoBaseN.containsKey(tempValue)) {
					conNum.insert(0, dectoBaseN.get(tempValue));
				}
				else {
					conNum.insert(0, tempValue);
				}
				sum /= newBase;
			}
		}

	}
	return number+" at base_"+origBase+" is "+conNum.toString()+" at base_"+newBase+".";
	}
	
	public static void main(String args[]) {
		int i = 2;
		int j = 2;
		while (i<11) {
			System.out.println(BaseNConverter("BA2", 12, i)+"\n");
			i++;
		}
		
	}
}
