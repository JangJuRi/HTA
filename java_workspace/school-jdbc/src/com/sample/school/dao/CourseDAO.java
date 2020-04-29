package com.sample.school.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sample.school.util.ConnectionUtil;
import com.sample.school.util.QueryUtil;
import com.sample.school.vo.Course;
import com.sample.school.vo.Department;
import com.sample.school.vo.Professor;
import com.sample.school.vo.Subject;

public class CourseDAO {
	
	public List<Course> getAllCourses() throws Exception {
		List<Course> courses = new ArrayList<Course>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("course.getAllCourses"));
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			courses.add(resultSetToCourse(rs));
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return courses;
	}
	
	public Course resultSetToCourse(ResultSet rs) throws Exception {
		Course course = new Course();
		
		course.setNo(rs.getInt("course_no"));
		course.setName(rs.getString("course_name"));
		
		Department department = new Department();
		department.setNo(rs.getInt("department_no"));
		
		Subject subject = new Subject();
		subject.setNo(rs.getInt("subject_no"));
		
		Professor professor = new Professor();
		professor.setNo(rs.getInt("professor_no"));
		
		course.setDepartment(department);
		course.setSubject(subject);
		course.setProfessor(professor);
		course.setSize(rs.getInt("course_size"));
		course.setClosed(rs.getString("course_closed"));
		course.setRegisteredDate(rs.getDate("course_registered_date"));
		
		return course;
	}
}
