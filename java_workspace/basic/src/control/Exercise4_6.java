package control;

public class Exercise4_6 {
	public static void main(String[] args) {
		
		for(int dice1=1; dice1<=6; dice1++) {
			for(int dice2=1; dice2<=6; dice2++) {
				if(dice1+dice2 == 6) {
					System.out.println("1번 주사위 : " + dice1 + "\t" + "2번 주사위 : " + dice2);
				}
			}
		}
	}
}
