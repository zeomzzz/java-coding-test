import java.io.*;
import java.util.*;

public class Main {
	
	static int X, answer;
	static int[] dp;
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	X = Integer.parseInt(br.readLine());
    	dp = new int[X+1];
    	Arrays.fill(dp, -1);
    	
    	answer = recur(X);
    	
    	System.out.print(answer);
    }
    
    static int recur(int cur) {
    	
    	if (cur < 1) return Integer.MAX_VALUE;
    	if (cur == 1) return 0;
    	if (dp[cur] != -1) return dp[cur];
    	
    	if (cur % 6 == 0) {
    		return dp[cur] = Math.min(Math.min(recur(cur/3)+1, recur(cur/2)+1), recur(cur-1)+1);
    	} else if (cur % 3 == 0) {
    		return dp[cur] = Math.min(recur(cur/3)+1, recur(cur-1)+1);
    	} else if (cur % 2 == 0) {
    		return dp[cur] = Math.min(recur(cur/2)+1, recur(cur-1)+1);
    	} else {
    		return dp[cur] = recur(cur-1)+1;
    	}
    }
    
//    static void recur(int cur, int cnt) {
//    	
//    	if (cur == 1) {
//    		answer = Math.min(answer, cnt);
//    		return;
//    	}
//    	
//    	if (cur < 1) return;
//    	
//    	if (cur % 3 == 0) recur(cur/3, cnt+1);
//    	if (cur % 2 == 0) recur(cur/2, cnt+1);
//    	recur(cur-1, cnt+1);
//    }
    
    
};
