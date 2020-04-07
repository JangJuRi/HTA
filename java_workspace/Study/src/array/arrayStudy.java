package array;

public class arrayStudy {
	public static void main(String[] args) {
		
		int[][] array = new int[5][5];
		int num = 0;
		int numberCount = 5;
		int sw = 1;
		
		int i = 0;
		int j = -1;
		
		while(true) {
			
			for(int x=0; x<numberCount; x++) {
				num ++;
				j += sw;
				array[i][j] = num;
			}
			
			numberCount--;
			
			if(numberCount == 0) {
				break;
			}
			
			for(int x=0; x<numberCount; x++) {
				num ++;
				i += sw;
				array[i][j] = num;
			}
			
			sw *= (-1);
		}
		
		for(int r=0; r<array.length; r++) {
			for(int c=0; c<array[r].length; c++) {
				System.out.print(array[r][c] + "\t");
			}
			System.out.println();
		}
	}
}
