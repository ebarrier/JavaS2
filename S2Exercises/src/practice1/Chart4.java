package practice1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Chart4 {
	
public static void main(String[] args) {
		
		ArrayList<Integer> numlist = new ArrayList<Integer>();
		
		while (true) {
			System.out.println("Please insert number and hit ENTER. Type \"0\" when finished");
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			int input = scanner.nextInt();
				if (input == 0) {
				break;
				} 
				else {	
				numlist.add(input);
				}
		}
		
		int max = Collections.max(numlist); //get the max from numlist
		String[][] matrix = new String[max + 1][numlist.size()]; //create a matrix of "max + 1" rows and numlist.size columns
		
		for (int j = 0; j < numlist.size(); j++) {
			for (int i = 0; i < matrix.length; i++) {
				if (i == max) {
					matrix[i][j] = "---";
				}
				else if (numlist.get(j) >= max - i) {
					matrix[i][j] = "  X";
				}
				else {
					matrix[i][j] = "  .";
				}
			}
		}
		
		System.out.println();
		System.out.println();
		
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < numlist.size(); j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println("\n");
		}
		for (int value : numlist) {
			System.out.format("%3d", value);
		}
	}

}
