import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	int K = Integer.parseInt(st.nextToken());
    	
        long[][] dp = new long[N+1][K+1];
        for (int i=1; i<=K; i++) {
        	dp[0][i] = 1;
        }
        
        for (int k=1; k<=K; k++) {
        	for (int n=1; n<=N; n++) {
        		dp[n][k] = (dp[n][k-1] + dp[n-1][k]) % (1000000000);
        	}
        }
        
        System.out.println(dp[N][K]);
        
    }

}
