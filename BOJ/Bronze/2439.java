import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for(int n = 0; n < N; n++) {
			for(int a = n; a < N - 1; a++ ) {
				System.out.print(" ");}
			for(int b = 1; b < n + 2; b++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}		
}
