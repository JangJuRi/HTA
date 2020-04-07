package array;

import java.util.Scanner;

public class Exercise5_6 {
	public static void main(String[] args) {
		String[] words = {"television", "computer", "mouse", "phone"};
		
		Scanner scanner = new Scanner(System.in);
		
		for(int i=0; i<words.length; i++) {
			char[] question = words[i].toCharArray();
			
			for(int j=0; j<words.length; j++) {
				int w = (int) (Math.random() * question.length);
				char tmp;
				
				tmp = question[j];
				question[j] = question[w];
				question[w] = tmp;
			}
			
			System.out.print(question);
			System.out.print("의 정답을 입력하세요 : ");
			String answer = scanner.nextLine();
			
			if(words[i].equals(answer.trim())) {
				System.out.println("맞았습니다.\n\n");
			} else {
				System.out.println("틀렸습니다.\n\n");
			}
		}
	}
}
