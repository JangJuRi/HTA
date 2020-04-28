package com.sample.bookstore.app;

import java.util.List;

import com.sample.bookstore.service.BookstoreService;
import com.sample.bookstore.util.KeyboardUtil;
import com.sample.bookstore.util.QueryUtil;
import com.sample.bookstore.vo.Book;
import com.sample.bookstore.vo.Order;
import com.sample.bookstore.vo.Question;
import com.sample.bookstore.vo.Review;
import com.sample.bookstore.vo.User;

import oracle.net.aso.q;

public class Bookstore {

	public static void main(String[] args) throws Exception {
		
		BookstoreService service = new BookstoreService();
		
		while(true) {
			System.out.println("------------------------------------------------------------------");
			System.out.println("1.가입   2.검색   3.책 정보   4.주문   5.내 주문   6.주문정보   7.문의게시판   8.리뷰게시판   0.종료");
			System.out.println("------------------------------------------------------------------");
			
			System.out.print("메뉴를 선택하세요 : ");
			int menuNo = KeyboardUtil.nextInt();
			
			if(menuNo == 1) {
				System.out.println("[신규 회원가입]");

				System.out.print("아이디를 입력하세요 : ");
				String id = KeyboardUtil.nextString();
				
				System.out.print("비밀번호를 입력하세요 : ");
				String password = KeyboardUtil.nextString();
				
				System.out.print("이름을 입력하세요 : ");
				String name = KeyboardUtil.nextString();
				
				System.out.print("이메일을 입력하세요 : ");
				String email = KeyboardUtil.nextString();
				
				User user = new User();
				user.setId(id);
				user.setPassword(password);
				user.setName(name);
				user.setEmail(email);
				
				boolean isSuccess = service.회원가입(user);
				if(isSuccess) {
					System.out.println("### 회원가입이 완료되었습니다.");
				} else {
					System.out.println("!!! 이미 사용중인 아이디입니다.");
				}
				
			} else if (menuNo == 2) {
				System.out.println("[책 검색하기]");
				
				System.out.print("키워드를 입력하세요 : ");
				String keyword = KeyboardUtil.nextString();
				
				List<Book> books = service.도서검색(keyword);
				if(books.isEmpty()) {
					System.out.println("!!! 검색결과가 존재하지 않습니다.");
				} else {
					System.out.println(books.size() + "권의 책이 조회되었습니다.");
					System.out.println("-----------------------------------------------");
					System.out.println("번호\t제목\t저자\t출판사\t가격");
					for(Book book : books) {
						System.out.print(book.getNo() + "\t");
						System.out.print(book.getTitle() + "\t");
						System.out.print(book.getWriter() + "\t");
						System.out.print(book.getPublisher() + "\t");
						System.out.println(book.getPrice() + "\t");
					}
					System.out.println("-----------------------------------------------");
				}
				
			} else if (menuNo == 3) {
				System.out.println("[책 정보 상세보기]");
				
				System.out.print("조회할 책번호를 입력하세요 : ");
				int bookNo = KeyboardUtil.nextInt();
				
				Book book = service.도서상세정보(bookNo);
				if(book == null) {
					System.out.println("유효한 책번호가 아닙니다.");
				} else {
					System.out.println("-----------------------------------------------");
					System.out.println("번      호 : " + book.getNo());
					System.out.println("제      목 : " + book.getTitle());
					System.out.println("저      자 : " + book.getWriter());
					System.out.println("장      르 : " + book.getGenre());
					System.out.println("출  판  사 : " + book.getPublisher());
					System.out.println("가      격 : " + book.getPrice());
					System.out.println("할인가격 : " + book.getDiscountPrice());
					System.out.println("재      고 : " + book.getStock());
					System.out.println("등  록  일 : " + book.getRegisteredDate());
					System.out.println("-----------------------------------------------");
				}
				
			} else if (menuNo == 4) {
				System.out.println("[주문하기]");
				
				System.out.print("주문할 책번호를 입력하세요 : ");
				int bookNo = KeyboardUtil.nextInt();
				
				System.out.print("주문수량을 입력하세요 : ");
				int amount = KeyboardUtil.nextInt();
				
				System.out.print("주문자 아이디를 입력하세요 : ");
				String userId = KeyboardUtil.nextString();
				
				boolean isSuccess = service.주문하기(userId, bookNo, amount);
				if(isSuccess) {
					System.out.println("### 주문이 완료되었습니다.");
				} else {
					System.out.println("!!! 주문처리 중 오류가 발생하였습니다.");
				}
				
			} else if (menuNo == 5) {
				System.out.println("[내 주문 전부 보기]");
				
				System.out.print("사용자 아이디를 입력하세요 : ");
				String userId = KeyboardUtil.nextString();
				
				List<Order> myOrders = service.내주문조회(userId);
				if(myOrders.isEmpty()) {
					System.out.println("!!! 주문내역이 존재하지 않습니다.");
				} else {
					System.out.println("-----------------------------------------------");
					System.out.println("주문번호\t책제목\t구매수량\t가격");
					for(Order order : myOrders) {
						System.out.print(order.getNo() + "\t");
						System.out.print(order.getBook().getTitle() + "\t");
						System.out.print(order.getAmount() + "\t");
						System.out.println(order.getPrice() + "\t");
					}
					System.out.println("-----------------------------------------------");
				}
				
			} else if (menuNo == 6) {
				System.out.println("[주문 정보 상세보기]");
				
				System.out.print("주문번호를 입력하세요 : ");
				int orderNo = KeyboardUtil.nextInt();
				
				Order order = service.주문상세정보(orderNo);
				if(order == null) {
					System.out.println("!!! 주문번호에 해당하는 주문정보가 존재하지 않습니다.");
				} else {
					System.out.println("-----------------------------------------------");
					System.out.println("주문번호 : " + order.getNo());
					System.out.println("사용자명 : " + order.getUser().getName());
					System.out.println("제목 : " + order.getBook().getTitle());
					System.out.println("가격 : " + order.getBook().getPrice());
					System.out.println("구매가격 : " + order.getPrice());
					System.out.println("구매수량 : " + order.getAmount());
					System.out.println("주문날짜 : " + order.getRegisteredDate());
					System.out.println("-----------------------------------------------");
				}
				
			} else if(menuNo == 7) {
				System.out.println("[문의 게시판]");
				
				System.out.println("-------------------------");
				System.out.println("1.전체조회   2.등록   3.조회   4.삭제");
				System.out.println("-------------------------");
				
				System.out.print("메뉴를 선택하세요 : ");
				int qsNo = KeyboardUtil.nextInt();
				
				if(qsNo == 1) {
					System.out.println("[문의 전체조회]");
					List<Question> questions = service.문의글전체조회();
					
					if(questions.isEmpty()) {
						System.out.println("!!! 문의내역이 존재하지 않습니다.");
					} else {
						System.out.println("-----------------------------------------------");
						System.out.println("문의번호\t문의제목\t작성자\t날짜\t답변여부\t조회수");
						for(Question question : questions) {
							System.out.print(question.getNo() + "\t");
							System.out.print(question.getTitle() + "\t");
							System.out.print(question.getUser().getId() + "\t");
							System.out.print(question.getRegisteredDate() + "\t");
							System.out.print(question.getStatus() + "\t");
							System.out.println(question.getViewCount());
						}
						System.out.println("-----------------------------------------------");
					}
					
				} else if(qsNo == 2) {
					System.out.println("[문의 등록]");
					
					System.out.print("아이디를 입력하세요 : ");
					String userId = KeyboardUtil.nextString();
					System.out.print("제목을 입력하세요 : ");
					String title = KeyboardUtil.nextString();
					System.out.print("내용을 입력하세요 : ");
					String content = KeyboardUtil.nextString();
					System.out.print("질문구분을 입력하세요(배송, 결재, 품질)");
					String type = KeyboardUtil.nextString();
					
		
					Question question = new Question();
					question.setTitle(title);
					question.setContent(content);
					question.setType(type);
					
					
					boolean isSuccess = service.문의등록(userId, question);
					
					if(isSuccess) {
						System.out.println("### 문의 등록이 완료되었습니다");
					} else {
						System.out.println("!!! 문의 등록에 실패하였습니다");
					}
					
				} else if(qsNo == 3) {
					System.out.println("[조회]");
					
					System.out.print("문의 번호를 입력하세요 : ");
					int questionNo = KeyboardUtil.nextInt();
					
					Question question = service.문의글조회(questionNo);
					
					if(question == null) {
						System.out.println("해당 질문 번호와 일치하는 정보가 없습니다.");
					} else {
						System.out.println("===== 문의 =====");
						System.out.println("문의 번호 : " + question.getNo());
						System.out.println("제목 : " + question.getTitle());
						System.out.println("작성자 : " + question.getUser().getId());
						System.out.println("문의내용 : " + question.getContent());
						System.out.println("조회수 : " + question.getViewCount());
						System.out.println("답변상태 : " + question.getStatus());
						System.out.println("유형 : " + question.getType());
						System.out.println("작성날짜 : " + question.getRegisteredDate());
						
						if(question.getAnswer() != null) {
							System.out.println("===== 답변 =====");
							System.out.println("답변번호 : " + question.getAnswer().getNo());
							System.out.println("답변내용 : " + question.getAnswer().getContent());
							System.out.println("작성날짜 : " + question.getAnswer().getRegisteredDate());
						}
					}
					
				} else if(qsNo == 4) {
					System.out.println("[문의 삭제]");
					
					System.out.print("문의 번호를 입력하세요 : ");
					int questionNo = KeyboardUtil.nextInt();
					
					System.out.print("사용자 아이디를 입력하세요 : ");
					String userId = KeyboardUtil.nextString();
					
					service.문의글삭제(questionNo, userId);
				}
				
			} else if(menuNo == 8) {
				System.out.println("[리뷰 게시판]");
				System.out.println("-------------------------");
				System.out.println("1.리뷰등록   2.리뷰조회");
				System.out.println("-------------------------");
				
				System.out.print("메뉴를 선택하세요 : ");
				int rvNo = KeyboardUtil.nextInt();
				
				if(rvNo == 1) {
					System.out.println("[리뷰등록]");
					
					System.out.print("책 번호를 입력하세요 : ");
					int bookNo = KeyboardUtil.nextInt();
					System.out.print("사용자 아이디를 입력하세요 : ");
					String userId = KeyboardUtil.nextString();
					System.out.print("리뷰를 입력하세요 : ");
					String content = KeyboardUtil.nextString();
					System.out.print("포인트를 입력하세요 (0~5) : ");
					int point = KeyboardUtil.nextInt();
					
					Review review = new Review();
					
					Book book = new Book();
					book.setNo(bookNo);
					
					User user = new User();
					user.setId(userId);

					review.setBook(book);
					review.setUser(user);
					review.setContent(content);
					review.setPoint(point);
					
					service.리뷰등록(review);
					
				} else if(rvNo == 2) {
					System.out.println("[리뷰 조회]");
					
					System.out.println("조회할 책 번호를 입력해주세요 : ");
					int bookNo = KeyboardUtil.nextInt();
					
					List<Review> reviews = service.리뷰조회(bookNo);
					
					if(reviews.isEmpty()) {
						System.out.println("!!! 리뷰가 존재하지 않습니다.");
					} else {
						System.out.println("-----------------------------------------------");
						System.out.println("리뷰번호\t책 번호\t작성자\t리뷰내용\t점수\t날짜");
						for(Review review : reviews) {
							System.out.print(review.getNo() + "\t");
							System.out.print(review.getBook().getNo() + "\t");
							System.out.print(review.getUser().getId() + "\t");
							System.out.print(review.getContent() + "\t");
							System.out.print(review.getPoint() + "\t");
							System.out.println(review.getRegisteredDate());
						}
						System.out.println("-----------------------------------------------");
					}
				}
				
			} else if (menuNo == 0) {
				KeyboardUtil.close();
				System.out.println("### 프로그램을 종료합니다.");
				break;
			}
			System.out.println();
			System.out.println();
			System.out.println();
		}
	}
}
