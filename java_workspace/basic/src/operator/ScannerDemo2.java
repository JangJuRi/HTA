package operator;

import java.util.Scanner;

public class ScannerDemo2 {
	public static void main(String[] args) {
		/*
		 * 학생이름, 국어점수, 영어점수, 수학점수를 입력받는다.
		 * 출력내용
		 * 학생이름, 국어점수, 영어점수, 수학점수, 총점, 평균, 합격여부, 장학금 지급여부
		 * 합격여부는 평균이 60점 이상인 경우만 "예"로 출력. 그 외는 "아니오" 출력
		 * 장학금 지급여부는 평균이 96점 이상인 경우만 "예"로 출력. 그 외는 "아니오" 출력 
		 */
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("이름을 입력해주세요 : ");
		String name = scanner.next();
		System.out.print("국어 점수를 입력해주세요 : ");
		int kor = scanner.nextInt();
		System.out.print("영어 점수를 입력해주세요 : ");
		int eng = scanner.nextInt();
		System.out.print("수학 점수를 입력해주세요 : ");
		int math = scanner.nextInt();
		
		int total = kor + eng + math;
		int avg = total/3;
		
		String pass = avg >= 60 ? "예" : "아니오";
		String Scholarship = avg >= 96 ? "예" : "아니오";
		
		System.out.println("\n학생이름\t국어점수\t영어점수\t수학점수\t총점\t평균\t합격여부\t장학금");
		System.out.println(name +"\t"+ kor +"\t"+ eng +"\t"+ math +"\t"+ total +"\t"+ avg +"\t"+ pass +"\t"+Scholarship);
		
	}
}
