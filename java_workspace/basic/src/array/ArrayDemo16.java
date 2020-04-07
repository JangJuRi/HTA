package array;

import java.util.Arrays;

public class ArrayDemo16 {
	public static void main(String[] args) {
		
		/* 배열 정렬하기 */
		//배열의 값을 오름차순으로 정렬하기
		int[] numbers = {10, 29, 1, 5, 23, 75, 31};
		Arrays.sort(numbers);
		
		//배열의 값을 문자열로 변환해서 제공하기
		String text = Arrays.toString(numbers);
		System.out.println(text);
		
		String[] names = {"이순신", "김유신", "강감찬", "류관순", "안중근"};
		Arrays.parallelSort(names);
		/*
		 * Serial	-> 직렬 = 한번에 하나씩 처리
		 * Parallel	-> 병렬 = 한번에 여러개 처리
		 */
		System.out.println(Arrays.toString(names));
		
		/* 배열 복사하기 */
		// Arrays.copyOf(원본배열, 복사할 값의 개수);
		// Arrays.copyOfRange(원본배열, 복사 시작위치, 복사 끝위치);
		
		numbers = new int[]{1,2,3,4,5,6,7,8,9,10};
		
		int[] arr1 = Arrays.copyOf(numbers, 10);
		int[] arr2 = Arrays.copyOf(numbers, 5);
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		
		int[] arr3 = Arrays.copyOfRange(numbers, 0, 3);		//numbers[0] numbers[1] numbers[2] 복사
		int[] arr4 = Arrays.copyOfRange(numbers, 4, 7);		//numbers[4] numbers[5] numbers[6] 복사
		int[] arr5 = Arrays.copyOfRange(numbers, 0, numbers.length);
		System.out.println(Arrays.toString(arr3));
		System.out.println(Arrays.toString(arr4));
		System.out.println(Arrays.toString(arr5));
		
	}
}
