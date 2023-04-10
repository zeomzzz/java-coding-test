// DP 풀이
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt(); // tc개수
		
		for(int tc=1; tc<=t; tc++) {
			
			int n = sc.nextInt();
			int money = n / 10;
			int[] types = {1, 5, 10, 50, 100, 500, 1000, 5000};
			int[][] dp = new int[9][money+1]; // 마지막 r에는 개수를 입력
			dp[0][1] = dp[8][1] = 1;
			for(int m=2; m<=money; m++) { // m원일 때의 거스름돈
				int min = Integer.MAX_VALUE;
				dp[8][m] = min; // min으로 초기화
				
				for(int i=0; i<8; i++) {
					if(m>=types[i] && dp[8][m] > dp[8][m-types[i]]+1) { // 거슬러줘야 하는 금액이 동전 종류보다 크고, 이 동전 썼을 때 min 갱신되면
						dp[8][m] = dp[8][m-types[i]]+1; // min 바꿔주고
						for(int j=0; j<8; j++) dp[j][m] = dp[j][m-types[i]]; // 개수 바꿔줌
						dp[i][m]++;
					}
				}

			}
			
			System.out.printf("#%d\n", tc);
			
			for(int i=7; i>=0; i--) {
				System.out.print(dp[i][money] + " ");
			}
			
			System.out.println();
			
		} // tc
	} // main

}
