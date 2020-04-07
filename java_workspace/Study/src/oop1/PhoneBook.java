package oop1;

public class PhoneBook {
	String name;
	String phoneNum;
	String group;
	
	PhoneBook() {}
	
	PhoneBook(String name, String phoneNum) {
		this.name = name;
		this.phoneNum = phoneNum;
		this.group = "지정안함";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}
	
}
