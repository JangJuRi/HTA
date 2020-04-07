package oop1;

public class Exercise6_2 {
	public static void main(String[] args) {
		Student s = new Student("홍길동", 1, 1, 100, 60, 76);
		
		String string = s.info();
		System.out.println(string);
	}
}

class Student {
	
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	
	Student(String sName, int sBan, int sNo, int sKor, int sEng, int sMath) {
		name = sName;
		ban = sBan;
		no = sNo;
		kor = sKor;
		eng = sEng;
		math = sMath;
	}
	
	String info() {
		int total = kor + eng + math;
		double avg = total/3.0;
		
		String string = name + "," + ban + "," + no + "," + kor + "," + eng + "," + math + "," + total + "," + avg;
		
		return string;
	}
}