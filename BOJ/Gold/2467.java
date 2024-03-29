import java.io.*;
import java.util.*;

// 1. 완탐 접근 : 시간 초과
// 2중 for문으로 abs 기준으로 계속 답을 업데이트 : 100,000 * 100,000 = 10,000,000,000 > 100,000,000


// 2. 최적화
// 이미 정렬해서 입력을 줌
// 투 포인터로 양 끝에서 중앙으로 수렴하도록 이동시킴

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	// 자료형 long !!
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	
    	long[] liquids = new long[N];
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for (int i=0; i<N; i++) {
    		liquids[i] = Long.parseLong(st.nextToken());
    	}
    	
    	if (liquids[0] >= 0L) {
    		System.out.printf("%d %d", liquids[0], liquids[1]);
    	} else if (liquids[N-1] <= 0L) {
    		System.out.printf("%d %d", liquids[N-2], liquids[N-1]);
    	} else {
    		int ansStart = 0;
    		int ansEnd = N-1;
    		int start = 0;
    		int end = N-1;
    		long value = Long.MAX_VALUE;
    		
    		while (start < end) {
    			long mixed = liquids[start] + liquids[end];
    			if (mixed == 0L) {
    				ansStart = start;
    				ansEnd = end;
    				break;
    			} else if (mixed < 0L) {
    				if (value > Math.abs(mixed)) {
    					value = Math.abs(mixed);
    					ansStart = start;
    					ansEnd = end;
    				}
    				start++;
    			} else {
    				if (value > Math.abs(mixed)) {
    					value = Math.abs(mixed);
    					ansStart = start;
    					ansEnd = end;
    				}
    				end--;
    			}
    		}
    		System.out.printf("%d %d", liquids[ansStart], liquids[ansEnd]);
    	}
    	
    }    
};
