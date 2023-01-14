import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for(int n = 1; n <= N; n++) {
				for(int i = 1; i <= n; i++) {
					System.out.print("*");
				}
				System.out.println();
      
		} // tc for
	}
}
