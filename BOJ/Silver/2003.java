import java.io.*;
import java.util.*;

// 1. 완탐 접근 : 시간 초과
// - 구간 정하기 : O(N^2) : 10,000 * 10,000 > 100,000,000 * 0.5
// - 구간 범위에 맞게 더하면서 연산

// 2.최적화
// - 구간을 포인터로 옮겨가며 정해줌 -> O(N) : 10,000 < 100,000,000 * 0.5
// - 이 때, 합계도 함께 구함

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken()); // 수의 개수
    	long M = Integer.parseInt(st.nextToken()); // target
    	
    	long[] nums = new long[N];
    	st = new StringTokenizer(br.readLine());
    	for (int i=0; i<N; i++) {
    		nums[i] = Long.parseLong(st.nextToken());
    	}
    	
    	long cnt = 0;
    	int start = 0;
    	int end = 0;
    	long sum = nums[end];
    	while (start <= end && end < N) {
    		if (sum == M) {
    			cnt++;
    			end++; // 범위 바꿔줘야 함
    			if (end < N) sum += nums[end];
    		} else { // 다른 경우
    			if (sum > M) { // sum이 더 크면 범위를 좁히자 
    				sum -= nums[start];
    				start++;
    				if (start > end) {
    					end++;
    					if (end < N) sum += nums[end];
    				}
    			} else { // sum이 더 작으면 범위를 넓히자
    				end++;
    				if (end < N) sum += nums[end];
    			}
    		}
    	}
    	
    	System.out.print(cnt);
    }    
};
