import java.util.Arrays;
import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i = 2; i <= N; i++) {
			if(N % i == 0) {
				System.out.print(i + " ");
			}
		}
	} // scanner
}
