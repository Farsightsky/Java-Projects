import java.util.Calendar;														//to get current values of the fields

public class MyTime {
	private static int year = 0, month = 0, day = 0, hour = 0, min = 0, sec = 0, meridiem = 0;

	public static void main(String[] args) {
		MyTime t1 = new MyTime(month, day ,year, hour, sec, min, meridiem);
		System.out.println(t1);
}
public static int getYear(int year) {
	return MyTime.year;
}
public static int setYear(int year) {
	return MyTime.year = Calendar.getInstance().get(Calendar.YEAR);				//inputMonth in int
}
public static int getMonth(int month) {
	return MyTime.month;
}
public static String setMonth(int month) {
	MyTime.month = Calendar.getInstance().get(Calendar.MONTH)+1;				//inputMonth in int
	if (MyTime.month == 1){
		return "January";
	}
	else if (MyTime.month == 2){
		return "Feruary";
		}
	else if (MyTime.month == 3){
		return "March";
	}
	else if (MyTime.month == 4){
		return "April";
	}
	else if (MyTime.month == 5){
		return "May";
	}
	else if (MyTime.month == 6){
		return "June";
	}
	else if (MyTime.month == 7){
		return "July";
	}
	else if (MyTime.month == 8){
		return "August";
	}
	else if (MyTime.month == 9){
		return "September";
	}
	else if (MyTime.month == 10){
		return "October";
	}
	else if (MyTime.month == 11){
		return "November";
	}
	else if (MyTime.month == 8){
		return "December";
	}
	else{
	}
	return null;
}

public static int getDay(int day) {
	return MyTime.day;
}

public static int setDay(int day) {
	return MyTime.day = Calendar.getInstance().get(Calendar.DATE);				//inputDay in int
}

public static int getHour(int hour) {
	return MyTime.hour;
}

public static int setHour(int hour) {
	return MyTime.hour = Calendar.getInstance().get(Calendar.HOUR);				//inputHour in int
}

public static int getMin(int min) {
	return MyTime.min;
}

public static int setMin(int min) {
	return MyTime.min = Calendar.getInstance().get(Calendar.MINUTE);				//inputMin in int
}

public static int getSec(int sec) {
	return MyTime.sec;
}

public static int setSec(int sec) {
	return MyTime.sec = Calendar.getInstance().get(Calendar.SECOND);				//inputSec in int
}

public static int getMeridien(int meridiem) {
	return MyTime.meridiem;	
}

public static String setMeridiem(int meridiem) {
	MyTime.meridiem = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);				//inputMeriidiem in int
	if (MyTime.meridiem < 12){
		return "AM";
	}
	else if (MyTime.meridiem > 12){
		return "PM";
	}
	else {
	return null;
	}
}

public MyTime(int month, int day, int year, int hour, int min, int sec, int meridiem) { 
	MyTime.year = year; 
	MyTime.month = month;
	MyTime.day = day;
	MyTime.hour = hour;
	MyTime.min = setMin(MyTime.min);												//to make two-digit minutes less than ten minutes
	MyTime.sec = setSec(MyTime.sec);												//to make two-digit seconds less than ten seconds
	MyTime.meridiem = meridiem;
}

public String toString(){
	if (min<10 && sec<10) {
		return String.format(setMonth(MyTime.month)+" "+setDay(MyTime.day)+", "+setYear(MyTime.year)+" - "+setHour(MyTime.hour)+":0"+setMin(MyTime.min)+":0"+setSec(MyTime.sec)+" "+setMeridiem(MyTime.meridiem));
	}
	else if (min<10 && sec>10){
		return String.format(setMonth(MyTime.month)+" "+setDay(MyTime.day)+", "+setYear(MyTime.year)+" - "+setHour(MyTime.hour)+":0"+setMin(MyTime.min)+":"+setSec(MyTime.sec)+" "+setMeridiem(MyTime.meridiem));
	}
	else if (min>10 && sec<10){
		return String.format(setMonth(MyTime.month)+" "+setDay(MyTime.day)+", "+setYear(MyTime.year)+" - "+setHour(MyTime.hour)+":"+setMin(MyTime.min)+":0"+setSec(MyTime.sec)+" "+setMeridiem(MyTime.meridiem));
	}
	else {
		return String.format(setMonth(MyTime.month)+" "+setDay(MyTime.day)+", "+setYear(MyTime.year)+" - "+setHour(MyTime.hour)+":"+setMin(MyTime.min)+":"+setSec(MyTime.sec)+" "+setMeridiem(MyTime.meridiem));
	}
}
}
