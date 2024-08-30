/*
 * 1. 완탐
 * - 2명을 고른다. : N * N
 * - 둘 중 min과 그 사이의 개발자수를 구한다
 * => 100,000 * 100,000 = 10,000,000,000
 * 
 * 2. 투포인터
 * - 2명을 투포인터로 고른다. (양 끝에서 시작)
 * - s, e 중 더 큰 것은 유지하고 나머지는 한 칸 가까이 이동
 */
import java.util.*;
import java.io.*;

class Main {
	
	static int N;
	static long[] nums;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        
        nums = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
        	nums[i] = Long.parseLong(st.nextToken());
        }
        
        int s = 0;
        int e = N-1;
        long max = -1;
        
        while (s < e) {
        	
        	max = Math.max(max, (e-s-1) * Math.min(nums[s], nums[e]));
        	
        	if (nums[s] < nums[e]) {
        		s++;
        	} else {
        		e--;
        	}
        	
        }
        
        System.out.print(max);
        
    }
   
};
