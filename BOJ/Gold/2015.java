import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	int K = Integer.parseInt(st.nextToken());
    	
    	// sum[i, j] = sum[j] - sum[i-1] = K 를 찾는 것
    	// 따라서 sum[j] - K 인 값이 sum[j-1]까지 중에 있는지, 몇 개 있는지를 보면 된다
    	Map<Long, Long> sumMap = new HashMap<>();
    	sumMap.put(0L, 1L);
    	st = new StringTokenizer(br.readLine());
    	long cnt = 0;
    	long sum = 0;
    	for (long i=1; i<N+1; i++) {
    		sum += Long.parseLong(st.nextToken());
    		if (sumMap.containsKey(sum-K)) {
    			cnt += sumMap.get(sum-K);
    		}
    		if (sumMap.containsKey(sum)) {
    			sumMap.put(sum, sumMap.get(sum)+1);
    		} else {
    			sumMap.put(sum, 1L);
    		}
    	}
    	
    	System.out.print(cnt);
    }    
};

// 240827
import java.util.*;
import java.io.*;

class Main {
	
	static int N;
	static long K;
	static long[] prefixSum;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Long.parseLong(st.nextToken());
        
        prefixSum = new long[N+1];
        
        Map<Long, Long> sumMap = new HashMap<>();
        sumMap.put(0L, 1L);
        
        st = new StringTokenizer(br.readLine());
        long answer = 0;
        for (int i=1; i<=N; i++) {
        	prefixSum[i] = prefixSum[i-1] + Long.parseLong(st.nextToken());
        	
        	answer += sumMap.getOrDefault(prefixSum[i]-K, 0L);
        	sumMap.put(prefixSum[i], sumMap.getOrDefault(prefixSum[i], 0L) + 1);
        }
        
        System.out.print(answer);
    }
   
};
