
public class Test {
	public static void main(String[] args) {
		String source= "18;40.03669;35;20.68896;9.79212;4.23569;\n"
				+ "41.33901;12.45543;12;24.04120;19;5.19058;\n"
				+ "46.81413;1.98882;\n"
				+ "15;47;27;10.59653;44;39;19.29143;38;\n"
				+ "38.75906;5.40101;13;34.46876;32.49625;35;43.75603;\n"
				+ "19.47561;38.22594;48;22;43;44;37;42;22.88560;7.90418;15;25.09369;\n"
				+ "44;4.71662;9.52148;43.15001;27;30.39039;\n"
				+ "30.98978;37.43295;0;3.19407;14;\n"
				+ "45.87309;18;49;20.26674;22.77082;30.07571;0.55224;\n"
				+ "31.03613;2;6;";
		String[] value, valuesRow=source.split("\n");
		int numOfValues = 0;
		
		for(String element: valuesRow) {
			value=element.split(";");
			numOfValues=element.split(";").length;
			}
		System.out.println(numOfValues);
	}
}
