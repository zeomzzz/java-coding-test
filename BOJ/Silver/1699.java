import java.io.*;
import java.util.*;

// 1. 백트래킹으로 짠다.
// 2. return 방식으로 바꾼다.
// 3. dp로 바꾼다.
public class Main {
	
	static int answer;
	static int N;
	static int limit;
	static int[][] dp;

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	limit = (int) Math.pow(N, 0.5);
    	dp = new int[limit+1][N+1]; // cur, sum cur까지의 수를 이용해서 sum을 만드는 경우의 수
    	for (int[] tmp : dp) Arrays.fill(tmp, Integer.MAX_VALUE);
    	
    	answer = recur(1, 1);
    	System.out.print(answer);
    }

    static int recur(int cur, int sum) { // cnt를 return
    	if (cur > limit) return N+1; // N+1은 답이 될 수 없음
    	if (sum > N+1) return N+1;
    	if (sum == N+1) return 0;
    	if (dp[cur][sum] != Integer.MAX_VALUE) return dp[cur][sum];
    	
    	return dp[cur][sum] = Math.min(Math.min(recur(cur, sum+cur*cur)+1, recur(cur+1, sum+cur*cur)+1), recur(cur+1, sum));
    }
};
