import java.util.Scanner;

public class Main {
	static int ans = 1;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int tc=1; tc<=t; tc++) {
			
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			System.out.printf("%.0f\n", comb(n, m));
			
			
		} // tc

	}
	
	public static double comb(int n, int m) { // mCn
		
		double a = 1;
		double b = 1;
		
		for(double i=m; i>m-n; i--) {
			a *= i;
		}
		
		for(double i=n; i>=1; i--) {
			b *= i;
		}
		
		return a/b;
		
	}
	
}
