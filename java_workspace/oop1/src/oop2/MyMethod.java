package oop2;

public class MyMethod {
	
	/*
	 *  인스턴스 메소드	: 멤버 변수와 상호작용하는 메소드
	 *  클래스 메소드	: 멤버 변수와 상호작용하지 않는 메소드, 유틸메소드(자주 사용하는 메소드)에 주로 사용
	 */
	
	// 인스턴스 변수, 멤버 변수
	String name;
	
	// 클래스 변수, 정적 변수(static)
	static final double PI = 3.14;
	
	// 인스턴스 메소드
	// 인스턴스 변수, 클래스 변수 모두 사용 가능
	void meberMethod() {
		System.out.println("인스턴스 변수 사용 : " + name);
		System.out.println("클래스 변수 사용 : " + MyMethod.PI);
	}
	
	// 인스턴스 메소드
	// 인스턴스 메소드, 클래스 메소드 모두 사용 가능
	void memberMethod2() {
		meberMethod();
		MyMethod.staticMethod();
	}
	
	// 클래스 메소드, 정적 메소드
	// 클래스 변수만 사용 가능, 인스턴스 변수 사용 불가
	static void staticMethod() {
	//	System.out.println("인스턴스 변수 사용 : " + name);			// 오류
		System.out.println("클래스 변수 사용 : " + MyMethod.PI);
	}
	
	// 클래스 메소드, 정적 메소드
	// 클래스 메소드 사용 가능, 인스턴스 메소드 사용 불가
	static void staticMethod2() {
	//	meberMethod();												// 오류
		MyMethod.staticMethod();
	}
}
