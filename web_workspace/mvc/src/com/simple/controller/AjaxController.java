package com.simple.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simple.dao.BookDao;
import com.simple.dao.ReviewDao;
import com.simple.dto.BookDetailDto;
import com.simple.service.BookService;
import com.simple.util.NumberUtil;
import com.simple.vo.Book;
import com.simple.vo.Review;

import kr.co.jhta.mvc.annotation.Controller;
import kr.co.jhta.mvc.annotation.RequestMapping;
import kr.co.jhta.mvc.servlet.ModelAndView;
import kr.co.jhta.mvc.view.JSONView;

@Controller
public class AjaxController {

	private JSONView jsonview = new JSONView();
	private BookService bookService = new BookService();
	
	@RequestMapping("/json/books.hta")
	public ModelAndView books(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		List<Book> books = bookService.getAllBooks();
		mav.addAttribute("books", books);	// ModelAndView에 응답으로 제공할 데이터 넘기기
		mav.setView(jsonview);				// 데이터를 JSON 응답으로 변환하는 View객체 담기
		
		return mav;
	}
	
	@RequestMapping("/json/book.hta")
	public ModelAndView book(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		int bookNo = NumberUtil.stringToInt(req.getParameter("bookno"));
		BookDetailDto dto = bookService.getBookDetailInfo(bookNo);
		
		mav.addAttribute("dto", dto);
		mav.setView(jsonview);
		
		return mav;
	}
}
