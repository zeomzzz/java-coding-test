import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			double sum = 0;
			for(int i = 0; i < 10; i++) {
				int num = sc.nextInt();
				sum += num;
			}
			double ans = sum / 10;
			String result = String.format("%.0f", ans);
			System.out.println("#" + tc + " " + result);
		} // tc
	}
}
