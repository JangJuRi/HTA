package oop2;

import java.util.Scanner;

public class BankingDemo2 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Banking[] bankings = new Banking[100];
		int savePosition = 0;
		
		while(true) {
			System.out.println("========================================================================");
			System.out.println("1. 신규   2. 조회   3. 입금   4. 출금   5. 비번변경   6. 해지   0. 종료");
			System.out.println("========================================================================");
			
			int menuNum = scanner.nextInt();
			if(menuNum == 1) {
				Banking banking = new Banking();
				
				System.out.print("이름을 입력하세요 : ");
				String name = scanner.next();
				System.out.print("계좌번호를 입력하세요 : ");
				String no = scanner.next();
				System.out.print("비밀번호를 입력하세요 : ");
				int password = scanner.nextInt();
				System.out.print("잔액을 입력하세요 : ");
				long balance = scanner.nextLong();
				System.out.print("가입기간을 입력하세요 : ");
				int period = scanner.nextInt();
				
				banking.name = name;
				banking.no = no;
				banking.password = password;
				banking.balance = balance;
				banking.period = period;
				
				bankings[savePosition] = banking;
				savePosition++;
				
			} else if(menuNum == 2) {
				Banking banking = new Banking();
				
				System.out.print("계좌번호를 입력해주세요 : ");
				String no = scanner.next();
				
				boolean isFound = false;
				for(int i=0; i<savePosition; i++) {
					if(no.equals(bankings[i].no)) {
						banking = bankings[i];
						banking.display();
						
						isFound = true;
					} 
				}
				
				if(!isFound) {
					System.out.println("정보를 찾을 수 없습니다.");
				}
				
			} else if(menuNum == 3) {
				
				System.out.print("계좌번호를 입력해주세요 : ");
				String no = scanner.next();
				System.out.print("입금액을 입력해주세요 : ");
				long balance = scanner.nextLong();
				
				boolean isFound = false;
				for(int i=0; i<savePosition; i++) {
					if(no.equals(bankings[i].no)) {
						Banking banking = bankings[i];
						banking.deposit(balance);					
						
						isFound = true;
					}
				}
				
				if(!isFound) {
					System.out.println("정보를 찾을 수 없습니다.");
				}
				
			} else if(menuNum == 4) {				
				System.out.print("계좌번호를 입력해주세요 : ");
				String no = scanner.next();
				System.out.print("출금액을 입력해주세요 : ");
				long withdrawMoney = scanner.nextLong();
				System.out.println("비밀번호를 입력해주세요 : ");
				int password = scanner.nextInt();			
				
				boolean isFound = false;
				for(int i=0; i<savePosition; i++) {
					if(no.equals(bankings[i].no)) {
						Banking banking = bankings[i];
						banking.withdraw(withdrawMoney, password);
						
						isFound = true;
					}
				}
				
				if(!isFound) {
					System.out.println("정보를 찾을 수 없습니다.");
				}
				
			} else if(menuNum == 5) {			
				System.out.print("계좌번호를 입력해주세요 : ");
				String no = scanner.next();
				System.out.print("이전 비밀번호를 입력해주세요 : ");
				int oldPwd = scanner.nextInt();
				System.out.print("새 비밀번호를 입력해주세요 : ");
				int newPwd = scanner.nextInt();
				
				boolean isFound = false;
				for(int i=0; i<savePosition; i++) {
					if(no.equals(bankings[i].no)) {
						Banking banking = bankings[i];
						banking.changePassword(oldPwd, newPwd);
						
						isFound = true;
						
					}
				}
				
				if(!isFound) {
					System.out.println("정보를 찾을 수 없습니다.");
				}
				
			} else if(menuNum == 6) {
				System.out.print("계좌번호를 입력해주세요 : ");
				String no = scanner.next();
				System.out.print("이전 비밀번호를 입력해주세요 : ");
				int password = scanner.nextInt();
				
				boolean isFound = false;
				for(int i=0; i<savePosition; i++) {
					if(no.equals(bankings[i].no)) {
						Banking banking = bankings[i];
						banking.close(password);
						
						isFound = true;
					}
				}
				
				if(!isFound) {
					System.out.println("정보를 찾을 수 없습니다.");
				}
				
			} else if(menuNum == 0) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
	}
}
