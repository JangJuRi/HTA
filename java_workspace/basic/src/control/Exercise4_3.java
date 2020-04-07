package control;

public class Exercise4_3 {
	public static void main(String[] args) {
		int total = 0;
		
		for(int i=1; i<=10; i++) {
			for(int j=1; j<=i; j++) {
				total +=j;
			}
		}
		System.out.println(total);
	}
}
