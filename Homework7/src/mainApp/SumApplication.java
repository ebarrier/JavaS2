package mainApp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import configuration.SpringConfig;
import services.InfInteractionServ;

public class SumApplication {
	
	//private InfInteractionServ inputSer;
	
	public int sum(int number) {
		int sum=0;
		while (number > 0) {
			int digit = number % 10;
			sum += digit;
			number = number / 10; //or number /= 10;
		}
		return sum;
	}
	
	
	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		InfInteractionServ interServ = context.getBean(InfInteractionServ.class);
		System.out.println("Hello!");
		int number = interServ.getInt();
		System.out.println("you have entered the number " + number);
	}
	
}
