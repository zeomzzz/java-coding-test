import java.io.*;
import java.util.*;

// 1. 백트래킹으로 짠다.
// 2. return 방식으로 바꾼다.
// 3. dp로 바꾼다.
public class Main {

	static int N;
	static int K;
	static int[][] items;
	static int[][] dp;
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken()); // 물품의 수
    	K = Integer.parseInt(st.nextToken()); // 버틸 수 있는 무게
    	items = new int[N][2];
    	for (int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine());
    		items[i][0] = Integer.parseInt(st.nextToken()); // 무게
    		items[i][1] = Integer.parseInt(st.nextToken()); // 가치
    	}
    	dp = new int[N+1][K+1];
    	for (int[] tmp : dp) Arrays.fill(tmp, Integer.MIN_VALUE);
    	Arrays.fill(dp[N], 0);
    	
    	for (int cur=N-1; cur>=0; cur--) {
    		for (int weight=0; weight<=K; weight++) {
    			if (weight+items[cur][0] <= K) dp[cur][weight] = Math.max(dp[cur+1][weight+items[cur][0]]+items[cur][1], dp[cur+1][weight]);
    			else dp[cur][weight] = dp[cur+1][weight];
    		}
    	}
    	
    	System.out.print(dp[0][0]);
    }
    
//    static int recur(int cur, int weight) { // value를 return
//    	
//    	if (weight > K) return Integer.MIN_VALUE;
//    	if (cur == N) {
//    		return 0;
//    	}
//    	
//    	if (dp[cur][weight] != Integer.MIN_VALUE) return dp[cur][weight];
//    	
//    	return dp[cur][weight] = Math.max(recur(cur+1, weight+items[cur][0])+items[cur][1], recur(cur+1, weight));
//    }

};

// 241007
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, K;
	static int[][] items, dp;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        items = new int[N][2];
        for (int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	items[i][0] = Integer.parseInt(st.nextToken()); // 무게(W)
        	items[i][1] = Integer.parseInt(st.nextToken()); // 가치(V)
        }
        
        dp = new int[N][K+1];
        for (int i=0; i<N; i++) {
        	Arrays.fill(dp[i], -1);
        }
        
        System.out.print(recur(0, 0));
    }
    
    public static int recur(int cur, int totalWeight) { // cur까지 왔을 때 totalWeight라면 totalValue얼마인지
    	
    	if (totalWeight > K) {
    		return -1000000000; // 엄청 큰 손해 
    	}
    	
    	if (cur == N) {
    		return 0;
    	}
    	
    	if (dp[cur][totalWeight] != -1) {
    		return dp[cur][totalWeight];
    	}
    	
    	dp[cur][totalWeight] = Math.max(recur(cur+1, totalWeight+items[cur][0])+items[cur][1], recur(cur+1, totalWeight));
    	
    	return dp[cur][totalWeight];
    	
    }

}
