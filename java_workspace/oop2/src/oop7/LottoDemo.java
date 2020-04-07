package oop7;

import java.util.Arrays;

public class LottoDemo {

	public static void main(String[] args) {
		
		Lotto lotto = new Lotto();
		
		for(int i=0; i<=5; i++) {
			int[] numbers = lotto.generateNumbers();
			System.out.println(Arrays.toString(numbers));			
		}
	}
}
