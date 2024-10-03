import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine()); // N일
    	
    	int[][] counsels = new int[N][2];
    	StringTokenizer st;
    	for (int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine());
    		counsels[i][0] = Integer.parseInt(st.nextToken());
    		counsels[i][1] = Integer.parseInt(st.nextToken());
    	}
    	
    	int[] dp = new int[N+100];
    	Arrays.fill(dp, Integer.MIN_VALUE);
    	dp[N] = 0;
    	
    	for (int cur=N-1; cur>=0; cur--) {
    		dp[cur] = Math.max(dp[cur+counsels[cur][0]]+counsels[cur][1], dp[cur+1]);
    	}
    	
    	System.out.print(dp[0]);
    }
    
//    static int recur(int cur, int N, int[][] counsels) {
//    	
//    	if (cur > N) return Integer.MIN_VALUE;
//    	
//    	if (cur == N) return 0;
//    	
//    	if (dp[cur] != -1) return dp[cur]; // 이미 찾았으면 있는거 리턴
//    	
//    	// 이번거 선택, 선택 안함 중 max
//    	return dp[cur] = Math.max(recur(cur+counsels[cur][0], N, counsels) + counsels[cur][1], recur(cur+1, N, counsels));
//    }
    
};

// 241003
import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[] dp;
	static int[][] works;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        works = new int[N][2];
        
        for (int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	works[i][0] = Integer.parseInt(st.nextToken());
        	works[i][1] = Integer.parseInt(st.nextToken());
        }
        
        dp = new int[N+50];
        Arrays.fill(dp, 0);
        
        for (int i=N-1; i>=0; i--) {
        	if (i+works[i][0] <= N) { // 다음 일 받을 수 있는 날이 i+works[i][0]
        		dp[i] = Math.max(dp[i+works[i][0]]+works[i][1], dp[i+1]);
        	} else {
        		dp[i] = dp[i+1]; // 다음 일 받을 수 있는 날이 i+1
        	}
        }
        
        System.out.print(dp[0]);
    }

}
