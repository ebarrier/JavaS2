package main;

import java.text.DateFormat;
import java.text.SimpleDateFormat; 
import java.util.Date;

public class Today {
	
	static String date;
	
	public static String date() {
		DateFormat df = new SimpleDateFormat("EEEE dd MMMM yyyy HH:mm:ss");
		Date today = new Date();        
		date = df.format(today);
		return date;
	}
	
	public static void printDate(){
		date();
		System.out.println(date);
	}

}
