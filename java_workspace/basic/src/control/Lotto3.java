package control;

public class Lotto3 {
	public static void main(String[] args) {
		
		int n1 = 0;	//첫번째 로또번호
		int n2 = 0;	//두번째 로또번호
		int n3 = 0;	//세번째 로또번호
		int n4 = 0;	//네번째 로또번호
		int n5 = 0;	//다섯번째 로또번호
		int n6 = 0;	//여섯번째 로또번호
		int random;
		
		for(int i=1; i<=6; i++) {
			random = (int) (Math.random()*45+1);
			
			if(random == n1 || random == n2 || random == n3 || random == n4 || random == n5 || random == n6) {
				i--;
			} else {
				switch(i) {
				case 1:
					n1 = random;
					break;
				case 2:
					n2 = random;
					break;
				case 3:
					n3 = random;
					break;
				case 4:
					n4 = random;
					break;
				case 5:
					n5 = random;
					break;
				case 6:
					n6 = random;
					break;
				}
			}
		}
		System.out.println(n1 + "\t" + n2 + "\t" + n3 + "\t" + n4 + "\t" + n5 + "\t" + n6);
	}
}
