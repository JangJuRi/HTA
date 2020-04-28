package com.sample.bookstore.service;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;

import com.sample.bookstore.dao.AnswerDAO;
import com.sample.bookstore.dao.BookDAO;
import com.sample.bookstore.dao.OrderDAO;
import com.sample.bookstore.dao.QuestionDAO;
import com.sample.bookstore.dao.ReviewDAO;
import com.sample.bookstore.dao.UserDAO;
import com.sample.bookstore.vo.Answer;
import com.sample.bookstore.vo.Book;
import com.sample.bookstore.vo.Order;
import com.sample.bookstore.vo.Question;
import com.sample.bookstore.vo.Review;
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
	private QuestionDAO questionDAO = new QuestionDAO();
	private AnswerDAO answerDAO = new AnswerDAO();
	private ReviewDAO reviewDAO = new ReviewDAO();
	
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
		
		// 비밀번호 암호화하기
		String md5Password = DigestUtils.md5Hex(user.getPassword());
		user.setPassword(md5Password);
		
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
	
	/**
	 * 지정된 사용자아이디의 모든 주문내역을 반환한다.
	 * @param userId 주문내역을 조회할 사용자 아이디
	 * @return 주문내역정보, 주문 내역이 없는 경우 empty List가 반환된다.
	 * @throws Exception
	 */
	public List<Order> 내주문조회(String userId) throws Exception {
		return orderDAO.getOrdersByUserId(userId);
	}
	
	/**
	 * 지정된 주문번호에 해당하는 주문정보를 반환한다.
	 * @param orderNo 주문정보를 조회할 주문번호
	 * @return 주문정보 상세내역, 주문번호가 틀린 경우 null이 반환된다.
	 * @throws Exception
	 */
	public Order 주문상세정보(int orderNo) throws Exception {
		
		return orderDAO.getOrderByNo(orderNo);
	}
	
	
	
	
	public boolean 문의등록(String userId, Question question) throws Exception {
		User savedUser = userDAO.getUserById(userId);
		if(savedUser == null) {
			return false;
		}
		question.setUser(savedUser);
		questionDAO.addQuestion(question);
		return true;
	}
	
	public void 답변등록(int questionNo, String content) throws Exception {
		Answer answer = new Answer();
		answer.setQuestion(questionNo);
		answer.setContent(content);
		
		answerDAO.addAnswer(answer);
	}
	
	public List<Question> 문의글전체조회() throws Exception {
		return questionDAO.getAllQuestions();
	}
	
	public Question 문의글조회(int questionNo) throws Exception {
		Question savedQuestion = questionDAO.getQuestionByNo(questionNo);		
		if(savedQuestion == null) {
			return null;
		} 
		Answer savedAnswer = answerDAO.getAnswer(questionNo);
		
		savedQuestion.setAnswer(savedAnswer);
		
		return savedQuestion;
	}
	
	public void 문의글삭제(int questionNo, String userId) throws Exception {
		Question savedQuestion = questionDAO.getQuestionByNo(questionNo);
		if(savedQuestion == null) {
			System.out.println("해당 질문 번호와 일치하는 정보가 없습니다.");
			return;
		}
		// 답변이 달려있는 글인지 체크
		if(savedQuestion.getStatus().equalsIgnoreCase("Y")) {
			System.out.println("답변이 달린 글은 삭제가 불가능합니다.");
			return;
		}
		
		if(savedQuestion.getUser().getId().equals(userId)) {
			questionDAO.removeQuestion(questionNo);
			System.out.println("삭제가 완료되었습니다.");
		} else {
			System.out.println("해당 질문 번호와 일치하는 정보가 없습니다.");
		}
	}
	
	public void 리뷰등록(Review review) throws Exception {
		reviewDAO.addReview(review);
	}
	
	public List<Review> 리뷰조회(int bookNo) throws Exception {
		return reviewDAO.getAllReviewsByBookNo(bookNo);
	}
}
