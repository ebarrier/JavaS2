package services;

import java.util.Scanner;

public class InteractionScanner implements InfInteractionServ {

	@Override
	public int getInt() {
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		System.out.println("SCANNER");
		scanner.close();
		return number;
	}

	
}
