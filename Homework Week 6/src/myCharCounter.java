import java.util.HashMap;

public class myCharCounter {
	private static void charCount(String inputString){
		HashMap<Character, Integer> counter = new HashMap<Character, Integer>();
		char[] strArray = inputString.toLowerCase().toCharArray();										//convert uppercase to lowercase so that they will be considered the same, same applies if you turn lowercase to uppercase
		for (char temp : strArray) {
			if(counter.containsKey(temp)) {																//counts letter
				counter.put(temp, counter.get(temp)+1);
				}
			else {																						//if letter is not present again, the value remains one
				counter.put(temp, 1);
			}
		}
		counter.entrySet().forEach( entry -> {															//formats the print in the desired style
		System.out.println("* '"+entry.getKey()+"'" + " Count: " + entry.getValue() );
		});
	}
}
