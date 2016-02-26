package practice1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BackwardsNameSort3 {

	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<String>();
		names.addAll(Arrays.asList(
				"Veronika",
				"Matilde",
				"Kati",
				"Siim",
				"Aavo"
		));
		
		Collections.sort(names, new BackwardsNameComparator3());
		
		for (String name : names) {
			System.out.println(name);
		}
	
	}
	
}
