package services;

import java.util.Scanner;

public class InteractionService implements InfInteractionServ {

	@Override
	public int getInt() {
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		scanner.close();
		return number;
	}

	@Override
	public void print(Object o) {
		System.out.println(o);
	}

	
}
