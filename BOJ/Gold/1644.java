import java.io.*;
import java.util.*;

// 1. 완탐 접근
// N 이하의 소수
// 연속된 조합 모두 구해서 N 만들 수 있는지 확인

// 2. 최적화
// 연속된 조합 모두 구하는게..너무 많다.
// N이하의 소수 모두 구하고 투포인터로 범위 옮겨가면서 구하기 

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	
    	// N 이하의 소수 구하기
    	int[] primes = new int[N+1];
    	int idx = 0;
    	boolean[] isPrimes = new boolean[N+1];
    	Arrays.fill(isPrimes, true);
    	isPrimes[0] = false;
    	isPrimes[1] = false;
    	if (N > 1) {
    		for (int i=2; i<=N; i++) {
    			if (isPrimes[i]) {
    				primes[idx++] = i;
    				for (int j=i+i; j<=N; j+=i) {
    					isPrimes[j] = false;
    				}
    			}
    		}
    	}
    	// 소수 idx-1개
    	int cnt = 0;
    	int start = 0;
    	int end = 0;
    	int sum = primes[end];
    	while (start <= end && end < idx) {
    		if (sum == N) {
    			cnt++;
    			sum -= primes[start];
    			start++;
    			end++;
    			if (end < idx) sum += primes[end];
    		} else if (sum < N) {
    			end++;
    			if (end < idx) sum += primes[end];
    		} else {
    			sum -= primes[start];
    			start++;
    		}
    	}
    	
    	System.out.print(cnt);
    }    
};
