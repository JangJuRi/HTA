package com.sample.bookstore.service;

import java.util.ArrayList;
import java.util.List;

import com.sample.bookstore.dao.BookDAO;
import com.sample.bookstore.dao.OrderDAO;
import com.sample.bookstore.dao.UserDAO;
import com.sample.bookstore.vo.Book;
import com.sample.bookstore.vo.Order;
import com.sample.bookstore.vo.User;

/**
 * 회원가입, 책 검색, 책 상세정보 조회, 주문하기, 내 주문 조회하기, 주문 상세정보보기 등의 기능을 제공하는 객체다.
 * @author JHTA
 *
 */
public class BookstoreService {

	private UserDAO userDAO = new UserDAO();
	private BookDAO bookDAO = new BookDAO();
	private OrderDAO orderDAO = new OrderDAO();
	
	/**
	 * 신규 사용자 정보를 등록한다.
	 * @param user 신규 사용자 정보
	 * @return 회원가입이 성공하면 true를 반환한다.
	 * @throws Exception
	 */
	public boolean 회원가입(User user) throws Exception {
		User savedUser = userDAO.getUserById(user.getId());
		if(savedUser != null) {
			return false;
		}
		userDAO.addUser(user);
		return true;
	}
	
	/**
	 * 지정된 키워드가 제목에 포함된 책정보를 반환한다.
	 * @param title 검색 키워드
	 * @return 검색된 책들
	 * @throws Exception
	 */
	public List<Book> 도서검색(String title) throws Exception {
		return bookDAO.getBooksByTitle(title);
	}
	
	/**
	 * 지정된 책번호에 해당하는 책정보를 반환한다.
	 * @param bookNo 조회할 책번호
	 * @return 책 정보, 유효한 번호가 아닌 경우 null이 반환된다.
	 * @throws Exception
	 */
	public Book 도서상세정보(int bookNo) throws Exception {
		return bookDAO.getBookByNo(bookNo);
	}
	
	/**
	 * 주문요청을 처리합니다.
	 * @param userId 주문자 아이디
	 * @param bookNo 주문할 책번호
	 * @param amount 주문 수량
	 * @return 주문 성공 시 true를 반환한다.
	 * @throws Exception
	 */
	public boolean 주문하기(String userId, int bookNo, int amount) throws Exception {
		User user = userDAO.getUserById(userId);
		if(user == null) { // 회원정보가 없음
			return false;
		}
		Book book = bookDAO.getBookByNo(bookNo);
		if(book == null) { // 책 정보가 없음
			return false;
		}
		if(book.getStock() < amount) { // 재고가 부족함
			return false;
		}
		
		Order order = new Order();
		order.setUser(user);
		order.setBook(book);
		order.setAmount(amount);
		order.setPrice(book.getDiscountPrice());
		
		// 주문 정보 저장
		orderDAO.addOrder(order);
		
		// 책 재고 변경
		book.setStock(book.getStock() - amount);
		bookDAO.updateBook(book);
		
		// 사용자 포인트 변경
		int depositPoint = (int) (book.getDiscountPrice()*amount*0.03);
		user.setPoint(user.getPoint() + depositPoint);
		userDAO.updateUser(user);
		
	    return true;
		
	}
	
	public List<Order> 내주문조회(String userId) throws Exception {
		
		return null;
	}
	
	public Order 주문상세정보(int orderNo) throws Exception {
		
		return null;
	}
	
	public void addNewOrder(Order order) throws Exception {
	}
	
	
	
	
}
