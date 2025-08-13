import java.io.*;
import java.util.ArrayList;

class Sample {
	public static void main(String[] args) throws IOException {
		String inputValue;
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

        // read the input
		ArrayList<String> inputList = new ArrayList<String>(); // Requires JRE >= 1.5
		while((inputValue = stdin.readLine ()) != null) //Reads input
			inputList.add(inputValue);

		// convert what is read to double
		double [] numbers = new double[inputList.size()];
		for(int i = 0; i < numbers.length; i++){
			numbers[i] = Double.parseDouble(inputList.get(i));
		}

        // print what is read
		System.out.print("[");
		for(int i =0; i < numbers.length; i++){
			if (i > 0) System.out.print(",");
			System.out.print(numbers[i]);   
		}
		System.out.println("]");
	}
}
