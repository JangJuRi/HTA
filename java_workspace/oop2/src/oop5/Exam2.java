package oop5;

import java.util.Scanner;

public class Exam2 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int plus = 0;
		int sum = 0;		
		String[] result = new String[10];
		
		System.out.print("O, X 10개를 입력해주세요 : ");
		
		for(int i=0; i<result.length; i++) {
			result[i] = scanner.next();
		}
		
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
