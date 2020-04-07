package com.sample.mall.vo;

import java.util.Arrays;

public class User {

	public String id;
	public String name;
	public int point;
	public Item[] items = new Item[20];
	private int position = 0;
	private int sequence = 200;

	public User() {}

	public User(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public User(String id, String name, int point) {
		this.id = id;
		this.name = name;
		this.point = point;
	}

	/**
	 * 사용자의 장바구니에 Item을 추가한다.
	 * @param item 장바구니 Item객체
	 */
	public void addItem(Item item) {
		item.no = sequence++;
		items[position++] = item;
	}

	/**
	 * 사용자의 장바구니에 저장된 Item배열을 반환한다.
	 * @return Item 배열
	 */
	public Item[] getItems() {
		return Arrays.copyOfRange(items, 0, position);
	}
	
	/**
	 * 장바구니에 저장된 item을 선택해서 삭제한다.
	 * @param itemNo
	 */
	public void removeItem(int itemNo) {
		
		int itemPosition = -1;
		
		for(int i=0; i<position; i++) {
			if(itemNo == items[i].no) {
				itemPosition = i;
			}
		}
		
		
		if (itemPosition == 0) {															// 첫번째를 삭제
			Item[] copyItems = Arrays.copyOfRange(items, 1, position);
			
			Arrays.fill(items, null);
			System.arraycopy(copyItems, 0, items, 0, position);								// items에 copyItems를 복사
			
		} else if (itemPosition == position-1) {											// 마지막을 삭제
			Item[] copyItems = Arrays.copyOfRange(items, 0, position-1);

			Arrays.fill(items, null);
			System.arraycopy(copyItems, 0, items, 0, position);								// items에 copyItems를 복사
			
		} else {																			// 중간을 삭제
			Item[] frontCopy = Arrays.copyOfRange(items, 0, itemPosition);
			Item[] backCopy = Arrays.copyOfRange(items, itemPosition+1, position);
			
			Arrays.fill(items, null);
			System.arraycopy(frontCopy, 0, items, 0, frontCopy.length);						// items에 frontCopy를 복사, 배열 길이는 frontCopy의 길이.
			System.arraycopy(backCopy, 0, items, frontCopy.length, backCopy.length);		// items에 backCopy를 복사, frontCopy길이부터 배열 시작
				
		}
		
		position--;
	}

	/**
	 * 사용자의 장바구니를 비운다.
	 */
	public void clearItems() {
		Arrays.fill(items, null);
		position = 0;
	}
}