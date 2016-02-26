package practice1;

import java.util.Comparator;

public class BackwardsNameComparator3 implements Comparator<String> {

	private String reverse(String input) {
		return new StringBuilder(input).reverse().toString();
	}
	
	@Override
	public int compare(String name1, String name2) {
		System.out.println(reverse(name1));
		return reverse(name1).compareTo(reverse(name2));
	}

	
	
}
