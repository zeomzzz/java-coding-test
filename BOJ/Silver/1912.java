import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int[] dp = new int[n+1];
    	int max = Integer.MIN_VALUE;
    	for (int i=1; i<n+1; i++) {
    		int cur = Integer.parseInt(st.nextToken());
    		dp[i] = Math.max(dp[i-1]+cur, cur);
    		max = Math.max(dp[i], max);
    	}
    	
    	System.out.print(max);
    }    
};
