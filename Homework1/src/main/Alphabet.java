package main;

import java.util.ArrayList;

public class Alphabet {
	
	private static ArrayList<String> temp = new ArrayList<String>();

	public static void main(String[] args) {
		System.out.println("Please enter a text");
		String input = TextIO.getln();
		input.toLowerCase();

		String[] outer = new String[5];
		for (int i = 0; i < outer.length; i++) {
			outer[i] = "";
		}
		
		processInput(input);

		for (int i = 0; i < 5; i++) {
			for (int k = 0; k < temp.size(); k++) {
				if ((k % 5) == i) {
					outer[i] = outer[i] + " " + temp.get(k);
				}
			}
			System.out.println(outer[i]);
		}
	}

	private static void processInput(String s) {

		for (int j = 0; j < s.length(); j++) {
			char c = s.charAt(j);
			if (c == 'a') {
				temp.add(" ### ");
				temp.add("#   #");
				temp.add("#####");
				temp.add("#   #");
				temp.add("#   #");
			}

			if (c == 'b') {
				temp.add("#### ");
				temp.add("#   #");
				temp.add("#####");
				temp.add("#   #");
				temp.add("#### ");
			}
			if (c == 'c') {
				temp.add(" ####");
				temp.add("#    ");
				temp.add("#    ");
				temp.add("#    ");
				temp.add(" ####");
			}
			if (c == 'd') {
				temp.add("#### ");
				temp.add("#   #");
				temp.add("#   #");
				temp.add("#   #");
				temp.add("#### ");
			}
			if (c == 'e') {
				temp.add("#####");
				temp.add("#    ");
				temp.add("###  ");
				temp.add("#    ");
				temp.add("#####");
			}
			if (c == 'f') {
				temp.add("#####");
				temp.add("#    ");
				temp.add("###  ");
				temp.add("#    ");
				temp.add("#    ");
			}
			if (c == 'g') {
				temp.add(" ### ");
				temp.add("#    ");
				temp.add("#  ##");
				temp.add("#   #");
				temp.add(" ### ");
			}
			if (c == 'h') {
				temp.add("#   #");
				temp.add("#   #");
				temp.add("#####");
				temp.add("#   #");
				temp.add("#   #");
			}
			if (c == 'i') {
				temp.add("#");
				temp.add(" ");
				temp.add("#");
				temp.add("#");
				temp.add("#");
			}
			if (c == 'j') {
				temp.add("  #");
				temp.add("  #");
				temp.add("  #");
				temp.add("  #");
				temp.add("###");
			}
			if (c == 'k') {
				temp.add("#   #");
				temp.add("#  # ");
				temp.add("###  ");
				temp.add("#  # ");
				temp.add("#   #");
			}
			if (c == 'l') {
				temp.add("#    ");
				temp.add("#    ");
				temp.add("#    ");
				temp.add("#    ");
				temp.add("#####");
			}
			if (c == 'm') {
				temp.add("#   #");
				temp.add("## ##");
				temp.add("# # #");
				temp.add("#   #");
				temp.add("#   #");
			}
			if (c == 'n') {
				temp.add("#   #");
				temp.add("##  #");
				temp.add("# # #");
				temp.add("#  ##");
				temp.add("#   #");
			}
			if (c == 'o') {
				temp.add(" ### ");
				temp.add("#   #");
				temp.add("#   #");
				temp.add("#   #");
				temp.add(" ### ");
			}
			if (c == 'p') {
				temp.add("#### ");
				temp.add("#   #");
				temp.add("#### ");
				temp.add("#    ");
				temp.add("#    ");
			}
			if (c == 'q') {
				temp.add(" ### ");
				temp.add("#   #");
				temp.add("#   #");
				temp.add("#  ##");
				temp.add(" ####");
			}
			if (c == 'r') {
				temp.add("#### ");
				temp.add("#   #");
				temp.add("#### ");
				temp.add("#  # ");
				temp.add("#   #");
			}
			if (c == 's') {
				temp.add(" ####");
				temp.add("#    ");
				temp.add("  #  ");
				temp.add("    #");
				temp.add("#### ");
			}
			if (c == 't') {
				temp.add("#####");
				temp.add("  #  ");
				temp.add("  #  ");
				temp.add("  #  ");
				temp.add("  #  ");
			}
			if (c == 'u') {
				temp.add("#   #");
				temp.add("#   #");
				temp.add("#   #");
				temp.add("#   #");
				temp.add(" ### ");
			}
			if (c == 'v') {
				temp.add("#     #");
				temp.add("#     #");
				temp.add(" #   # ");
				temp.add("  # #  ");
				temp.add("   #   ");
			}
			if (c == 'w') {
				temp.add("#     #     #");
				temp.add("#     #     #");
				temp.add(" #   # #   # ");
				temp.add("  # #   # #  ");
				temp.add("   #     #   ");
			}
			if (c == 'x') {
				temp.add("#   #");
				temp.add(" # # ");
				temp.add("  #  ");
				temp.add(" # # ");
				temp.add("#   #");
			}
			if (c == 'y') {
				temp.add("#   #");
				temp.add(" # # ");
				temp.add("  #  ");
				temp.add("  #  ");
				temp.add("  #  ");
			}
			if (c == 'z') {
				temp.add("#####");
				temp.add("   # ");
				temp.add("  #  ");
				temp.add(" #   ");
				temp.add("#####");
			}
		}
	}

}
