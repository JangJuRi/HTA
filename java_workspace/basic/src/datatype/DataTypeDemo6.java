package datatype;

import java.io.Console;
import java.util.logging.Logger;

public class DataTypeDemo6 {
	public static void main(String[] args) {
		/* 문자열 결합하기 */
		//문자열과 +연산자가 같이 사용될 때는 문자열과 해당 값이 결합되어서 새로운 문자열이 만들어진다.
		
		//"문자열1" + "문자열2" 	-→ "문자열1문자열2"
		//"문자열1" + 3 			-→ "문자열13"
		//3 + "문자열" 			-→ "3문자열"
		//3 + 3 + "문자열" 		-→ "6문자열"
		//"문자열" + 3 + 3 		-→ "문자열33"
		
		String str1 = "안녕하세요. ";
		String str2 = "홍길동님";
		String str3 = str1 + str2;
		System.out.println(str3);
		
		String str4 = "국어 점수 : ";
		int kor = 80;
		int eng = 70;
		int math = 100;
		
		String str5 = str4 + kor;
		System.out.println(str5);
		
		int total = kor+eng+math;
		System.out.println("총점 : "+total);
	}
	
}
