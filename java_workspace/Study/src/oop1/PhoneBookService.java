package oop1;

public class PhoneBookService {

	private PhoneBook[] db = new PhoneBook[100];
	private int position = 0;
	private int sequence = 30000;
	
	/* 연락처 추가 메소드 */
	public void insertPhoneNumber(PhoneBook phoneBook) {
		for(int i=0; i<position; i++) {
			if(phoneBook.getName().equals(db[i].getName())) {
				System.out.println("동일한 이름이 존재합니다.");
				return;
			}
			if(phoneBook.getPhoneNum().equals(db[i].getPhoneNum())) {
				System.out.println("동일한 번호가 존재합니다.");
				return;
			}
		}
		
		db[position] = phoneBook;
		position++;
	}
	
	
	/* 연락처 검색 메소드 */
	public void searchPhoneNumber(String name) {
		
		PhoneBook phoneBook = getPhoneByName(name);
		
		if(phoneBook == null) {
			System.out.println("검색 결과가 없습니다.");
			return;
		}
		
		infoPrint(phoneBook);
	}
	
	/* 이름으로 연락처 정보 불러오기 */
	public PhoneBook getPhoneByName(String name) {
		PhoneBook result = null;
		for(int i=0; i<position; i++) {
			if(name.equals(db[i].getName())) {
				result = db[i];
				break;
			}
		}
		return result;
	}
	
	/* 연락처 정보 출력 메소드 */
	public void infoPrint(PhoneBook phoneBook) {
		System.out.println("----- 검색 결과 -----");
		System.out.println("이름\t" + phoneBook.getName());
		System.out.println("번호\t" + phoneBook.getPhoneNum());
		System.out.println("그룹\t" + phoneBook.getGroup());
		System.out.println("----------------------");
	}
	
	/* 그룹 지정 메소드 */
	public void setGroup(String name, String group) {
		PhoneBook phoneBook = getPhoneByName(name);
		if(phoneBook == null) {
			System.out.println("검색 결과가 없습니다.");
			return;
		}
		
		phoneBook.setGroup(group);
	}
	
	/* 그룹별 검색 메소드 */
	public void searchGroup(String group) {
		
		System.out.println("=====[ " + group + " ]그룹 검색 결과 =====");
		System.out.println("이름\t번호\t\t그룹");
		for(int i=0; i<position; i++) {
			if(group.equals(db[i].group)) {
				System.out.print(db[i].getName() + "\t");
				System.out.print(db[i].getPhoneNum() + "\t");
				System.out.println(db[i].getGroup() + "\t");
			}
		}
		System.out.println("==========================");
	}
	
}