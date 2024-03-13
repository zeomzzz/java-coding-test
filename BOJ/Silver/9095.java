import java.io.*;
import java.util.*;

public class Main {
	
	static int T, n, answer;
	static int[] dp;
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	T = Integer.parseInt(br.readLine());
    	for (int tc=0; tc<T; tc++) {
    		n = Integer.parseInt(br.readLine());
    		dp = new int[n+1];
    		Arrays.fill(dp, -1);
    		
    		answer = recur(n);
    		System.out.println(answer);
    	}
    	
    }
    
    static int recur(int cur) {
    	
    	if (cur == 0) {
    		return 1;
    	}
    	if (cur < 0) {
    		return 0;
    	}
    	
    	if (dp[cur] != -1) return dp[cur];
    	
    	return recur(cur-1) + recur(cur-2) + recur(cur-3);
    }
    
//    static void recur(int cur) {
//    	
//    	if (cur == 0) {
//    		answer++;
//    		return;
//    	}
//    	if (cur < 0) {
//    		return;
//    	}
//    	
//    	recur(cur-1);
//    	recur(cur-2);
//    	recur(cur-3);
//    }
    
};
