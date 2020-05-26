package com.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookstore.dto.UserDetailDto;
import com.bookstore.util.ConnectionUtil;
import com.bookstore.util.QueryUtil;
import com.bookstore.vo.Order;

public class OrderDao {
	
	public void insertOrder(Order order) throws SQLException {
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("order.insertOrder"));
		pstmt.setString(1, order.getUserId());
		pstmt.setInt(2, order.getBookNo());
		pstmt.setInt(3, order.getPrice());
		pstmt.setInt(4, order.getAmount());
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
	public List<UserDetailDto> getAllOrders() throws SQLException {
		
		List<UserDetailDto> userDetailDtos = new ArrayList<UserDetailDto>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("order.getAllOrders"));
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			UserDetailDto orderDto = new UserDetailDto();
			
			orderDto.setNo(rs.getInt("order_no"));
			orderDto.setName(rs.getString("user_name"));
			orderDto.setTitle(rs.getString("book_title"));
			orderDto.setPrice(rs.getInt("book_discount_price"));
			orderDto.setAmount(rs.getInt("order_amount"));
			orderDto.setOrderPrice(rs.getInt("order_price"));
			orderDto.setRegisteredDate(rs.getDate("order_registered_date"));
			
			userDetailDtos.add(orderDto);
		}
		return userDetailDtos;
	}
	
	public List<UserDetailDto> getSelectOrders(String genre) throws SQLException {
		List<UserDetailDto> userDetailDtos = new ArrayList<UserDetailDto>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("order.getSelectOrders"));
		pstmt.setString(1, genre);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			UserDetailDto orderDto = new UserDetailDto();
			
			orderDto.setNo(rs.getInt("order_no"));
			orderDto.setName(rs.getString("user_name"));
			orderDto.setTitle(rs.getString("book_title"));
			orderDto.setPrice(rs.getInt("book_discount_price"));
			orderDto.setAmount(rs.getInt("order_amount"));
			orderDto.setOrderPrice(rs.getInt("order_price"));
			orderDto.setRegisteredDate(rs.getDate("order_registered_date"));
			
			userDetailDtos.add(orderDto);
		}
		return userDetailDtos;
	}
}
