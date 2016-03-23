package mainApp;

import services.InfInteractionServ;

public class SumApplication {
	
	private InfInteractionServ inputSer;
	
	public int sum(int number) {
		int sum=0;
		while (number > 0) {
			int digit = number % 10;
			sum += digit;
			number = number / 10; //or number /= 10;
		}
		return sum;
	}
	
	public void start() {
		inputSer.print("Hello!");
		int number = inputSer.getInt();
		inputSer.print("you have entered the number " + number);
	}
	
	
	public static void main(String[] args) {
		
		SumApplication function = new SumApplication();
		function.start();
	}
	
}
