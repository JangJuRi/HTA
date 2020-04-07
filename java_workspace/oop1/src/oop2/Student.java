package oop2;

public class Student {
	
	String name;
	int classNum;
	int number;
	int kor;
	int eng;
	int math;
	
	int sum() {	
		return kor + eng + math;
	}
	
	int average() {
		int totalScore = sum();
		
		return totalScore/3;
	}
	
	void display() {
		System.out.print(name + "\t" + classNum + "\t" + number + "\t" + kor  + "\t" + eng  + "\t" + math + "\t" + sum() + "\t" + average());
		System.out.println();
	}
}
