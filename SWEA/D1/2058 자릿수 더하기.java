import java.util.Arrays;
import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		
		int sum = 0;
		
		for(int idx = 0; idx < N.length(); idx++) {
			char i = N.charAt(idx);
			int n = Character.getNumericValue(i);
			sum += n;
		}
		System.out.println(sum);
		
	} // scanner
}
