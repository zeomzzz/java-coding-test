import java.io.*;
import java.util.*;

// 1. 완탐 접근
// 신호등 수리하는 모든 경우 판단 -> BC1 + BC2 + BC3 + ... + BCB

// 2. 최적화
// 신호등을 고르는 과정을 줄여야 한다.
// 투 포인터로 K범위 정하고 그 안에서 몇 개 수리해야하는지 확인 ->O(N)

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken()); // 횡단보도 1~N
    	int K = Integer.parseInt(st.nextToken()); // 연속 K개 신호등이 존재하도록
    	int B = Integer.parseInt(st.nextToken()); // 고장난 신호등 B개
    	
    	boolean[] isWorkings = new boolean[N+1];
    	Arrays.fill(isWorkings, true);
    	
    	for (int i=0; i<B; i++) {
    		isWorkings[Integer.parseInt(br.readLine())] = false;
    	}
    	
    	// 1번~K번 고장난 신호등 개수 구하기
    	int cnt = 0;
    	int start = 1;
    	int end = K;
    	for (int i=start; i<=end; i++) {
    		if (!isWorkings[i]) {
    			cnt++;
    		}
    	}
    	
    	// 그 다음 범위 확인하면서 고장난 신호등 개수 최소값 찾기
    	int tmp = cnt;
    	while (end < N) {
    		if (!isWorkings[start]) { // start가 고장이면
    			tmp--; // count에서 빼주고
    		}
    		start++; // start 옮기기
    		
    		end++; // end 한 칸 옮기고
    		if (!isWorkings[end]) { // end가 고장이면
    			tmp++; // 추가
    		}
    		
    		cnt = Math.min(cnt, tmp);
    	}
    	
    	System.out.print(cnt);
    }    
};
