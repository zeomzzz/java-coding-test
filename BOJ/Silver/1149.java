import java.io.*;
import java.util.*;

public class Main {
	
	static int min = Integer.MAX_VALUE;
	static int N;
	static int[][] houses;
	static int[][] dp;
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	houses = new int[N][3];
    	dp = new int[N][3];
    	for (int i=0; i<N; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
    	StringTokenizer st;
    	for (int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine());
    		houses[i][0] = Integer.parseInt(st.nextToken()); // red
    		houses[i][1] = Integer.parseInt(st.nextToken()); // green
    		houses[i][2] = Integer.parseInt(st.nextToken()); // blue
    	}
    	
    	System.out.print(Math.min(Math.min(recur(0, 0), recur(0, 1)), recur(0, 2)));
    }
    
    static int recur(int cur, int color) {
    	
    	if (cur == N) {
    		return 0;
    	}
    	
    	if (dp[cur][color] != Integer.MAX_VALUE) return dp[cur][color];
    	
    	int total = Integer.MAX_VALUE;
    	
    	for (int i=0; i<3; i++) {
    		if (color == i) continue;
    		total = Math.min(total, recur(cur+1, i) + houses[cur][i]);
    	}
    	
    	dp[cur][color] = total;
    	return dp[cur][color];
    }
    
};
