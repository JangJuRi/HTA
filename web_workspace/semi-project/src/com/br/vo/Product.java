package com.br.vo;

import java.util.ArrayList;
import java.util.Date;

public class Product {
	/*
	 * product_no number(6,0) primary key, name varchar2(40) not null, price number
	 * not null, point number not null, category varchar2(10) not null, reg_date
	 * date default sysdate, reviews number default 0
	 */

	private int no;
	private String name;
	private int price;
	private int point;
	private int amount;
	private int discountPrice;
	private String category;
	private Date regDate;
	private int reviews;
	private String explain;
	private String imagePath;
	private ArrayList<String> tags;

	public Product() {
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(int discountPrice) {
		this.discountPrice = discountPrice;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getReviews() {
		return reviews;
	}

	public void setReviews(int reviews) {
		this.reviews = reviews;
	}

	public String getExplain() {
		return explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public ArrayList<String> getTags() {
		return tags;
	}

	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "Product [no=" + no + ", name=" + name + ", price=" + price + ", point=" + point + ", amount=" + amount
				+ ", discountPrice=" + discountPrice + ", category=" + category + ", regDate=" + regDate + ", reviews="
				+ reviews + ", explain=" + explain + ", imagePath=" + imagePath + ", tags=" + tags + "]";
	}

}
