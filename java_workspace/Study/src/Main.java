import java.util.Scanner;

public class Main {
   
   public static void main(String[] args) {
      
      int first = 0;
      int second = 0;
      int temp = 0;
      int count = 0;
      
      Scanner sc = new Scanner(System.in);
      int number = sc.nextInt();
      
      first = number / 10;   
      second = number % 10;   
      
      while(true) {
         
         count++;
         temp = second;
         second = (first + second) % 10;
         first = temp;
         
         if(number == first*10 + second) {
            break;
         }
      }
      System.out.println(count);
   }
}