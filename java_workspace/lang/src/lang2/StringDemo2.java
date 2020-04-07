package lang2;

import java.util.StringTokenizer;

public class StringDemo2 {

	public static void main(String[] args) {
		// split()과 StringTokenizer
		// * split()은 구분자를 기준으로 잘랐을 때 빈 문자열도 배열에 담아둔다.
		// StringTokenizer는 구문자를 기준으로 잘랐을 때 빈 문자열은 버린다.
		
		String str = "김유신,,강감찬,이순신";
		
		String[] items = str.split(",");
		for (String item : items) {
			System.out.println("배열의 값 : [" + item + "]");		// 결과 --> ["김유신", "", "강감찬", "이순신"]
		}
		
		System.out.println();
		
		StringTokenizer tokens = new StringTokenizer(str, ",");		// 결과 --> ["김유신", "강감찬", "이순신"]
		while(tokens.hasMoreTokens()) {
			String value = tokens.nextToken();
			System.out.println("토큰의 값 : [" + value + "]");		
		}
	}
}
