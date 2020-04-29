package com.sample.school.app;

import java.util.List;

import com.sample.school.service.SchoolService;
import com.sample.school.util.KeyboardUtil;
import com.sample.school.vo.Course;
import com.sample.school.vo.Department;
import com.sample.school.vo.Subject;

public class SchoolProfessorApp {

	public static void main(String[] args) throws Exception {
		
		SchoolService service = new SchoolService();
		
		while(true) {
			System.out.println("-----------------------------------------------------");
			System.out.println("1.과목조회   2.과목등록   3.과정목록조회   4.과정상세조회   5.과정등록   0.종료 ");
			System.out.println("-----------------------------------------------------");
			
			System.out.print("메뉴를 선택하세요 : ");
			int menuNo = KeyboardUtil.nextInt();
			
			if(menuNo == 1) {
				System.out.println("[과목조회]");
				
				List<Subject> subjects = service.과목조회();
				
				System.out.println("==========================");
				System.out.println("과목번호\t과목명\t학과번호\t등록일");
				for(Subject subject : subjects) {
					System.out.print(subject.getNo() + "\t");
					System.out.print(subject.getName() + "\t");
					System.out.print(subject.getDepartment().getNo() + "\t");
					System.out.println(subject.getRegisteredDate());
				}
				System.out.println("==========================");
				
			} else if(menuNo == 2) {
				System.out.println("[과목등록]");
				
				System.out.print("과목명을 입력해주세요 : ");
				String subjectName = KeyboardUtil.nextString();
				System.out.print("학과번호를 입력해주세요 : ");
				int deptNo = KeyboardUtil.nextInt();
				
				Subject subject = new Subject();
				Department department = new Department();
				
				department.setNo(deptNo);
				
				subject.setName(subjectName);
				subject.setDepartment(department);
				
				service.과목등록(subject);
				
			} else if(menuNo == 3) {
				System.out.println("[과정목록조회]");
				
				List<Course> courses = service.과정목록조회();
				System.out.println("==========================");
				System.out.println("과정번호\t과정명\t수강인원\t마감여부\t등록일");
				for(Course course : courses) {
					System.out.print(course.getNo() + "\t");
					System.out.print(course.getName() + "\t");
					System.out.print(course.getSize() + "\t");
					System.out.print(course.getClosed() + "\t");
					System.out.println(course.getRegisteredDate());
				}
				System.out.println("==========================");
				
				
			} else if(menuNo == 4) {
				System.out.println("[과정상세조회]");
				
			} else if(menuNo == 5) {
				System.out.println("[과정등록]");
				
			} else if(menuNo == 0) {
				System.out.println("[교수 프로그램을 종료합니다.]");
				break;
			}
		}
	}
}
