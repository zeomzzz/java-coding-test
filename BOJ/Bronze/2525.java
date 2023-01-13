import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int A, B, C, T, H, M;
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
		
		T = A * 60 + B + C;
		H = T / 60;
		M = T - H * 60;
		
		if(H == 24) {
			H = 0;
		} else if(H > 24) {
			H -= 24;
		}
		
		System.out.println(H + " " + M);

	}
}
