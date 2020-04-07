package control;

public class StarDemo5 {
	public static void main(String[] args) {
		/*
		          **
		         ****
		        ******
		       ********
		      **********
		       ********
		        ******
		         ****
		          **
     	*/
		
			for(int i=1; i<=9; i++) {
				int space = Math.abs(5-i);				
				int star = 10-space*2;
				
				for(int j=1; j<=space; j++) {
					System.out.print(" ");
				}
				for(int k=1; k<=star; k++) {
					System.out.print("*");
				}
				System.out.println();
		}
	}
}
