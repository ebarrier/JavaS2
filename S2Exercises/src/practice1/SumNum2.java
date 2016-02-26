package practice1;

import java.util.Scanner;

public class SumNum2 {
	
	public static int sum(int number) {
		int sum=0;
		
		String text = String.valueOf(number);
		
		for (int i = 0; i < text.length(); i++) {
			int digit = Character.digit(text.charAt(i), 10);
			sum += digit;
		}
		
		return sum;
	}
	
	public static int sum2(int number) {
		int sum=0;
		
		while (number > 0) {
			
			int digit = number % 10;
			sum += digit;
			number = number / 10; //or number /= 10;
			
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		
		System.out.println("Please insert a number");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		
		System.out.println("The sum of digits of your number is: " + sum(number));
		System.out.println("The sum of digits of your number is: " + sum2(number));
	}

}
