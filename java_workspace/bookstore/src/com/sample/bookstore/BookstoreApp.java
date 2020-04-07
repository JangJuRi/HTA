package com.sample.bookstore;

import java.util.Scanner;

import com.sample.bookstore.service.BookstoreService;
import com.sample.bookstore.vo.Book;
import com.sample.bookstore.vo.User;

public class BookstoreApp {

	public static void main(String[] args) {
	
		BookstoreService service = new BookstoreService();
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.println();
			System.out.println("[도서 대여점 관리 프로그램]");
			System.out.println("================================================");
			System.out.println(" 1.회원관리  2.도서관리  3.대여관리  0.종료");
			System.out.println("================================================");
			
			System.out.print("메뉴를 선택하세요: ");
			int menuNo = scanner.nextInt();
			
			if (menuNo == 1) {
				System.out.println();
				System.out.println("[회원 관리]");
				System.out.println("=======================================================");
				System.out.println(" 1.등록  2.조회  3.변경  4.탈퇴  5.전체조회  6.대여현황");
				System.out.println("=======================================================");
				
				System.out.print("회원관련 메뉴를 선택하세요: ");
				int userMenuNo = scanner.nextInt();
				
				if (userMenuNo == 1) {
					System.out.println("[신규 회원 등록]");
					
					System.out.print("이름을 입력하세요: ");
					String name = scanner.next();
					System.out.print("전화번호를 입력하세요: ");
					String tel = scanner.next();
					
					service.addNewUser(name, tel);
					System.out.println("### 회원등록이 완료되었습니다.");
					
				} else if (userMenuNo == 2) {
					System.out.print("회원 번호를 입력하세요 : ");
					int userNo = scanner.nextInt();
					
					service.retrieveUserInfo(userNo);
					
				} else if (userMenuNo == 3) {
					System.out.print("회원 번호를 입력하세요 : ");
					int userNo = scanner.nextInt();
					System.out.print("이름을 입력하세요: ");
					String name = scanner.next();
					System.out.print("전화번호를 입력하세요: ");
					String tel = scanner.next();
					
					User user = new User(userNo, name, tel, 100, false);
					
					service.modifyUserInfo(user);
					
				} else if (userMenuNo == 4) {
					System.out.print("회원 번호를 입력하세요 : ");
					int userNo = scanner.nextInt();
					
					service.disabledUser(userNo);
					
				} else if (userMenuNo == 5) {
					service.retrieveAllUsers();
					
				} else if (userMenuNo == 6) {
					System.out.print("이름을 입력하세요: ");
					String name = scanner.next();
					
					service.userRentalStatus(name);
				}
				
			} else if (menuNo == 2) {
				System.out.println();
				System.out.println("[도서 관리]");
				System.out.println("================================================");
				System.out.println(" 1.검색  2.등록  3.수정  4.전체조회  5.대여현황");
				System.out.println("================================================");
				
				System.out.print("도서관련 메뉴를 선택하세요: ");
				int bookMenuNo = scanner.nextInt();
				
				if(bookMenuNo == 1) {
					System.out.print("책 제목을 입력하세요 : ");
					String title = scanner.next();
					
					service.searchBooks(title);
					
				} else if(bookMenuNo == 2) {
					System.out.print("도서 제목을 입력하세요 : ");
					String title = scanner.next();
					System.out.print("도서 저자를 입력하세요 : ");
					String writer = scanner.next();
					System.out.print("도서 가격을 입력하세요 : ");
					int price = scanner.nextInt();
					
					service.insertNewBook(title, writer, price);
					
				} else if(bookMenuNo == 3) {
					System.out.print("도서 번호를 입력하세요 : ");
					int no = scanner.nextInt();
					System.out.print("도서 제목을 입력하세요 : ");
					String title = scanner.next();
					System.out.print("도서 저자를 입력하세요 : ");
					String writer = scanner.next();
					System.out.print("도서 가격을 입력하세요 : ");
					int price = scanner.nextInt();
					
					Book book = new Book(no, title, writer, price, 10000);
					service.modifyBook(book);
					
				} else if(bookMenuNo == 4) {
					service.retrieveAllBooks();
					
				} else if(bookMenuNo == 5) {
					System.out.print("도서 번호를 입력하세요 : ");
					int no = scanner.nextInt();
					
					service.isRentUser(no);
				}

// 문제사라짐
//				else if(bookMenuNo == 5) {
//					service.isRentBooks();	
//				} 
				
			} else if (menuNo == 3) {
				System.out.println();
				System.out.println("[대여/반납 관리]");
				System.out.println("===========================================");
				System.out.println(" 1.대여  2.반납  3.대여현황조회  4.일괄반납");
				System.out.println("===========================================");
				
				System.out.print("대여/반납관련 메뉴를 선택하세요: ");
				int rentalMenuNo = scanner.nextInt();
				
				if(rentalMenuNo == 1) {
					System.out.print("회원 번호를 입력하세요 : ");
					int userNo = scanner.nextInt();
					System.out.print("도서 번호를 입력하세요 : ");
					int bookNo = scanner.nextInt();
					
					service.rentBook(userNo, bookNo);
					
				} else if(rentalMenuNo == 2) {
					System.out.print("반납 번호를 입력하세요 : ");
					int rentalNo = scanner.nextInt();
					
					service.returnBook(rentalNo);
					
				} else if(rentalMenuNo == 3) {
					service.retrieveAllRentals();
					
				} else if(rentalMenuNo == 4) {
					System.out.print("회원 번호를 입력하세요 : ");
					int userNo = scanner.nextInt();
					
					service.AllReturnBooks(userNo);
				}
				
			} else if (menuNo == 0) {
				System.out.println("[프로그램 종료]");
				break;
			}
		}
		
		scanner.close();
	}
}