import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int T = Integer.parseInt(br.readLine());
    	
    	int n = Integer.parseInt(br.readLine());
    	long[] aSumArr = new long[n+1];
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for (int i=1; i<n+1; i++) {
    		aSumArr[i] = aSumArr[i-1] + Long.parseLong(st.nextToken());
    	}
    	
    	Map<Long, Long> aSumMap = new HashMap<>();
    	for (int i=1; i<n+1; i++) {
    		for (int j=i; j<n+1; j++) {
    			long partSum = aSumArr[j] - aSumArr[i-1];
    			long cnt = aSumMap.getOrDefault(partSum, 0L);
    			aSumMap.put(partSum, cnt+1);
    		}
    	}
    	
    	int m = Integer.parseInt(br.readLine());
    	long[] bSumArr = new long[m+1];
    	st = new StringTokenizer(br.readLine());
    	for (int i=1; i<m+1; i++) {
    		bSumArr[i] = bSumArr[i-1] + Long.parseLong(st.nextToken());
    	}
    	
    	Map<Long, Long> bSumMap = new HashMap<>();
    	for (int i=1; i<m+1; i++) {
    		for (int j=i; j<m+1; j++) {
    			long partSum = bSumArr[j] - bSumArr[i-1];
    			long cnt = bSumMap.getOrDefault(partSum, 0L);
    			bSumMap.put(partSum, cnt+1);
    		}
    	}
    	
    	long cnt = 0;
    	for (long key : aSumMap.keySet()) {
    		if (bSumMap.containsKey(T-key)) {
    			cnt += bSumMap.get(T-key) * aSumMap.get(key);
    		}
    	}
    	
    	System.out.println(cnt);
    }    
};
