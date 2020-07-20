package com.simple.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.simple.service.UserService;
import com.simple.vo.User;

import kr.co.jhta.mvc.annotation.Controller;
import kr.co.jhta.mvc.annotation.RequestMapping;
import kr.co.jhta.mvc.servlet.ModelAndView;
import kr.co.jhta.mvc.view.JSONView;

@Controller
public class UserController {

	private JSONView jsonView = new JSONView();
	private UserService userService = new UserService();
	
	@RequestMapping("/register.hta")
	public ModelAndView registerUser(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String password = req.getParameter("pwd");
		String email = req.getParameter("email");
		
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setPassword(password);
		user.setEmail(email);
		
		boolean isSuccess = userService.addNewUser(user);
		
		ModelAndView mav = new ModelAndView();
		mav.addAttribute("result", isSuccess);
		mav.setView(jsonView);	// 클라이언트에 jsonText 응답을 제공
								// {"result":true} 혹은 {"result":false} 텍스트가 응답으로 제공된다.
		
		return mav;
	}
	
	@RequestMapping("/login.hta")
	public ModelAndView login(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String id = req.getParameter("userid");
		String password = req.getParameter("userpwd");
		
		User user = userService.loginCheck(id, password);
		
		ModelAndView mav = new ModelAndView();
		if(user == null) {
			mav.addAttribute("result", false);
		} else {
			mav.addAttribute("result", true);
			
			HttpSession session = req.getSession();
			session.setAttribute("loginUser", user);
		}
		
		mav.setView(jsonView);
		
		return mav;
	}
	
	@RequestMapping("/logout.hta")
	public ModelAndView logout(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession(false);
		if(session != null) {
			session.invalidate();
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/home.hta");
		
		return mav;
	}
}
