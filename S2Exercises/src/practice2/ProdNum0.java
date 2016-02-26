package practice2;

public class ProdNum0 {
	
	public static int prod(Integer number) {
		
		if (null==number || number==0) {
			return 0;
		}
		
		int prod=1;
		
		number = Math.abs(number);
		
		while (number > 0) {
			int digit = number % 10;
			prod *= digit;
			number = number / 10; //or number /= 10;
		}
		
		return prod;
	}
	
	public static void main(String[] args) {
		System.out.println(prod(123));
		System.out.println(prod(234));
	}

}
