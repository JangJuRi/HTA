package com.sample.bookstore.service;

import com.sample.bookstore.vo.Rental;

public class RentalService {
	
	UserService userService = new UserService();

	private Rental[] db = new Rental[100];
	private int position = 0;
	private int rentalSequence = 50001;
	
	// 대여정보 저장 기능
	// 전달받은 대여정보를 db에 저장한다.
	public void insertRental(Rental rental) {
		rental.no = rentalSequence;
		db[position] = rental;
		position++;
		rentalSequence++;
	}
	
	// 대여정보 조회기능
	// 대여번호에 해당하는 대여정보를 반환한다.
	public Rental findRentalByNo(int rentalNo) {
		Rental result = null;
		
		for(int i=0; i<position; i++) {
			if(rentalNo == db[i].no) {
				result = db[i];
			}
		}
		
		return result;
	}
	
	// 반납처리 기능
	// 사용자번호를 전달받아서 그 사용자의 모든 대여도서를 반납처리하는 기능
	public void returnAllRentalByUserNo(int userNo) {
			for(int i=0; i<position; i++)  {
				if(userNo == db[i].userNo) {
					db[i].isRent = false;
				}
			}
	}
		
	// 대여현황조회기능
	// 모든 대여정보를 반환한다.
	public Rental[] getAllRentals() {
		return db;
	}
	
	// 고객의 모든 대여현황 출력 기능
	public Rental[] getUserRentalStatus(int userNo) {
		Rental[] result = new Rental[100];
		int count = 0;
		
		for(int i=0; i<position; i++) {
			if(userNo == db[i].userNo) {
				result[count] = db[i];
				count++;
			}
		}
		
		return result;
	}
	
	// 현재 대여중인 책을 배열에 저장하기
	public Rental[] getIsRentBooks() {
		Rental[] result = new Rental[100];
		int count = 0;
		
		for(int i=0; i<position; i++) {
			if(db[i].isRent == true) {
				result[count] = db[i];
				count++;
			}
		}
		
		return result;
	}
	
	// 책을 대여중인 고객을 배열에 저장하기
	public Rental[] getIsRentUsers(int bookNo) {
		Rental[] result = new Rental[100];
		int count = 0;
		
		for(int i=0; i<position; i++) {
			if(db[i].bookNo == bookNo) {
				result[count] = db[i];
				count++;
			}
		}
		
		return result;
	}
}