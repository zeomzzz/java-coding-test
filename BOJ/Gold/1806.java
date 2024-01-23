import java.io.*;
import java.util.*;

// 1. 완탐 접근
// 길이 1부터 하나 씩 늘려가면서 S 이상이 되면 stop -> O(N^2) = 100,000,000 > 100,000,000 * 0.5
// for (길이 1 ~ N) {
//  슬라이딩 윈도우로 구하기..
// }

// 2. 최적화
// 누적합 구하고 -> 입력 받을 때
// 그 안에서 투포인터..?

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken()); 
    	long S = Long.parseLong(st.nextToken());
    	
    	long[] prefixSums = new long[N+1];
    	st = new StringTokenizer(br.readLine());
    	for (int i=1; i<=N; i++) {
    		prefixSums[i] = Long.parseLong(st.nextToken()) + prefixSums[i-1];
    	}
    	
    	int answer = Integer.MAX_VALUE;
    	int start = 0;
    	int end = 1;
    	while (start < end && end < N+1) {
    		long tmp = prefixSums[end] - prefixSums[start];
    		
    		if (tmp >= S) {
    			if (end - start < answer) {
    				answer = end - start;
    			}
    			start++; // 길이 줄여보자
    		} else {
    			end++;
    		}
    	}
    	
    	if (answer == Integer.MAX_VALUE) {
    		answer = 0;
    	}
    	System.out.print(answer);
    	
    }    
};
