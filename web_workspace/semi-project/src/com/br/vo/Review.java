package com.br.vo;

import java.util.Date;

/**
 * @author JHTA
 *
 */
public class Review {
	/*
	 * review_no number(6,0) primary key, product_no number(6,0) REFERENCES
	 * br_products(product_no), order_no number(6,0), user_id varchar2(30)
	 * REFERENCES br_users(user_id), point number not null, title varchar2(200) not
	 * null, content varchar2(2000) not null, reg_date date default sysdate, deleted
	 * char(1) default 'N', helped number default 0
	 */

	private int no;
	private int ProductNo;
	private int orderNo;
	private String userId;
	private int point;
	private String title;
	private String content;
	private Date regDate;
	private boolean deleted;
	private int helped;
	private int liked;
	private String picture;
	
	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public int getLiked() {
		return liked;
	}

	public void setLiked(int liked) {
		this.liked = liked;
	}

	public Review() {
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getProductNo() {
		return ProductNo;
	}

	public void setProductNo(int productNo) {
		ProductNo = productNo;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public int getHelped() {
		return helped;
	}

	public void setHelped(int helped) {
		this.helped = helped;
	}

	@Override
	public String toString() {
		return "Review [no=" + no + ", ProductNo=" + ProductNo + ", orderNo=" + orderNo + ", userId=" + userId
				+ ", point=" + point + ", title=" + title + ", content=" + content + ", regDate=" + regDate
				+ ", deleted=" + deleted + ", helped=" + helped + ", liked=" + liked + ", picture=" + picture + "]";
	}

}
