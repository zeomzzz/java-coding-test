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
    	dp = new int[N+1][3];
    	for (int i=0; i<N; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
    	Arrays.fill(dp[N], 0);
    	StringTokenizer st;
    	for (int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine());
    		houses[i][0] = Integer.parseInt(st.nextToken()); // red
    		houses[i][1] = Integer.parseInt(st.nextToken()); // green
    		houses[i][2] = Integer.parseInt(st.nextToken()); // blue
    	}

    	for (int i = N-1; i>=0; i--) {
    		for (int j=0; j<3; j++) {
    			for (int prev=0; prev<3; prev++) {
    				if (prev != j) {
        				dp[i][j] = Math.min(dp[i][j], dp[i+1][prev] + houses[i][j]);
        			}
    			}
    		}
    	}
    	
    	System.out.print(Math.min(Math.min(dp[0][0], dp[0][1]), dp[0][2]));
    }

//    static int recur(int cur, int color) {
//
//    	if (cur == N) {
//    		return 0;
//    	}
//
//    	if (dp[cur][color] != Integer.MAX_VALUE) return dp[cur][color];
//
//    	int total = Integer.MAX_VALUE;
//
//    	for (int i=0; i<3; i++) {
//    		if (color == i) continue;
//    		total = Math.min(total, recur(cur+1, i) + houses[cur][i]);
//    	}
//
//    	dp[cur][color] = total;
//    	return dp[cur][color];
//    }

};

// 241006
import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[][] houses;
	static int[][] dp;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        houses = new int[N][3];
        
        for (int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	houses[i][0] = Integer.parseInt(st.nextToken()); // 빨 
        	houses[i][1] = Integer.parseInt(st.nextToken()); // 초
        	houses[i][2] = Integer.parseInt(st.nextToken()); // 파
        }
        
        dp = new int[N][3];
        for (int i=0; i<N; i++) {
        	Arrays.fill(dp[i], -1);
        }
        
        System.out.println(Math.min(recur(0, 0), Math.min(recur(0, 1), recur(0, 2))));
        
    }
    
    public static int recur(int cur, int prev) {
    	if (cur == N) {
    		return 0;
    	}
    	
    	if (dp[cur][prev] != -1) {
    		return dp[cur][prev];
    	}

    	int total = Integer.MAX_VALUE;
    	
    	for (int i=0; i<3; i++) {
	   		 if (i != prev) {
	   			 total = Math.min(total, recur(cur+1, i) + houses[cur][i]);
	   		 }
    	}
    	
    	dp[cur][prev] = total;
    	
    	return dp[cur][prev];
    }

}
