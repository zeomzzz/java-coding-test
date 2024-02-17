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


import java.io.*;
import java.util.*;

// 1. 백트래킹으로 짠다.
// 2. return 방식으로 바꾼다.
// 3. dp로 바꾼다.
public class Main {
	
	static int N;
	static int[] dp;

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	dp = new int[N+1];
    	Arrays.fill(dp, N+1);
    	dp[N] = 0;
    	
    	for (int sum=N; sum>=0; sum--) {
    		for (int nxt=1; sum+nxt*nxt<=N; nxt++) {
        		dp[sum] = Math.min(dp[sum], dp[sum+nxt*nxt]+1);
        	}
    	}
    	
    	System.out.print(dp[0]);
    }

//    static int recur(int sum) { // cnt를 return
//    	
//    	int result = Integer.MAX_VALUE;
//    	
//    	if (sum == N) return 0;
//    	if (sum > N) return Integer.MAX_VALUE;
//    	
//    	if (dp[sum] != Integer.MAX_VALUE) return dp[sum];
//    	
//    	for (int nxt=1; sum+nxt*nxt<=N; nxt++) {
//    		result = Math.min(result, recur(sum+nxt*nxt)+1);
//    	}
//    	return dp[sum] = result;
//    }
};
