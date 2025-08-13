import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Separator {
    public static void main(String args[]) {
    	int index=0;
        String info="Start;End;Sleep Quality;Regularity;Mood;Steps;Alarm mode;Air Pressure (Pa);City;Movements per hour;Time in bed(seconds);Window start;Window stop;Did snore;Snore time;Weather temperature (Â°F);Weather type;Notes\n"
        		+ "2021-09-25 02:51:45;2021-09-25 09:21:36;67%;â€”;;0;No alarm;;;65.19114;23391.127;;;false;0;;;Slept late\n"
        		+ "2021-09-26 01:38:34;2021-09-26 07:20:37;59%;73%;;0;No alarm;;;45.91364;20522.957;;;false;0;;;Slept late\n"
        		+ "2021-09-27 01:53:06;2021-09-27 07:45:15;62%;83%;;0;No alarm;;;53.04846;21129.845;;;false;0;;;Slept late\n"
        		+ "2021-09-28 01:28:54;2021-09-28 09:44:24;62%;82%;;0;No alarm;;;72.81848;29730.665;;;false;0;;;Slept late\n"
        		+ "2021-09-29 02:45:15;2021-09-29 10:01:51;51%;83%;;0;No alarm;;;87.90669;26196.096;;;false;0;;;Slept late\n"
        		+ "2021-09-30 01:50:01;2021-09-30 07:31:50;67%;79%;;0;No alarm;;;46.65311;20508.961;;;false;0;;;Slept late\n"
        		+ "2021-10-01 01:40:14;2021-10-01 08:58:12;72%;81%;;0;No alarm;;;66.64879;26277.68;;;false;0;;;Slept late\n"
        		+ "2021-10-02 01:20:14;2021-10-02 09:20:57;82%;84%;;0;No alarm;;;63.38356;28842.704;;;false;0;;;Slept late\n"
                + "2021-10-03 03:02:27;2021-10-03 09:21:10;66%;89%;;0;No alarm;;;60.672615;22722.807;;;true;77;;;Ate late:Slept late\n"
                + "2021-10-04 01:51:34;2021-10-04 09:22:39;71%;89%;;0;No alarm;;;71.68287;27065.427;;;true;250;;;Slept late\n"
                + "2021-10-06 03:35:13;2021-10-06 09:36:03;48%;86%;;0;No alarm;;;86.3604;21649.948;;;false;0;;;Slept late\n"
                + "2021-10-07 00:31:19;2021-10-07 07:38:46;91%;77%;;0;No alarm;;;38.149662;25647.466;;;false;0;;;Slept late\n"
                + "2021-10-08 01:12:59;2021-10-08 08:21:11;71%;73%;;0;No alarm;;;0.0;25691.894;;;false;0;;;Slept late\n"
                + "2021-10-08 17:31:34;2021-10-08 18:59:51;19%;23%;;0;No alarm;;;1.0;5296.684;;;false;0;;;Nap\n"
                + "2021-10-09 02:17:50;2021-10-09 07:06:05;50%;75%;;0;No alarm;;;54.360172;17294.996;;;false;0;;;Slept late\n"
                + "2021-10-10 03:13:51;2021-10-10 11:11:50;72%;69%;;0;No alarm;;;36.424725;28679.848;;;true;3362;;;Slept late\n"
                + "2021-10-11 02:53:41;2021-10-11 10:03:54;63%;75%;;0;No alarm;;;83.29439;25812.468;;;false;0;;;Ate late:Slept late\n"
                + "2021-10-12 01:49:20;2021-10-12 09:35:01;87%;87%;;0;No alarm;;;43.064846;27941.356;;;false;0;;;Slept late\n"
                + "2021-10-13 03:11:20;2021-10-13 08:30:16;61%;84%;;0;No alarm;;;38.91124;19136.648;;;false;0;;;Slept late\n"
                + "2021-10-13 18:46:38;2021-10-13 22:21:12;32%;37%;;0;No alarm;;;79.61577;12873.947;;;true;188;;;Slept late\n"
                + "2021-10-14 03:27:10;2021-10-14 08:30:23;59%;88%;;0;No alarm;;;35.82911;18192.727;;;false;0;;;Ate late:Slept late\n"
                + "2021-10-18 02:09:10;2021-10-18 09:44:17;72%;â€”;;0;No alarm;;;71.37354;27306.354;;;false;0;;;Slept late\n"
                + "2021-10-19 07:40:45;2021-10-19 08:30:20;11%;0%;;0;No alarm;;;1.0;2974.62;;;false;0;;;Slept late\n"
                + "2021-10-20 03:55:20;2021-10-20 12:24:40;69%;62%;;0;No alarm;;;98.273575;30560.071;;;false;0;;;Slept late\n"
                + "2021-10-21 02:37:17;2021-10-21 10:19:10;70%;67%;;0;No alarm;;;81.500465;27713.468;;;true;150;;;Slept late\n"
                + "2021-10-22 01:21:13;2021-10-22 10:23:13;91%;80%;;0;No alarm;;;62.079834;32519.241;;;false;0;;;Slept late\n"
                + "2021-10-25 01:08:07;2021-10-25 07:50:47;62%;82%;;0;No alarm;;;78.20149;24159.233;;;false;0;;;Slept late\n"
                + "2021-10-28 01:50:56;2021-10-28 08:30:21;63%;â€”;;0;No alarm;;;76.53488;23964.712;;;false;0;;;Slept late\n"
                + "2021-10-30 00:52:01;2021-10-30 07:30:41;70%;83%;;0;No alarm;;;11.828642;23919.456;;;true;253;;;Slept late\n"
                + "2021-10-31 01:33:55;2021-10-31 11:12:10;100%;73%;;0;No alarm;;;39.14802;34694.814;;;false;0;;;Slept late\n"
                + "2021-11-01 03:15:30;2021-11-01 13:00:17;100%;67%;;0;No alarm;;;9.388484;35086.581;;;false;0;;;Slept late\n"
                + "2021-11-03 01:29:55;2021-11-03 08:58:54;74%;61%;;0;No alarm;;;64.76595;26939.65;;;false;0;;;Slept late\n"
                + "2021-11-04 02:01:22;2021-11-04 09:54:00;100%;69%;;0;No alarm;;;2.1811957;28358.051;;;false;0;;;Slept late\n";
			String lines[] = info.split("\n");
			int infoTrim = lines.length;
			String[][] matrix = new String[lines.length][];
			int rowSize = 0;
			for (String row : lines) {
				matrix[rowSize++] = row.split(";");
			}
			
			String result = Arrays.stream(matrix).map(Arrays::toString) .collect(Collectors.joining("\n")).replaceAll("\\[","").replaceAll("\\]","");
			
			List<String> courses=new ArrayList<String>();
			
			
			LinkedHashMap<String, String> courseGrade = new LinkedHashMap<>();
			for(int i=0;i<lines.length-infoTrim;i++) {
				courses.add(matrix[i+infoTrim][0]);
				courseGrade.put(matrix[i+infoTrim][0], matrix[i+infoTrim][3]);
			}
			Object[] column = new Object[lines.length]; // Here I assume a rectangular 2D array! 
	        for(int i=0; i<column.length; i++){
	           column[i] = matrix[i][index];
	           System.out.println(column[i]);
	        }
    }

}