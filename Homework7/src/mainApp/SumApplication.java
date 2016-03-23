package mainApp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import configuration.SpringConfig;
import services.InfInteractionServ;

public class SumApplication {
	
	//private InfInteractionServ inputSer;
	
	public static int sum(int number) {
		int sum=0;
		while (number > 0) {
			int digit = number % 10;
			sum += digit;
			number = number / 10; //or number /= 10;
		}
		return sum;
	}
	
	
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		InfInteractionServ interServ = context.getBean(InfInteractionServ.class);
		int number = interServ.getInt();
		System.out.println("you have entered the number " + number);
		sum(number);
	}
	
}
