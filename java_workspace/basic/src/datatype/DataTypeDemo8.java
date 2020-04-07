package datatype;

public class DataTypeDemo8 {
	public static void main(String[] args) {
		//반지름의 길이가 5, 10, 20인 원들이 있다.
		//각 원들의 넓이와 원의 둘레길이를 계산해서 출력하기
		//넓이는 3.14*반지름*반지름	둘레길이는 2*3.14*반지름
		
		int cir1 = 5;
		int cir2 = 10;
		int cir3 = 20;
		
		Print(cir1);
		Print(cir2);
		Print(cir3);
	}
	
	public static double Area(int n) {
		return 3.14*n*n;
	}
	
	public static double Round(int n) {
		return 2*3.14*n;
	}
	
	public static void Print(int n) {
		System.out.println("반지름이 "+n+"인 원의 넓이 : "+Area(n)+"\n둘레 길이 : "+Round(n)+"\n");
	}
}
