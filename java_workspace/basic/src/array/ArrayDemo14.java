package array;

import java.util.Scanner;

public class ArrayDemo14 {
	public static void main(String[] args) {
		/* 야구게임 */
		//1 ~ 9까지의 랜덤 숫자 3개 배열을 생성한다. (secret[])
		// -- while-- 2중for문 사용
		//int strike = 0; int ball = 0;
		//숫자 3개를 입력받고 배열에 담는다. (input[])
		//두 배열에 들어있는 값의 숫자와 위치가 모두 일치하면 Strike
		//숫자만 일치하면 Ball
		//Strike = 3, Ball = 0이면 while문 탈출
		//10번 안에 못맞히면 실패(탈출)
		// ----------
		
		Scanner scanner = new Scanner(System.in);
		
		int[] secret = new int[3];
		int[] input = new int[3];
		int strike = 0;
		int ball = 0;
		int count = 0;
		
		/* 랜덤 숫자 저장 */
		for(int i=0; i<3; i++) {
			int randomNumber = (int) (Math.random()*9 + 1);
			boolean isExist = false;
			
			for(int j=0; j<3; j++) {					//랜덤값 중복 for문
				if(secret[i] == randomNumber) {			//랜덤값이 중복되면 실행 후 break
					isExist = true;
					break;
				}
			}	
			if(!isExist) {								//중복값이 없으면 배열에 저장
				secret[i] = randomNumber;
			} else {									//중복값이 있으면 다시 반복
				i--;
			}
		}
		
		/* 숫자 입력받기 */
		while(true) {			
			if(count > 10) {							//횟수 10회 넘으면 break
				System.out.println("\n\n====== 시도 횟수 10회 초과로 실패하셨습니다. ======");
				System.out.print("정답 : [ ");
				for(int i=0; i<secret.length; i++) {
					System.out.print(secret[i] + " ");
				}
				System.out.println("] ");		
				break;		
			}
			count++;									//횟수 카운트
			
			for(int i=0; i<3; i++) {
				System.out.print("숫자를 입력해주세요 : ");
				input[i] = scanner.nextInt();
			}
			
			for(int i=0; i<3; i++) {
				if(secret[i] == input[i]) {				//숫자와 위치가 같으면 strike
					strike++;
				} else {								//숫자와 위치가 같지 않을 경우
					for(int j=0; j<3; j++) {
						if(secret[i] == input[j]) {		//숫자만 같으면 ball
							ball++;
						}
					}
				}		
			}
			
			 if(strike == 3) {
				System.out.println("\n\n====== " + count + "번 만에 성공하셨습니다!" + " ======");
				System.out.print("정답 : [ ");
				for(int i=0; i<secret.length; i++) {
					System.out.print(secret[i] + " ");
				}
				System.out.println("] ");
				
				break;				
				
			} else {
				System.out.println("-------------------------");
				System.out.println(strike + "S\t" + ball +"B");
				System.out.println("시도 횟수 : " + count);
				System.out.println("-------------------------\n");
				strike = 0;
				ball = 0;
			}		
		}
	}
}