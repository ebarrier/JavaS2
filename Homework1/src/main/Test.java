package main;

import java.util.Arrays;

public class Test {
	
	public static void main(String[] args) {
		
		System.out.println(Arrays.deepToString(random(2, 6)));
	}
	
	public static double[][] random(int m, int n) {
		double[][] c = new double[m][n];
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				c[i][j] = Math.random();
		return c;
	}

}
