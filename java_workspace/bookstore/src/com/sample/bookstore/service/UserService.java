package com.sample.bookstore.service;

import com.sample.bookstore.vo.User;

public class UserService {

	private User[] db = new User[100];
	private int position = 0;
	private int userSequence = 10001;
	
	public UserService() {
		User u1 = new User(userSequence++, "홍길동", "010-1111-2345", 100, false);
		User u2 = new User(userSequence++, "김유신", "010-2345-7839", 100, false);
		User u3 = new User(userSequence++, "강감찬", "010-1856-8953", 100, false);
		User u4 = new User(userSequence++, "이순신", "010-4386-5256", 100, false);
		User u5 = new User(userSequence++, "류관순", "010-2678-3468", 100, false);
		
		db[position++] = u1;
		db[position++] = u2;
		db[position++] = u3;
		db[position++] = u4;
		db[position++] = u5;
	}
	
	// 회원등록 기능
	// 회원정보를 전달받아서 db배열에 저장한다.
	public void insertUser(User user) {
		user.no = userSequence;
		
		db[position] = user;
		position++;
		userSequence++;		
	}
	
	// 회원정보 조회 기능
	// 회원번호를 전달받아서 db배열에서 회원정보를 찾아 반환한다.
	public User findUserByNo(int no) {
		User result = null;
		
		for(int i=0; i<position; i++) {
			if(no == db[i].no) {
				result = db[i];
			}
		}
		
		return result;
	}
	
	// 회원정보 수정 기능
	// 회원정보를 전달받아서 회원번호에 해당하는 회원의 정보를 db에서 검색해서 회원정보를 수정한다.
	public void updateUser(User user) {
		User findUser = findUserByNo(user.no);
		
		if(findUser == null) {
			System.out.println("===== 입력하신 회원번호와 일치하는 회원을 찾을 수 없습니다. =====");
			return;
		}
		findUser.name = user.name;
		findUser.tel = user.tel;			
	}
	
	// 전체 회원정보 조회기능
	// 전체 회원정보를 반환한다.
	public User[] getAllUsers() {
		
		return db;
	}
	
	// 이름으로 회원번호 찾기
	public int findUserByName(String name) {
		int result = -1;
		
		for(int i=0; i<position; i++) {
			if(name.equals(db[i].name)) {
				result = db[i].no;
			}
		}
		
		return result;
	}
	
	// 회원번호로 회원이름 찾기
	public String findUserNameByNo(int userNo) {
		String result = null;
		
		for(int i=0; i<position; i++) {
			if(userNo == db[i].no) {
				result = db[i].name;
			}
		}
		
		return result;
	}
}