import java.util.Scanner;
 
public class Solution {
     
    static int sumScore = 0;
    static int sumCal = 0;
    static int maxScore = 0;
     
    public static void main(String[] args) {
         
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
         
        for(int tc=1; tc<=t; tc++) {
             
            maxScore = 0;
             
            int n = sc.nextInt(); // 재료의 수 n
            int l = sc.nextInt(); // 칼로리 제한 l
             
            int[] score = new int[n];
            int[] cal = new int[n];
             
            for(int i=0; i<n; i++) {
                score[i] = sc.nextInt();
                cal[i] = sc.nextInt();
            }
             
             
            for(int i=0; i<(1<<n); i++) { // 부분집합 2^n개
                 
                boolean flag = true;
                 
                // 새로운 부분 집합에 대해 확인할 때마다 sumScore, sumCal을 초기화
                sumScore = 0;
                sumCal = 0;
                 
                for(int j=0; j<n; j++) { // n가지 재료에 대해서 확인
                    if((i & (1<<j)) > 0) {
                        sumScore += score[j];
                        sumCal += cal[j];
                         
                        if(sumCal>l) {
                            flag = false;
                            break;
                        }
                    }
                }
                 
                if(flag == false) continue;
                 
                if(sumScore > maxScore) maxScore = sumScore;
            }
             
            System.out.printf("#%d %d\n", tc, maxScore);
             
        } // tc
         
    }
}


// DP 풀이
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // tc개수

		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt(); // 재료의 수
			int L = sc.nextInt(); // 제한 칼로리

			int[] scores = new int[N+1];
			int[] cals = new int[N+1];
			for (int i = 1; i <= N; i++) {
				scores[i] = sc.nextInt(); // 맛에 대한 점수
				cals[i] = sc.nextInt(); // 칼로리
			}

			int[][] dp = new int[N+1][L+1];
			for (int i = 1; i <= N; i++) { // 아이템 0 ~ N-1 로 N가지
				for (int l = 0; l <= L; l++) {
					if (cals[i] <= l) { // 칼로리가 범위 안
						dp[i][l] = Math.max(dp[i-1][l], dp[i-1][l-cals[i]] + scores[i]);
					} else {
						dp[i][l] = dp[i-1][l];
					}
				}
			}
			
			System.out.printf("#%d %d\n", tc, dp[N][L]);

		} // tc
	} // main

}
