package main;

import java.util.ArrayList;
import java.util.Arrays;

public class Alphabet {

	public static void main(String[] args) {
		System.out.println("Please enter a text");
		String input = TextIO.getln();

		ArrayList<String> temp = new ArrayList();
		String[][] outer = new String[5][input.length()];

		for (int j = 0; j < input.length(); j++) {
			char c = input.charAt(j);
			if (c == 'a') {
				temp.add(" ### ");
				temp.add("#   #");
				temp.add("#####");
				temp.add("#   #");
				temp.add("#   #");
			}
			for (int i = 0; i < 5; i++) {
				outer[i][j] = temp.get(i);
				System.out.println(Arrays.deepToString(outer));
			}
		}
	}

}
