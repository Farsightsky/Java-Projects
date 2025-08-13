import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class eh{
	public static void main(String[] args) {
		String[] value;
		Double[] parsed;

		String values= "18;40.03669;35;20.68896;66;66;66;9.79212;4.23569;41.33901;12.45543;12;24.04120;19;5.19058;46.81413;1.98882;15;47;27;10.59653;44;39;19.29143;38;38.75906;5.40101;13;34.46876;32.49625;35;43.75603;19.47561;38.22594;48;22;43;44;37;42;22.88560;7.90418;15;25.09369;44;4.71662;9.52148;43.15001;27;30.39039;30.98978;37.43295;0;3.19407;14;45.87309;18;49;20.26674;22.77082;30.07571;0.55224;31.03613;2;6;";
		System.out.println(values+"\n\n");
		
		value = values.split(";");
		parsed = new Double[value.length];
		for (int i = 0; i<value.length; i++) {
			parsed[i] = Double.valueOf(value[i]);
		}
		mode(parsed);
	}
	
	private static void mode(Double[] parsed) {
		HashMap<Double, Double> counter = new HashMap<Double, Double>();
		for (double d : parsed) {
			Double count = counter.get(d);
			counter.put(d, (count == null ? 1 : count + 1));
	}
		List<Double> mode = new ArrayList<Double>();
		List<Double> frequency = new ArrayList<Double>();
		List<Double> values = new ArrayList<Double>();

		for (Entry<Double, Double> entry : counter.entrySet()) {
			frequency.add(entry.getValue());
			values.add(entry.getKey());
		}
		double maxCount = Collections.max(frequency);

		for(int i=0; i< frequency.size();i++)
		{
			double val =frequency.get(i);
			if(maxCount == val )
			{
				mode.add(values.get(i));
			}
		}
		Double[] temp2 = mode.toArray( new Double[mode.size()]);
		System.out.println(Arrays.toString(temp2));
		return;
	}
}