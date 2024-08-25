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

// 240825
// 누적합
import java.util.*;
import java.io.*;

class Main {
	
	static int n;
	static long[] prefixSum, prefixSumMin, suffixSumMax;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        prefixSum = new long[n+1];
        prefixSumMin = new long[n+1];
        suffixSumMax = new long[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=n; i++) {
        	prefixSum[i] = prefixSum[i-1] + Long.parseLong(st.nextToken());
        	if (i==1) {
        		prefixSumMin[i] = prefixSum[i];
        	} else {
        		prefixSumMin[i] = Math.min(prefixSumMin[i-1], prefixSum[i]);
        	}
        	suffixSumMax[i] = prefixSum[i];
        }
        
        for (int i=n-1; i>0; i--) {
        	suffixSumMax[i] = Math.max(suffixSumMax[i], suffixSumMax[i+1]);
        }
        
//        System.out.println(Arrays.toString(prefixSumMin));
//        System.out.println(Arrays.toString(suffixSumMax));
        
        long answer = Long.MIN_VALUE;
        for (int i=1; i<=n; i++) {
        	answer = Math.max(answer, suffixSumMax[i] - prefixSumMin[i-1]);
        }
        
        System.out.print(answer);
        
    }
    
};
