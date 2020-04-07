package control;

public class Exercise4_4 {
	public static void main(String[] args) {
		int number = 1;
		int sum = 0;
		
		while(true) {
			if(number % 2 != 0) {
				sum += number;
			} else {
				sum += number*(-1);
			}
			if(sum >= 100) {
				break;
			}
			number++;
		}
		System.out.println(number);
	}
}
