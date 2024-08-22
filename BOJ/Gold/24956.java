import java.util.*;
import java.io.*;
import java.math.*;

class Main {
	
	static int N;
	static String S;
	static long[] w_prefix_sum, e_prefix_sum;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
    	S = br.readLine();
    	w_prefix_sum = new long[N+1];
    	e_prefix_sum = new long[N+1];
    	List<Integer> h_idxs = new LinkedList<>();
    	
    	for (int i=1; i<=N; i++) {
    		if (S.charAt(i-1) == 'W') {
    			w_prefix_sum[i] = w_prefix_sum[i-1] + 1;
    		} else {
    			w_prefix_sum[i] = w_prefix_sum[i-1];
    		}
    		
    		if (S.charAt(i-1) == 'E') {
    			e_prefix_sum[i] = e_prefix_sum[i-1] + 1;
    		} else {
    			e_prefix_sum[i] = e_prefix_sum[i-1];
    		}
    		
    		if (S.charAt(i-1) == 'H') {
    			h_idxs.add(i);
    		}
    	}
    	
    	BigInteger answer = BigInteger.valueOf(0);
    	long wCnt = 0;
    	long eCnt = 0;
    	BigInteger eTmp;
    	BigInteger tmpAnswer;
    	for (int h_idx : h_idxs) {
    		wCnt = w_prefix_sum[h_idx];
    		eCnt = e_prefix_sum[N] - e_prefix_sum[h_idx];
    		eTmp = BigInteger.valueOf(1);
    		tmpAnswer = BigInteger.valueOf(0);
    		
    		eTmp = BigInteger.valueOf(2).pow((int)eCnt).subtract(BigInteger.valueOf(eCnt + 1));
    		
    		tmpAnswer = BigInteger.valueOf(wCnt).multiply(eTmp);
    		
    		answer = answer.add(tmpAnswer);
    	}
    	
    	System.out.print(answer.mod(BigInteger.valueOf(1000000007)));
    	
    }
    
};
