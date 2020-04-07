package oop5;

// 추상클래스 정의	--> new 키워드로 객체 생성 불가능
public abstract class Unit {

	String name;
	
	void move() {
		System.out.println("[" + name + "] 이 지정된 포인트로 이동합니다.");
	}
	
	// 추상메소드 정의
	abstract void attack();
}