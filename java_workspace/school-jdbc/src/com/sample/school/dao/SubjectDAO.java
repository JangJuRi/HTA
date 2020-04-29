package com.sample.school.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sample.school.util.ConnectionUtil;
import com.sample.school.util.QueryUtil;
import com.sample.school.vo.Department;
import com.sample.school.vo.Subject;

public class SubjectDAO {

	public List<Subject> getAllSubjects() throws Exception {
		List<Subject> subjects = new ArrayList<Subject>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("subject.getAllSubjects"));
		ResultSet rs = pstmt.executeQuery();
		
		Subject subject = null;
		
		while(rs.next()) {
			subject = new Subject();
			
			subject.setNo(rs.getInt("subject_no"));
			subject.setName(rs.getString("subject_name"));
			
			Department department = new Department();
			department.setNo(rs.getInt("department_no"));
			
			subject.setDepartment(department);
			subject.setRegisteredDate(rs.getDate("subject_registered_date"));
			
			subjects.add(subject);
		}
				
		rs.close();
		pstmt.close();
		connection.close();
		
		return subjects;
	}
	
	public void addSubject(Subject subject) throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("subject.addSubject"));
		
		pstmt.setString(1, subject.getName());
		pstmt.setInt(2, subject.getDepartment().getNo());
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
}
