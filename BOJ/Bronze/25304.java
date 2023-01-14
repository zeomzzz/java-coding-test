import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt(); //  총 금액 X
		int N = sc.nextInt(); // 물건 종류의 수 N
		int sum = 0; // 물건 가격 총합 sum
		
		for(int i = 0; i < N; i++) {
			int a = sc.nextInt(); // 물건의 가격 a
			int b = sc.nextInt(); // 물건 개수 b
			
			sum += a * b;
			
		} // N개 물건 for
		
		String ans = "Yes";
		if(sum != X) {
			ans = "No";
		}
		
		System.out.println(ans);
		
	}
}
