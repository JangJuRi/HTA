package operator;
import java.util.Scanner;

public class ScannerDemo3 {
	public static void main(String[] args) {
		/*
		 * 고객명, 상품명, 가격, 구매수량, 사용포인트를 입력받는다.
		 * 출력내용
		 * 고객명, 상품명, 가격, 구매수량, 구매가격, 사용포인트, 결제금액, 적립포인트
		 * 사용포인트는 고객이 이미 적립한 포인트가 있다고 가정하고, 임의의 값을 입력받는다.
		 * 결제금액은 구매가격에서 포인트 사용량을 제외한 금액이다.
		 * 적립포인트는 실결제금액의 3%다.
		 */
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("고객명을 입력해주세요 : ");
		String name = scanner.next();
		System.out.print("상품명을 입력해주세요 : ");
		String productName = scanner.next();
		System.out.print("가격을 입력해주세요 : ");
		int price = scanner.nextInt();
		System.out.print("구매수량을 입력해주세요 : ");
		int amount = scanner.nextInt();
		System.out.print("사용하실 포인트를 입력해주세요 : ");
		int usePoint = scanner.nextInt();
		
		int total = price * amount;
		int realTotal = total - usePoint;
		int point = (int) (realTotal * 0.03);
		
		System.out.println("\n고객명\t상품명\t가격\t구매수량\t구매가격\t사용포인트\t결제금액\t적립포인트");
		System.out.println(name +"\t"+ productName +"\t"+ price +"\t"+ amount + "\t"+ total +"\t"+ usePoint +"\t"+ realTotal +"\t"+point);
	}
}
