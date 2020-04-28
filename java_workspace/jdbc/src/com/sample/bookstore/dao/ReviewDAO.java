package com.sample.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sample.bookstore.util.ConnectionUtil;
import com.sample.bookstore.util.QueryUtil;
import com.sample.bookstore.vo.Book;
import com.sample.bookstore.vo.Review;
import com.sample.bookstore.vo.User;

public class ReviewDAO {
	
	public void addReview(Review review) throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("review.addReview"));
		pstmt.setString(1, review.getContent());
		pstmt.setInt(2, review.getPoint());
		pstmt.setInt(3, review.getBook().getNo());
		pstmt.setString(4, review.getUser().getId());
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
	public List<Review> getAllReviewsByBookNo(int bookNo) throws Exception {
		List<Review> reviews = new ArrayList<Review>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("review.getAllReviewsByBookNo"));
		pstmt.setInt(1, bookNo);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			Review review = new Review();
			review.setNo(rs.getInt("review_no"));
			review.setContent(rs.getString("review_content"));
			review.setPoint(rs.getInt("review_point"));
			review.setRegisteredDate(rs.getDate("review_registered_date"));
			
			Book book = new Book();
			book.setNo(rs.getInt("book_no"));
			
			User user = new User();
			user.setId(rs.getString("user_id"));
			
			review.setBook(book);
			review.setUser(user);
			
			reviews.add(review);
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return reviews;
	}
}
