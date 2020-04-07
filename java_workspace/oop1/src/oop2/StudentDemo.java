package oop2;

import java.util.Scanner;

public class StudentDemo {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Student[] students = new Student[100];
		int savePosition = 0;
		Student student;		// Studnet 데이터타입을 담을 수 있는 student 변수를 생성
		
		while(true) {
			
			System.out.println("======================================");
			System.out.println("1. 조회   2. 검색   3. 입력   0. 종료");
			System.out.println("======================================");
			
			int menuNum = scanner.nextInt();
			
			if(menuNum == 1) {
				System.out.println("학생이름\t반\t번호\t국어점수\t영어점수\t수학점수\t총점\t평균");
				System.out.println("==============================================================");
				for(int i=0; i<savePosition; i++) {
					student = students[i];
					student.display();				
				}
				System.out.println();
				
			} else if(menuNum == 2) {			
				System.out.print("검색할 이름을 입력하세요 : ");
				String name = scanner.next();
				
				boolean isFound = false;
				for(int i=0; i<savePosition; i++) {
					if(name.equals(students[i].name)) {
						System.out.println("----- 검색결과 -----");
						System.out.println("학생이름\t반\t번호\t국어점수\t영어점수\t수학점수\t총점\t평균");
						System.out.println("==============================================================");
					
						students[i].display();
						isFound = true;
					} 
				}
				if(!isFound) {
					System.out.println("입력한 이름과 일치하는 학생 정보를 찾을 수 없습니다.");
				}
				
			} else if(menuNum == 3) {
				System.out.print("이름을 입력하세요 : ");
				String name = scanner.next();
				System.out.print("반을 입력하세요 : ");
				int classNum = scanner.nextInt();
				System.out.print("번호를 입력하세요 : ");
				int number = scanner.nextInt();
				System.out.print("국어점수를 입력하세요 : ");
				int kor = scanner.nextInt();
				System.out.print("영어점수를 입력하세요 : ");
				int eng = scanner.nextInt();
				System.out.print("수학점수를 입력하세요 : ");
				int math = scanner.nextInt();
				
				student = new Student();
				
				student.name = name;
				student.classNum = classNum;
				student.number = number;
				student.kor = kor;
				student.eng = eng;
				student.math = math;
				
				students[savePosition] = student;
				savePosition++;
				
			} else if(menuNum == 0) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
		scanner.close();
	}
}
