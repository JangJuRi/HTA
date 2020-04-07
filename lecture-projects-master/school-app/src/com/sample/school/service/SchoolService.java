package com.sample.school.service;

import com.sample.school.vo.Course;
import com.sample.school.vo.Professor;
import com.sample.school.vo.Student;
import com.sample.school.vo.Subject;

/**
 * 수강신청과 관련된 서비스를 제공하는 구현객체가 반드시 구현해야 하는 기능을 정의한 인터페이스다.<br />
 * <h3>교수관련 기능</h3>
 * <ul>
 * 	<li>교수등록</li>
 * 	<li>과목등록</li>
 * 	<li>과목조회</li>
 * 	<li>개설과정등록</li>
 * 	<li>개설과정 조회</li>
 * 	<li>과정 신청자 조회</li>
 * 	<li>성적 부여</li>
 * </ul>
 * 
 * <h3>학생관련 기능</h3>
 * 	<li>학생등록</li>
 * 	<li>과목조회</li>
 * 	<li>개설과정 조회</li>
 *  <li>수강신청</li>
 * 	<li>수강신청 현황 조회</li>
 * 	<li>수강신청 취소</li>
 * 	<li>성적 조회</li>
 * </ul>
 
 * @author JHTA
 *
 */
public interface SchoolService {

	void addNewProfessor(Professor professor);					// 교수등록
	void addNewSubject(Subject subject);						// 과목 등록
	void selectProfessorSubject(int professorNo);				// 과목 조회
	void addNewCourse(Course course);							// 개설과정등록
	void selectProfessorCourse(int professorNo);				// 개설과정조회
	void selectApplicant(int professorNo, int courseNo);		// 과정 신청자 조회
	void scoreSet(int professorNo, int registrationNo, int score);	// 성적 부여
	
	void addNewStudent(Student student);						// 학생 등록
	void selectStudentSubject(int studentNo);					// 과목 조회
	void selectStudentCourse(int studentNo);					// 개설과정 조회
	void addRegistration(int studentNo, int courseNo);			// 수강신청
	void selectRegistration(int studentNo);						// 수강신청 현황 조회
	void cancelRegistration(int studentNo, int registrationNo);	// 수강신청 취소
	void scorePrint(int studentNo);								// 성적 조회
}
