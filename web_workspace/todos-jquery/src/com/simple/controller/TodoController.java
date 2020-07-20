package com.simple.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.simple.service.TodoService;
import com.simple.service.UserService;
import com.simple.util.NumberUtil;
import com.simple.vo.Todo;
import com.simple.vo.User;

import kr.co.jhta.mvc.annotation.Controller;
import kr.co.jhta.mvc.annotation.RequestMapping;
import kr.co.jhta.mvc.servlet.ModelAndView;
import kr.co.jhta.mvc.view.JSONView;

@Controller
public class TodoController {

	private TodoService todoService = new TodoService();
	private UserService userService = new UserService();
	private JSONView jsonView = new JSONView();
	
	// 요청방식 : POST
	// 요청파라미터 : id, name, password, email
	@RequestMapping("/register.hta")
	public ModelAndView registerUser(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		ModelAndView mav = new ModelAndView();
		mav.setView(jsonView);
		mav.addAttribute("data", dataMap);
		
		try {
			String id = req.getParameter("id");
			String name = req.getParameter("name");
			String password = req.getParameter("password");
			String email = req.getParameter("email");
			
			User user = new User();
			user.setId(id);
			user.setName(name);
			user.setPassword(password);
			user.setEmail(email);
			
			userService.addNewUser(user);
			
			dataMap.put("status", "success");
			dataMap.put("username", name);
		} catch (Exception e) {
			dataMap.put("status", "fail");
			dataMap.put("message", "동일한 아이디가 이미 사용중입니다.");
			e.printStackTrace();
		}
		
		return mav;
	}
	
	// 요청파라미터: id, password
	@RequestMapping("/login.hta")
	public ModelAndView loginUser(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		ModelAndView mav = new ModelAndView();
		mav.setView(jsonView);
		mav.addAttribute("data", dataMap);
		
		try {
			String id = req.getParameter("id");
			String password = req.getParameter("password");
			
			User user = userService.getLoginUser(id, password);
			
			HttpSession session = req.getSession();
			session.setAttribute("loginUser", user);
			
			dataMap.put("status", "success");
			dataMap.put("username", user.getName());
		} catch (Exception e) {
			dataMap.put("status", "fail");
			dataMap.put("message", "아이디 혹은 비밀번호가 올바르지 않습니다.");
			e.printStackTrace();
		}
		
		return mav;
	}
	
	// 요청파라미터: 없음
	@RequestMapping("/logout.hta")
	public ModelAndView logoutUser(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		ModelAndView mav = new ModelAndView();
		mav.setView(jsonView);
		mav.addAttribute("data", dataMap);
		
		try {
			HttpSession session = req.getSession(false);
			if(session != null) {
				session.invalidate();
			}
			
			dataMap.put("status", "success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mav;
	}
	
	// 요청파라미터: 없음
	@RequestMapping("/mytodos.hta")
	public ModelAndView myTodos(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		ModelAndView mav = new ModelAndView();
		mav.setView(jsonView);
		mav.addAttribute("data", dataMap);
		
		try {
			HttpSession session = req.getSession(false);
			User user = (User)session.getAttribute("loginUser");
			List<Todo> todos = todoService.getMyTodos(user.getId());
			
			dataMap.put("status", "success");
			dataMap.put("todos", todos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mav;
	}
	
	// 요청파라미터: todoNo
	@RequestMapping("/todo.hta")
	public ModelAndView todoDetail(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		ModelAndView mav = new ModelAndView();
		mav.setView(jsonView);
		mav.addAttribute("data", dataMap);
		
		int todoNo = NumberUtil.stringToInt(req.getParameter("todoNo"));
		Todo todo = todoService.getTodoDetail(todoNo);
		
		try {
			dataMap.put("status", "success");
			dataMap.put("todos", todo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mav;
	}
	
	// 요청파라미터: title, content, day
	@RequestMapping("/addtodo.hta")
	public ModelAndView addTodo(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		ModelAndView mav = new ModelAndView();
		mav.setView(jsonView);
		mav.addAttribute("data", dataMap);
		
		try {
			HttpSession session = req.getSession(false);
			User user = (User)session.getAttribute("loginUser");
			
			DateFormat df = new SimpleDateFormat("yyyyMMdd");
			
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			Date day = df.parse(req.getParameter("day"));
			
			Todo todo = new Todo();
			todo.setTitle(title);
			todo.setContent(content);
			todo.setDay(day);
			todo.setUserId(user.getId());
			
			todoService.addNewTodo(todo);
			
			dataMap.put("status", "success");
			dataMap.put("todos", todo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mav;
	}
	
	// 요청파라미터: no, title, content, day, status
	@RequestMapping("/modifytodo.hta")
	public ModelAndView modifyTodo(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		ModelAndView mav = new ModelAndView();
		mav.setView(jsonView);
		mav.addAttribute("data", dataMap);
		
		try {
			DateFormat df = new SimpleDateFormat("yyyyMMdd");
			
			int no = NumberUtil.stringToInt(req.getParameter("no"));
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			Date day = df.parse(req.getParameter("day"));
			String status = req.getParameter("status");
			
			Todo todo = new Todo();
			todo.setNo(no);
			todo.setTitle(title);
			todo.setContent(content);
			todo.setDay(day);
			todo.setStatus(status);
			
			todoService.updateTodo(todo);
			
			dataMap.put("status", "success");
			dataMap.put("todos", todo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mav;
	}
}
