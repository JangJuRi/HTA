package oop5;

public class Exam1 {
	public static void main(String[] args) {
		
		int plus = 0;
		int sum = 0;
		
		String[] result = {"O", "O", "O", "O", "X", "O", "O", "O", "O", "X", "O", "O", "O", "O", "X"};
		
		for(String x : result) {
			
			if(x.equals("O")) {
				plus++;
				sum += plus;
			} else {
				plus = 0;
			}
		}
		System.out.println("결과 : " + sum);
	}
}
