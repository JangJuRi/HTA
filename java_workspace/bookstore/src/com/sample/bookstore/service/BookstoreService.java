package com.sample.bookstore.service;

import com.sample.bookstore.vo.Book;
import com.sample.bookstore.vo.Rental;
import com.sample.bookstore.vo.User;

public class BookstoreService {

	BookService bookService = new BookService();
	UserService userService = new UserService();
	RentalService rentalService = new RentalService();
	
	// 회원등록 서비스
	// 이름, 전화번호를 전달받아서 회원등록 서비스를 제공한다.
	// 		- User객체를 생성해서 이름과 전화번호를 저장한다.
	//		- 회원등록시 100포인트를 지급한다.
	//		- UserService의 회원등록 기능을 실행한다.
	public void addNewUser(String name, String tel) {
		User user = new User();
		user.name = name;
		user.tel = tel;
		user.point = 100;
		user.isDisabled = false;
		
		userService.insertUser(user);
	}
	
	// 회원조회 서비스
	// 회원번호를 전달받아서 회원번호에 대한 회원정보를 화면에 출력한다.
	//		- UserService의 회원조회기능을 실행해서 회원정보를 제공받는다.
	//		- 조회된 회원정보를 화면에 출력한다.
	public void retrieveUserInfo(int userNo) {
		User findUser = userService.findUserByNo(userNo);
		
		if(findUser == null) {
			System.out.println("===== 입력하신 회원번호와 일치하는 회원을 찾을 수 없습니다. =====");
			return;
		} else {
			System.out.println("==== 회원 정보 ====");
			System.out.println("회원번호 : " + findUser.no);
			System.out.println("회원이름 : " + findUser.name);
			System.out.println("전화번호 : " + findUser.tel);
			System.out.println("포 인 트 : " + findUser.point);
			System.out.println("탈퇴여부 : " + findUser.isDisabled);
			System.out.println("===================\n");	
		}		
	}
	
	// 회원수정 서비스
	// 수정할 회원정보를 전달받아서 해당 회원의 정보를 수정한다.
	//		- UserService의 회원정보 변경기능을 실행해서 회원정보를 수정한다.
	public void modifyUserInfo(User user) {
		userService.updateUser(user);
	}
	
	// 회원탈퇴 서비스
	// 탈퇴처리할 회원번호를 전달받아서 해당 회원을 탈퇴처리한다.
	//		- UserService의 회원조회기능을 실행해서 회원정보를 제공받는다.
	//		- 조회된 회원의 탈퇴여부를 탈퇴처리로 변경한다.
	//		- RentalService의 반납기능을 실행해서 해당 회원이 대여중인 모든 책을 반납처리한다.
	public void disabledUser(int userNo) {
		User findUser = userService.findUserByNo(userNo);
		
		if(findUser == null) {
			System.out.println("===== 입력하신 회원번호와 일치하는 회원을 찾을 수 없습니다. =====");
			return;
		}
		
		findUser.isDisabled = true;	
		rentalService.returnAllRentalByUserNo(userNo);				
	}
	
	// 전체 회원조회 서비스
	// 등록된 모든 회원정보 조회를 처리한다.
	// 		- UserService의 모든 회원정보 조회기능을 실행해서 모든 회원정보를 제공받는다.
	//		- 조회된 회원정보를 화면에 출력한다.(null체크)
	public void retrieveAllUsers() {
		User[] allUsers = userService.getAllUsers();
		
		System.out.println("회원번호\t회원이름\t전화번호\t\t포인트\t탈퇴여부");
		for(int i=0; i<allUsers.length; i++) {
			if(allUsers[i] == null) {
				break;
			}
			
			System.out.print(allUsers[i].no + "\t");
			System.out.print(allUsers[i].name + "\t");
			System.out.print(allUsers[i].tel + "\t");
			System.out.print(allUsers[i].point + "\t");
			System.out.println(allUsers[i].isDisabled);
		}
	}
	
	// 대여현황 출력 서비스
	// 고객 이름을 입력받아서 그 고객의 모든 대여현황을 출력한다.
	public void userRentalStatus(String name) {
		int userNo = userService.findUserByName(name);
		Rental[] rental = rentalService.getUserRentalStatus(userNo);
		
		if(rental == null || userNo == -1) {
			System.out.println("일치하는 정보가 없습니다.");
			return;
		} else {
			System.out.println("대여번호\t도서번호\t도서제목\t\t가격\t회원번호\t회원이름\t상태");
			System.out.println("==============================================================");
			
			for(int i=0; i<rental.length; i++) {
				
				if(rental[i] == null) {
					break;
				}
				Book findBook = bookService.findBookByNo(rental[i].bookNo);
				
				String title = bookService.findBookNameByNo(rental[i].bookNo);
				String userName = userService.findUserNameByNo(rental[i].userNo);
				int price = findBook.price;
				
				System.out.print(rental[i].no + "\t");
				System.out.print(rental[i].bookNo + "\t");
				System.out.print(title + "\t");
				System.out.print(price + "\t");
				System.out.print(rental[i].userNo + "\t");
				System.out.print(userName + "\t");
				System.out.println(rental[i].isRent);
			}
		}
	}
	
	// 도서등록 서비스
	// 제목, 저자, 가격을 전달받아서 도서 등록 서비스를 처리한다.
	//		- Book객체를 생성해서 제목, 저자, 가격 정보를 저장한다.
	//		- 재고는 10000권으로 한다.
	// 		- BookService의 도서등록기능을 실행한다.
	public void insertNewBook(String title, String writer, int price) {
		Book book = new Book();
		book.title = title;
		book.writer = writer;
		book.price = price;
		book.stock = 10000;
		
		bookService.insertBook(book);
	}
	
	// 도서 검색 서비스
	// 제목를 전달받아서 도서 검색서비스를 처리한다.
	//		- BookService의 도서 검색기능을 실행해서 책정보를 제공받는다.
	//		- 조회된 책정보를 화면에 출력한다.
	public void searchBooks(String title) {
		Book[] booknames = bookService.findBookByTitle(title);
		
		for(int i=0; i<booknames.length; i++) {
			System.out.println("==== 도서 정보 ====");
			System.out.println("도서 번호 : " + booknames[i].no);
			System.out.println("도서 제목 : " + booknames[i].title);
			System.out.println("도서 저자 : " + booknames[i].writer);
			System.out.println("도서 가격 : " + booknames[i].price);
			System.out.println("도서 재고 : " + booknames[i].stock);
			System.out.println("===================\n");
		}
	}
	
	// 도서 정보 수정 서비스
	// 책정보를 전달받아서 책정보 수정서비스를 처리한다.
	//		- BookService의 책정보 수정기능을 실행한다.
	public void modifyBook(Book book) {
		bookService.updateBook(book);
	}
	
	// 전체도서 조회 서비스
	// 모든 책정보 조회 서비스를 처리한다.
	// 		- BookService의 모든 책조회 기능을 실행한다.
	public void retrieveAllBooks() {
		Book[] allBooks = bookService.getAllBooks();
		
		System.out.println("도서번호\t도서제목\t\t도서저자\t도서가격\t도서재고");
		for(int i=0; i<allBooks.length; i++) {
			if(allBooks[i] == null) {
				break;
			}
			
			System.out.print(allBooks[i].no + "\t");
			System.out.print(allBooks[i].title + "\t");
			System.out.print(allBooks[i].writer + "\t");
			System.out.print(allBooks[i].price + "\t");
			System.out.println(allBooks[i].stock);
		}
	}
		
	// 현재 대여중인 모든 책 정보를 출력하기
	public void isRentBooks() {
		Rental[] rental = rentalService.getIsRentBooks();
		
		System.out.println("대여번호\t도서번호\t도서제목\t\t회원번호\t회원이름\t상태");
		System.out.println("======================================================");
		
		for(int i=0; i<rental.length; i++) {
			
			if(rental[i] == null) {
				break;
			}
			
			String title = bookService.findBookNameByNo(rental[i].bookNo);
			String userName = userService.findUserNameByNo(rental[i].userNo);
			
			System.out.print(rental[i].no + "\t");
			System.out.print(rental[i].bookNo + "\t");
			System.out.print(title + "\t");
			System.out.print(rental[i].userNo + "\t");
			System.out.print(userName + "\t");
			System.out.println(rental[i].isRent);
		}
	}
	
	// 도서번호를 입력받아서 그 책을 대여중인 고객정보를 출력하기
	public void isRentUser(int bookNo) {
		Rental[] findUserRentBook = rentalService.getIsRentUsers(bookNo);
		
		System.out.println("대여번호\t도서번호\t도서제목\t\t회원번호\t회원이름\t대여상태");
		System.out.println("======================================================");
		
		for(int i=0; i<findUserRentBook.length; i++) {
			
			if(findUserRentBook[i] == null) {
				break;
			}
			
			String title = bookService.findBookNameByNo(findUserRentBook[i].bookNo);
			String userName = userService.findUserNameByNo(findUserRentBook[i].userNo);
			
			System.out.print(findUserRentBook[i].no + "\t");
			System.out.print(findUserRentBook[i].bookNo + "\t");
			System.out.print(title + "\t");
			System.out.print(findUserRentBook[i].userNo + "\t");
			System.out.print(userName + "\t");
			System.out.println(findUserRentBook[i].isRent);
		}
	}
	
	// 대여 서비스
	// 사용자번호와 책번호를 전달받아서 대여 서비스를 처리한다.
	//		- Rental객체를 생성해서 사용자번호, 책번호를 저장한다.
	//		- 대여여부는 대여중으로 설정한다.
	//		- 책재고 변경하기
	//			- BookService에서 책번호에 해당하는 책정보 조회기능 실행
	//			- 조회된 책의 재고를 1감소시킨다.
	public void rentBook(int userNo, int bookNo) {
		
		User findUser = userService.findUserByNo(userNo);
		Book findBook = bookService.findBookByNo(bookNo);
		Rental rental = new Rental();
		
		if(findUser == null || findBook == null) {
			System.out.println("===== 정보를 정확히 입력해주세요 =====");
			return;
		}
		rental.userNo = userNo;
		rental.bookNo = bookNo;
		rental.isRent = true;
		rentalService.insertRental(rental);		
		findBook.stock--;
		System.out.println("===== 대여가 완료되었습니다. =====");
	}
	
	// 반납 서비스
	// 대여번호를 전달받아서 반납 서비스를 처리한다.
	//		- RentalService에서 대여번호에 해당하는 대여정보 조회 기능을 실행
	//		- 조회된 대여정보의 반납여부를 false로 설정한다.
	//		- 사용자포인트 증가, 책재고 변경하기
	//			- UserService에서 사용자번호로 사용자정보 조회하기 실행
	//			- BookService에서 책번호로 책정보 조회하기 실행
	//			- 조회된 사용자의 포인트를 책가격의 1%만큼 증가시키기
	//			- 조회된 책정보의 재고를 1증가시키기
	public void returnBook(int rentalNo) {
		Rental findRental = rentalService.findRentalByNo(rentalNo);
		
		if(findRental == null) {
			System.out.println("===== 대여번호와 일치하는 정보를 찾을 수 없습니다. =====");
			return;
		}
		findRental.isRent = false;
		User findUser = userService.findUserByNo(findRental.userNo);
		Book findBook = bookService.findBookByNo(findRental.bookNo);
		
		findUser.point += (findBook.price * 0.01);
		findBook.stock++;
		System.out.println("===== 반납이 완료되었습니다. =====");		
	}
	
	// 대여현황 조회 서비스
	// 모든 대여정보를 조회하는 서비스를 처리한다.
	//		- RentalService의 전체 대여정보조회 기능을 실행한다.
	//		- 조회된 대여정보를 화면에 출력한다. (null체크)
	public void retrieveAllRentals() {
		Rental[] allRentals = rentalService.getAllRentals();
		
		System.out.println("대여번호\t도서번호\t도서제목\t\t회원번호\t회원이름\t상태");
		System.out.println("======================================================");
		for(int i=0; i<allRentals.length; i++) {
			if(allRentals[i] == null) {
				break;
			}
			String title = bookService.findBookNameByNo(allRentals[i].bookNo);
			String userName = userService.findUserNameByNo(allRentals[i].userNo);
			
			System.out.print(allRentals[i].no + "\t");
			System.out.print(allRentals[i].bookNo + "\t");
			System.out.print(title + "\t");
			System.out.print(allRentals[i].userNo + "\t");
			System.out.print(userName + "\t");
			System.out.println(allRentals[i].isRent);
		}
	}
	
	// 일괄반납 서비스
	public void AllReturnBooks(int userNo) {
		rentalService.returnAllRentalByUserNo(userNo);
	}
}