import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class problem04 {
	public static void main(String[] args) {
		String sentence="Crwth vox zaps qi gym fjeld bunk panagram anagram bunk. lipogram lipogram 314159";
		String words, temp1;
		words = wordCounter(sentence.split("\\s")).entrySet().stream()
				.map(s -> s.getKey()).collect(Collectors.joining(" "));
		String split[]=words.split("\\s");
		for (int i = 0; i < split.length; i++) {
			for (int j = i + 1; j < split.length; j++) {
				if (split[i].compareTo(split[j])>0) 
				{
					temp1 = split[i];
					split[i] = split[j];
					split[j] = temp1;
				}
			}
		}
		StringBuffer sb = new StringBuffer();
			for(int i = 0; i < split.length; i++) {
				sb.append(split[i]+" ");
		}
		String str = sb.toString();
		System.out.println(str);
	}
	static Map<String, Integer> wordCounter(String[] words) {
		Map<String, Integer> map = new HashMap<String, Integer> ();
		for (String s:words) {
			if (!map.containsKey(s)) {
				map.put(s, 1);
			}
			else {
				int count = map.get(s);
				map.put(s, count + 1);
			}
		}
	return map;
	}
}
