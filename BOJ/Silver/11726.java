import java.io.*;
import java.util.*;

// 1. 백트래킹으로 짠다.
// 2. return 방식으로 바꾼다.
// 3. dp로 바꾼다.
// 채우는 방법 1. | 2. =
public class Main {
	
	static int n;
	static int answer;
	static int[] dp;
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	n = Integer.parseInt(br.readLine());
    	dp = new int[n];
    	Arrays.fill(dp, Integer.MIN_VALUE);
    	
    	System.out.print(recur(0));
    }
    
    static int recur(int cur) { // answer를 return하도록..
    	
    	if (cur > n) return 0;
    	if (cur == n) {
    		return 1;
    	}
    	
    	if(dp[cur] != Integer.MIN_VALUE) return dp[cur];
    	
    	// 다음에 1번으로 채움 // 다음에 2번으로 채움
    	dp[cur] = (Math.max(dp[cur], recur(cur+1) + recur(cur+2))) % 10007;
    	return dp[cur];
    }
};
