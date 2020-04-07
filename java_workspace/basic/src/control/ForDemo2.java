package control;

public class ForDemo2 {
	public static void main(String[] args) {
		/*
		 * 1부터 5까지의 합계를 계산하기
		 */
		
		int sum = 0;
		int num = 5;
		
		for(int i=1; i<=num; i++) {
			sum+=i;
		}
		System.out.println("1부터 "+ num + "까지의 합은 " + sum + "입니다.");
	}
}
