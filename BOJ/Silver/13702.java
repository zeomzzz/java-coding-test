import java.io.*;
import java.util.*;

// 남은 막걸리는 버린다 !
// 1. 완탐 접근
// 최대값부터 1씩 빼면서 찾기

// 2. 최적화
// 매래변수 탐색. 이분 탐색으로
public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken()); // 막걸리 주전자의 수
    	int K = Integer.parseInt(st.nextToken()); // 은상이를 포함한 친구들의 수
    	
    	long[] drinks = new long[N];
    	long s = 1;
    	long e = -1;
    	for (int i=0; i<N; i++) {
    		drinks[i] = Long.parseLong(br.readLine());
    		e = Math.max(drinks[i], e);
    	}
    	
    	long ans = 0;
    	while (s <= e) {
    		long m = (s+e)/2;
    		long cnt = 0; // 총 몇 잔 나오는지 
    		
    		for (long drink : drinks) {
    			cnt += drink / m;
    		}
    		
    		if (cnt >= K) { // 나눠주기 가능 -> 더 많이 나눠줄 수 있는지 확인
    			ans = m;
    			s = m+1;
    		} else {
    			e = m-1;
    		}
    	}
    	
    	System.out.print(ans);
    	
    }
};
