package com.simple.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.simple.dto.ReplyDto;
import com.simple.util.ConnectionUtil;
import com.simple.util.QueryUtil;
import com.simple.vo.Reply;

public class ReplyDao {

	public List<ReplyDto> getAllReplysByBoardNo(int boardNo) throws SQLException {
		List<ReplyDto> replies = new ArrayList<ReplyDto>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("reply.getAllReplysByBoardNo"));
		pstmt.setInt(1, boardNo);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			ReplyDto replyDto = new ReplyDto();
			replyDto.setNo(rs.getInt("reply_no"));
			replyDto.setWriter(rs.getString("reply_writer"));
			replyDto.setWriterName(rs.getString("user_name"));
			replyDto.setContent(rs.getString("reply_content"));
			replyDto.setDelYn(rs.getString("reply_del_yn"));
			replyDto.setCreateDate(rs.getDate("reply_create_date"));
			replyDto.setBoardNo(rs.getInt("board_no"));
			
			replies.add(replyDto);
		}
		rs.close();
		pstmt.close();
		connection.close();
		
		return replies;
	}
	
	public List<Reply> getAllReplysByUserId(String userId) throws SQLException {
		List<Reply> replies = new ArrayList<Reply>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("reply.getAllReplysByUserId"));
		pstmt.setString(1, userId);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			Reply reply = new Reply();
			reply.setNo(rs.getInt("reply_no"));
			reply.setWriter(rs.getString("reply_writer"));
			reply.setContent(rs.getString("reply_content"));
			reply.setDelYn(rs.getString("reply_del_yn"));
			reply.setCreateDate(rs.getDate("reply_create_date"));
			reply.setBoardNo(rs.getInt("board_no"));
			
			replies.add(reply);
		}
		rs.close();
		pstmt.close();
		connection.close();
		
		return replies;
	}
	
	public void insertReply(Reply reply) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("reply.insertReply"));
		pstmt.setString(1, reply.getWriter());
		pstmt.setString(2, reply.getContent());
		pstmt.setInt(3, reply.getBoardNo());
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
}
