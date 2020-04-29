package com.sample.school.app;

import com.sample.school.service.SchoolService;
import com.sample.school.util.KeyboardUtil;

public class SchoolStudentApp {

	public static void main(String[] args) throws Exception {
		
		SchoolService service = new SchoolService();
		
		while(true) {
			System.out.println("-----------------------------------------------");
			System.out.println("1.과정목록조회   2.수강신청   3.수강취소   4.수강신청 내역조회  0.종료 ");
			System.out.println("-----------------------------------------------");
			
			int menuNo = KeyboardUtil.nextInt();
			
			if(menuNo == 1) {
				System.out.println("[과정목록조회]");
				
			} else if(menuNo == 2) {
				System.out.println("[수강신청]");
				
			} else if(menuNo == 3) {
				System.out.println("[수강취소]");
				
			} else if(menuNo == 4) {
				System.out.println("[수강신청 내역조회]");
				
			} else if(menuNo == 0) {
				System.out.println("[학생 프로그램을 종료합니다.]");
				break;
			}
		}
	}
}
