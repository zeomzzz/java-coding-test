import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[] nums;
	static int[] dp;
	static int answer;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	nums = new int[N];
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for (int i=0; i<N; i++) nums[i] = Integer.parseInt(st.nextToken());
    	dp = new int[N+1];
    	Arrays.fill(dp, 1);
    	
    	answer = 0;
    	
    	for (int i=0; i<N; i++) {
    		recur(i);
    	}
    	
    	System.out.print(answer);
    }
    
    static void recur(int cur) {
    	
    	for (int j=0; j<cur; j++) { // i전 j번째까지 중에서
    		if (nums[j] < nums[cur] && dp[cur] < dp[j] + 1) {
    			dp[cur] = dp[j] + 1;
    		}
    	}
    	answer = Math.max(answer, dp[cur]);
    	
    }
    
};
