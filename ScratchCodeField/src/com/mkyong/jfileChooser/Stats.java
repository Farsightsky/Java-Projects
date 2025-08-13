package com.mkyong.jfileChooser;

import java.util.*;

public class Stats {
	public static void ArrayData(int num,float samples){
	double width,minVal,maxVal;
	
	
	
	int sampleInt = (int)samples;
	Scanner console = new Scanner(System.in);
	Integer SamData[] = new Integer[num];			//Sample data from user
	Integer LowLimit[] = new Integer[sampleInt];	//
	Integer UpLimit[] = new Integer[sampleInt];
	Double mp[] = new Double[sampleInt];
	Integer gcf[] = new Integer[sampleInt];
	Integer lcf[] = new Integer[sampleInt];
	Double rf[] = new Double[sampleInt];
	String cb[] = new String[sampleInt];
	
	for(int i = 0; i<num;i++) {
		System.out.print("Enter Data Number " + (i+1) + ": ");
		SamData[i] = console.nextInt();
	}
	console.close();
	minVal = SamData[0];
	maxVal= SamData[0];
	for (int i=0;i<num;i++) {
		if (minVal > SamData[i]) {
			minVal = SamData[i];
		}
		if (maxVal < SamData[i]) {
			maxVal = SamData[i];
		}
	}
	int range = (int)(maxVal-minVal);
	width = Math.ceil(((maxVal-minVal)/sampleInt));
	int valWidth = (int)width;
	
	System.out.println("Maximum Value is " + maxVal + " and the Minimum Value is " + minVal);
	System.out.println("Range is " + range + " and the Width is " + valWidth);
	
	int valminval = (int)minVal;
	int mincounter=valminval;
	int maxcounter=valminval+(valWidth -1);
	
	for (int i=0;i<sampleInt;i++) {
		if (i==0){
			LowLimit[i] = valminval;
			UpLimit[i] = valminval+ (valWidth -1);
		}
		else{
			LowLimit[i] = mincounter;
			UpLimit[i] = maxcounter;
		} 
		
		mp[i] =(double) (LowLimit[i]+UpLimit[i])/2;
		cb[i] =(double) (LowLimit[i] - .5 ) + " - " +(UpLimit[i] +.5);
		
		mincounter += valWidth;
		maxcounter +=valWidth;
	}
	Integer[] f = new Integer[sampleInt];									//array for frequency
	for (int i = 0; i<sampleInt; i++) {										//loop per interval
		f[i]=0;																//every element of f[i] is set to 0
		for(int j = 0; j<SamData.length; j++) {								//loop for values of sample datum per interval
			if(SamData[j]>=LowLimit[i] && SamData[j]<=UpLimit[i]){			//will count if sample datum is greater than or equal to lower limit and if sample datum is less than or equal to the upper limit
				f[i]++;														//f[i] will increment by 1
			}
		}	
	}

	
	System.out.println("LOWER LIMIT" + "\t" + "UPPER LIMIT" + "\t" + "f" + "\t" + "MIDPOINT" + "\t" + "CUMULATIVE FREQUENCY" + "\t" + "RELATIVE FREQUENCY" + "\t" + "CLASS BOUNDERIES");

	for(int i=0;i<sampleInt;i++){
		System.out.println(LowLimit[i] + "\t\t" + UpLimit[i] + "\t\t" + f[i] + "\t" + mp[i]+ "\t\t" + lcf[i]+ "\t\t\t" + rf[i] + "\t\t\t" + cb[i]);
	}
}
public static void main(String[] arg){
	Scanner cons = new Scanner(System.in);
	System.out.print("Enter Number of Class: ");
	float classnum = cons.nextInt();
	System.out.print("Enter Number of Samples: ");
	int noSamp = cons.nextInt();
	ArrayData(noSamp,classnum);
	cons.close();
}
}
