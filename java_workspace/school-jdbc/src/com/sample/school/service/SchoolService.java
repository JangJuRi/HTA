package com.sample.school.service;

import java.util.List;

import com.sample.school.dao.CourseDAO;
import com.sample.school.dao.SubjectDAO;
import com.sample.school.vo.Course;
import com.sample.school.vo.Enrolment;
import com.sample.school.vo.Subject;

public class SchoolService {

	SubjectDAO subjectDAO = new SubjectDAO();
	CourseDAO courseDAO = new CourseDAO();
	
	// 교수 기능
	public List<Subject> 과목조회() throws Exception {
		return subjectDAO.getAllSubjects();
	}
	
	public void 과목등록(Subject subject) throws Exception {
		subjectDAO.addSubject(subject);
	}
	
	public List<Course> 과정목록조회() throws Exception {
		return courseDAO.getAllCourses();
	}
	
	public Course 과정상세조회(int courseNo) throws Exception {
		return null;
	}
	
	public void 과정등록(Course course) throws Exception {
		
	}
	
	
	// 학생 기능
	public void 수강신청(int courseNo, int studentNo) {
		
	}
	
	public void 수강취소(int courseNo, int studentNo) {
		
	}
	
	public List<Enrolment> 수강신청내역조회(int studentNo) {
		return null;
	}
}
