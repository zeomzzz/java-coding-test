import java.io.*;
import java.util.*;

public class Main {
	
	static int[] marbles;
	static int b1, b2, b3;
	static int k1, k2;
	static int[][] dp;
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	b1 = Integer.parseInt(st.nextToken());
    	b2 = Integer.parseInt(st.nextToken());
    	b3 = Integer.parseInt(st.nextToken());
    	marbles = new int[3];
    	marbles[0] = b1;
    	marbles[1] = b2;
    	marbles[2] = b3;
    	
    	for (int i=0; i<5; i++) {
    		st = new StringTokenizer(br.readLine());
    		k1 = Integer.parseInt(st.nextToken());
    		k2 = Integer.parseInt(st.nextToken());
    		dp = new int[k1+1][k2+2];
    		for (int j=0; j<=k1; j++) Arrays.fill(dp[j], -1);
    		
    		int answer = recur(k1, k2);
    		if (answer == 1) sb.append("A\n");
    		else sb.append("B\n");
    	}
    	
    	System.out.print(sb);
    	
    }
    
    static int recur(int cur1, int cur2) {
    	
    	if (cur1 < 0 || cur2 < 0) return 1;
    	if (cur1 == 0 && cur2 == 0) return 0;
    	
    	if (dp[cur1][cur2] != -1) return dp[cur1][cur2];
    	
    	int cnt = 0;
    	for (int marble : marbles) {
    		if (recur(cur1-marble, cur2) == 0 || recur(cur1, cur2-marble) == 0) {
    			cnt++;
    		}
    	}
    	
    	if (cnt > 0) return dp[cur1][cur2] = 1;
    	return dp[cur1][cur2] = 0;
    }
    
};
