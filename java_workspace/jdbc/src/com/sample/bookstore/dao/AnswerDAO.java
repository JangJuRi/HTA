package com.sample.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sample.bookstore.util.ConnectionUtil;
import com.sample.bookstore.util.QueryUtil;
import com.sample.bookstore.vo.Answer;

public class AnswerDAO {

	public void addAnswer(Answer answer) throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("answer.addAnswer"));
		
		pstmt.setString(1, answer.getContent());
		pstmt.setInt(2, answer.getQuestion());
		pstmt.executeUpdate();
		
		pstmt = connection.prepareStatement(QueryUtil.getSQL("question.updateStatus"));
		pstmt.setString(1, "Y");
		pstmt.setInt(2, answer.getQuestion());
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
	public Answer getAnswer(int questionNo) throws Exception {
		Answer answer = null;
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("answer.getAnswer"));
		pstmt.setInt(1, questionNo);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			answer = new Answer();
			answer.setNo(rs.getInt("answer_no"));
			answer.setContent(rs.getString("answer_content"));
			answer.setRegisteredDate(rs.getDate("answer_registered_date"));
			answer.setQuestion(rs.getInt("question_no"));
			
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return answer;
	}
}
