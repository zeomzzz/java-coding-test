import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int A, B, C, prize;
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
		
		prize = Math.max(Math.max(A, B), C) * 100;
		if(A == B & B == C) {
			prize = 10000 + A * 1000;
		} else if(A == B | C == A) {
			prize = 1000 + A * 100;
		} else if(B == C) {
			prize = 1000 + B * 100;
		}
		
		System.out.println(prize);

	}
}
