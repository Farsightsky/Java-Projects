import java.util.Arrays;
import java.util.stream.Collectors;

public class problem04 {
	public static void main(String[] args) {
		String sentence="Crwth vox zaps qi gym fjeld bunk panagram anagram bunk lipogram lipogram";
		reverseWords(sentence);
	}
	
	public static void reverseWords(String sentence) {
		int size =sentence.length();
		char[] reverse = new char[size];
		for (int i = 0; i < size ; i++){																						//this loop reverse the letters of the strings
			reverse[size-i-1]=sentence.charAt(i);
			String.valueOf(reverse);
		}
		String symbol = Arrays.stream(String.valueOf(reverse).split("\\s+")).distinct().collect(Collectors.joining(" "));		//deletes duplicate words
		String[] temp = symbol.split("\\s+");																					//this splits the letters to detect words by determining whitespaces
		for (String part : temp) {;
			System.out.format("%s ",new StringBuilder(part).reverse().toString());												//reverses letters in each word
		}
	}
}
