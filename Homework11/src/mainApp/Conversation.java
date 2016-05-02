package mainApp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Conversation {
	
	public static String askFirstName() {
		System.out.println("Hello! What's your name?");
		String name = TextIO.getlnString();
		System.out.println("Sorry I did not hear you. Can you repeat your name please?");
		String name2 = TextIO.getlnString();
		if (name.equals(name2)) {
			System.out.println("Thank you! Welcome " + name);
		} else {
			System.out.println("I understood something else the first time :D Welcome " + name2 );
		}	
		return name2;
	}
	
	public static long askAge() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy");
		System.out.println("Hello! What's your birthdate? (Use the dd/mm/yyy format please)");
		String dob = TextIO.getlnString();
		Date date = null;
		try {
		      date = dateFormat.parse(dob);
		    } catch (ParseException e) {
		      e.printStackTrace();
		    }
		long timeStamp = date.getTime();
		return timeStamp;
	}
	
	public static int fibonacci(int index) {
		int a = 0;
		int result = 1;
		
		for (int i = 2; i < index + 1; i++) {
			int b = a;
			result = result + a;
			a = result - b;
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		fibonacci(8);
		
	}

}
