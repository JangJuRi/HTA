package datatype;

public class DataTypeDemo7 {
	public static void main(String[] args) {
		/* 변수 활용하기 */
		/*
		 * 본인의 이름, 전화번호, 이메일, 나이, 키, 몸무게, 혈액형,결혼 여부를 저장하는 변수를 선언하고, 해당 값을 각 변수에 저장하기
		 * 각 변수에 저장된 값을 출력하기 
		 */
		
		String name = "장주리";
		String phone = "010-1234-5678";
		String email = "abc@gmail.com";
		int age = 21;
		double height = 100;
		double weight = 100;
		String blood = "A";
		boolean marry = false;
		
		System.out.println("이름 : "+name+"\n전화번호 : "+phone+"\n이메일 : "+email+"\n나이 : "+age+"\n키 : "+height+"\n몸무게 : "+weight+"\n혈액형 : "+blood+"\n결혼 여부 : "+marry);
	}
}
