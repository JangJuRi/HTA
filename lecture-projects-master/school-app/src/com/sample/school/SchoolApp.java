package com.sample.school;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.sample.school.service.SchoolService;
import com.sample.school.service.SchoolServiceImple;
import com.sample.school.vo.Course;
import com.sample.school.vo.Professor;
import com.sample.school.vo.Student;
import com.sample.school.vo.Subject;

public class SchoolApp {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	SchoolServiceImple service = new SchoolServiceImple();
	
	private static int nextInt() {
		try {
			String text = in.readLine();
			return Integer.parseInt(text);
		} catch (IOException e) {
			return 0;
		}
	}
	
	private static String next() {
		try {
			return in.readLine();
		} catch (IOException e) {
			return "";
		}
	}
	
	public static void main(String[] args) {
		SchoolServiceImple service = new SchoolServiceImple();
		
		while (true) {
			System.out.println("============ 메뉴를 선택해주세요 ============");
			System.out.println("1. 교수 관련 메뉴      2. 학생 관련 메뉴      3. 종료");
			System.out.println("========================================");
			System.out.print(">>> ");
			int menuNo = nextInt();
			
			if(menuNo == 1) {
				System.out.println("================================= 교수 메뉴를 선택해주세요 =================================");
				System.out.println("1. 교수 등록   2. 과목 등록   3. 과목 조회   4. 개설과정등록   5.개설과정조회   6. 과정 신청자 조회   7.성적 부여");
				System.out.println("======================================================================================");
				System.out.print(">>> ");
				int PfMenuNo = nextInt();
				
				if(PfMenuNo == 1) {
					Professor professor = new Professor();
					
					System.out.println("----- 교수 등록 -----");
					System.out.print("이름을 입력해주세요 : ");
					professor.setName(next());
					System.out.print("이메일을 입력해주세요 : ");
					professor.setEmail(next());
					System.out.print("학과를 입력해주세요 : ");
					professor.setDept(next());
					System.out.print("직위를 입력해주세요 : ");
					professor.setPosition(next());
					System.out.print("급여를 입력해주세요 : ");
					professor.setSalary(nextInt());
					
					service.addNewProfessor(professor);
					
				} else if(PfMenuNo == 2) {
					Subject subject = new Subject();
					
					System.out.println("----- 과목 등록 -----");
					System.out.print("과목명을 입력해주세요 : ");
					subject.setTitle(next());
					System.out.print("학과를 입력해주세요 : ");
					subject.setDept(next());
					System.out.print("학점을 입력해주세요 : ");
					subject.setCredit(nextInt());
					
					service.addNewSubject(subject);
					
				} else if(PfMenuNo == 3) {
					System.out.println("----- 과목 조회 -----");
					System.out.print("교수번호를 입력해주세요 : ");
					
					service.selectProfessorSubject(nextInt());
					
				} else if(PfMenuNo == 4) {
					Course course = new Course();
					
					System.out.println("----- 개설과정 등록 -----");
					System.out.print("과정명을 입력해주세요 : ");
					course.setName(next());
					System.out.print("과목번호를 입력해주세요 : ");
					course.setSubjectNo(nextInt());
					System.out.print("담당교수 번호를 입력해주세요 : ");
					course.setProfessorNo(nextInt());
					System.out.print("정원을 입력해주세요 : ");
					course.setQuota(nextInt());
					
					service.addNewCourse(course);
					
				} else if(PfMenuNo == 5) {
					System.out.println("----- 개설과정 조회 -----");
					System.out.print("교수번호를 입력해주세요 : ");
					
					service.selectProfessorCourse(nextInt());
					
				} else if(PfMenuNo == 6) {
					System.out.println("----- 과정 신청자 조회 -----");
					System.out.print("교수번호를 입력해주세요 : ");
					int professorNo = nextInt();
					System.out.print("개설과정 번호를 입력해주세요 : ");
					int courseNo = nextInt();
					
					service.selectApplicant(professorNo, courseNo);
					
				} else if(PfMenuNo == 7) {
					System.out.println("----- 성적 부여 -----");
					System.out.print("교수번호를 입력해주세요 : ");
					int professorNo = nextInt();
					System.out.print("수강신청번호를 입력해주세요 : ");
					int registrationNo = nextInt();
					System.out.print("성적을 입력해주세요 : ");
					int score = nextInt();
					
					service.scoreSet(professorNo, registrationNo, score);
					
				}
				
			} else if(menuNo == 2) {
				System.out.println("================================= 학생 메뉴를 선택해주세요 =================================");
				System.out.println("1. 학생 등록   2. 과목 조회   3. 개설과정조회   4. 수강신청   5.수강신청 현황 조회   6. 수강신청 취소   7.성적 조회");
				System.out.println("======================================================================================");
				System.out.print(">>> ");
				int StMenuNo = nextInt();
				
				if(StMenuNo == 1) {
					Student student = new Student();
					
					System.out.println("----- 학생 등록 -----");
					System.out.print("이름을 입력해주세요 : ");
					student.setName(next());
					System.out.print("이메일을 입력해주세요 : ");
					student.setEmail(next());
					System.out.print("학과를 입력해주세요 : ");
					student.setDept(next());
					System.out.print("학년을 입력해주세요 : ");
					student.setGrade(nextInt());
					
					service.addNewStudent(student);
					
				} else if(StMenuNo == 2) {
					System.out.println("----- 과목 조회 -----");
					System.out.print("학생 번호를 입력해주세요 : ");
					
					service.selectStudentSubject(nextInt());
					
				} else if(StMenuNo == 3) {
					System.out.println("----- 개설 과정 조회 -----");
					System.out.print("학생 번호를 입력해주세요 : ");
					
					service.selectStudentCourse(nextInt());
					
				} else if(StMenuNo == 4) {
					System.out.println("----- 수강 신청 -----");
					
					System.out.print("학생 번호를 입력해주세요 : ");
					int studentNo = nextInt();
					System.out.print("개설과정 번호를 입력해주세요 : ");
					int courseNo = nextInt();
					
					service.addRegistration(studentNo, courseNo);
					
				} else if(StMenuNo == 5) {
					System.out.println("----- 수강 신청 현황 조회-----");
					System.out.print("학생 번호를 입력해주세요 : ");
					
					service.selectRegistration(nextInt());
					
				} else if(StMenuNo == 6) {
					System.out.println("----- 수강 신청 취소 -----");
					
					System.out.print("학생 번호를 입력해주세요 : ");
					int studentNo = nextInt();
					System.out.print("수강신청 번호를 입력해주세요 : ");
					int registrationNo = nextInt();
					
					service.cancelRegistration(studentNo, registrationNo);
					
				} else if(StMenuNo == 7) {
					System.out.println("----- 성적 조회 -----");
					System.out.print("학생 번호를 입력해주세요 : ");
					service.scorePrint(nextInt());
					
				}
			} else if(menuNo == 3) {
				System.out.println("프로그램 종료");
				break;
			}
		}
		
	}
	
}
