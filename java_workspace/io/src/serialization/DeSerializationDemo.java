package serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeSerializationDemo {

	public static void main(String[] args) 
			throws FileNotFoundException, IOException, ClassNotFoundException {
		
		FileInputStream fis = new FileInputStream("c:/files/user.sav");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		// 스트림으로 읽어온 직렬화된 객체의 정보를 바탕으로 User객체를 복\원한다.
		User user = (User) ois.readObject();
		System.out.println("번호 : " + user.getNo());
		System.out.println("아이디 : " + user.getUserId());
		System.out.println("비밀번호 : " + user.getPassword());
		System.out.println("전화번호 : " + user.getTel());
		System.out.println("이메일 : " + user.getEmail());
		
		ois.close();
	}
}
