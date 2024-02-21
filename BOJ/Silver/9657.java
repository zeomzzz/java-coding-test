import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[] dp;
	static int[] games = {1, 3, 4};
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	
    	dp = new int[N+1];
    	Arrays.fill(dp, -1);
    	
    	int result = recur(N);
    	
    	if (result == 1) System.out.print("SK");
    	else System.out.print("CY");
    	
    }
    
    static int recur(int cur) { // 내 앞에 cur개 있을 때 이기는가?
    	if (cur < 0) return 1;
    	else if (cur == 0) return 0; // 마지막 돌 상대가 가져감
    	
    	if (dp[cur] != -1) return dp[cur];
    	
    	int cnt = 0;
    	for (int game : games) {
    		if (recur(cur-game) == 0) { // 내 턴에 1, 3, 4개 남는 패 중 지는 패 하나라도 있는가?
    			cnt += 1;
    		}
    	}
    	
    	if (cnt > 0) return dp[cur] = 1;
    	else return dp[cur] = 0;
    }
    
};
