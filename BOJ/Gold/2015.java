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
