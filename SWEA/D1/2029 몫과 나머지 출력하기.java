import java.util.Arrays;
import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			int q = a / b;
			int r = a % b;
			
			System.out.printf("#%d %d %d%n", tc, q, r);
		} // tc for loop
	} // scanner
}
