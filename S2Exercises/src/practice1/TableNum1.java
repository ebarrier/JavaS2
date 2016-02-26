package practice1;

public class TableNum1 {
	
	public static void main(String[] args) {
		
		int size = 10;
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(Math.min(size - i - 1, size - j - 1) + " ");
			}
			System.out.println();
		}
	}

}
