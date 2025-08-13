import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class finalTest {
	public static void main(String args[]) {
		int infoTrim=2;
		String input= "202012345\r\nDela Cruz, Juan\r\nCMSC 11,EF,3,1.75\r\nMath 53,GC,5,5.0\r\nMath 101,AB,3,2.0\r\nScience 10, ZZ, 3,2.5\r\nEthics 1,Z,3,1.5\r\nPE 2 Petanque,X,(2),3.0\r\nMath 53,GC,5,4.0\r\nMath 53,GC, 5,3.0\r\nMath 54,GC,5,1.0\r\nCMSC 12, EF,3,2.0\r\nCMSC 55,ZZ,5,1.0\r\nArts 1,B,3,inc\r\nPE 2 Phy Ed activities, A, (2),2.75\r\nCMSC 130,DP,3,2.75\r\nNSTP 1 CWTS,TBA,(3),2.75\r\nFA 101,Q,3,1.25";
		String lines[] = input.split("\r\n");
		String[][] matrix = new String[lines.length][];
		int rowSize = 0;
		for (String row : lines) {
			matrix[rowSize++] = row.split(",", 4);
		}
		
		String result = Arrays.stream(matrix).map(Arrays::toString) .collect(Collectors.joining("\n")).replaceAll("\\[","").replaceAll("\\]","");
		System.out.println(result);
		
		
		List<String> courses=new ArrayList<String>();
		
		
		LinkedHashMap<String, String> courseGrade = new LinkedHashMap<>();
		for(int i=0;i<lines.length-infoTrim;i++) {
			courses.add(matrix[i+infoTrim][0]);
			courseGrade.put(matrix[i+infoTrim][0], matrix[i+infoTrim][3]);
		}
		
		
	}
}
