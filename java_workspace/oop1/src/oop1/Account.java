package oop1;

public class Account {
	
	//클래스 변수(static) - 상수
	static final double RATE_OF_INTEREST = 0.021;		//(년 단위) 금리
	
	//인스턴스 변수
	String owner;		// 예금주
	String no;			// 계좌번호
	String password;	// 비밀번호
	int balance;		// 잔액
	int period;			// 예금기간 (개월 단위)
}
