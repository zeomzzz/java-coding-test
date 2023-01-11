import java.util.Scanner;

class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int ans = sc.nextInt();
			
			for(int i = 1; i <= 9; i++) {
				int num = sc.nextInt();
				if(ans < num) {
					ans = num;
				}
			}
			System.out.println("#" + tc + " " + ans);
		}

	}

}
