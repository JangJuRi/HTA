package list;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDemo2 {

	public static void main(String[] args) {
		
//		오류 : 타입 파라미터<E>에는 클래스명이 정의되어야한다.
//			   int, long, double은 자바의 키워드이다. 클래스명이 아니다.
//		ArrayList<int> numbers = new ArrayList<int>();
//		ArrayList<long> numbers = new ArrayList<long>();
//		ArrayList<double> numbers = new ArrayList<double>();
		
		// 기본자료형에 대응되는 Wrapper 클래스를 타입파라미터로 지정한다.
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		ArrayList<Long> currencies = new ArrayList<Long>();
		ArrayList<Double> scores = new ArrayList<Double>();
		
		numbers.add(new Integer(10));
		numbers.add(10);						// numbers.add(new Integer(10));			--> 오토박싱
		
		currencies.add(new Long(1000000000L));
		currencies.add(1000000000L);			// currencies.add(new Long(1000000000L));	--> 오토박싱
		
		scores.add(new Double(4.2));
		scores.add(4.2);						// scores.add(new Double(4.2));				--> 오토박싱
		
		for(Integer num : numbers) {
			System.out.println(num);
		}
		for(int num : numbers) {				// 반복될 때마다 Integer객체가 꺼내진다.  -->  언박싱되어서 숫자만 num에 대입
			System.out.println(num);
		}
		
		Iterator<Long> itr = currencies.iterator();
		while(itr.hasNext()) {
			Long curr = itr.next();
			System.out.println(curr);
		}
		
		itr = currencies.iterator();
		while(itr.hasNext()) {
			long curr = itr.next();				// itr.next()  -->  long객체 반환  -->  언박싱되어서 숫자만 curr에 대임
			System.out.println(curr);
		}
	}
}
