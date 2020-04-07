package oop1;

import java.util.Scanner;

public class PhoneBookApp {

	public static void main(String[] args) {
		
		PhoneBookService service = new PhoneBookService();
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("========================================================================");
			System.out.println("1. 연락처 추가   2. 연락처 검색   3.그룹 지정   4. 그룹별 검색   0. 종료");
			System.out.println("========================================================================");
			
			System.out.print("메뉴를 입력해주세요 : ");
			int menuNo = scanner.nextInt();
			
			if(menuNo == 1) {
				System.out.print("이름을 입력해주세요 : ");
				String name = scanner.next();
				System.out.print("전화번호를 입력해주세요 : ");
				String number = scanner.next();
				
				PhoneBook phoneBook = new PhoneBook(name, number);
				service.insertPhoneNumber(phoneBook);
				
			} else if(menuNo == 2) {
				System.out.print("검색할 이름을 입력해주세요 : ");
				String name = scanner.next();
				
				service.searchPhoneNumber(name);
				
			} else if(menuNo == 3) {
				System.out.print("그룹을 지정할 사람의 이름을 입력해주세요 : ");
				String name = scanner.next();
				System.out.print("그룹명을 입력해주세요 : ");
				String group = scanner.next();
				
				service.setGroup(name, group);
				
			} else if(menuNo == 4) {
				System.out.print("검색할 그룹을 입력해주세요 : ");
				String group = scanner.next();
				
				service.searchGroup(group);
				
			} else if(menuNo == 0) {
				System.out.println("전화번호부 종료");
				break;
			}
		}	
	}
}
