import java.io.*;
import java.util.*;

// 1. 완탐 접근
// 보석을 다 일렬로 정렬하고
// N중 for문으로 찾기

// 2. 최적화
// 찾는 것 : 질투심(최대값)이 최소인 경우의 값 -> 매개변수 탐색
public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken()); // N명의 학생들
    	int M = Integer.parseInt(st.nextToken()); // M가지 다른 색상의 보석
    	
    	int s = 1;
    	int e = -1;
    	int[] gems = new int[M];
    	for (int i=0; i<M; i++) {
    		gems[i] = Integer.parseInt(br.readLine());
    		e = Math.max(gems[i], e);
    	}
    	
    	int ans = Integer.MAX_VALUE;
    	while (s <= e) {
    		int m = (s + e) / 2;
    		int cnt = 0;
    		for (int gem : gems) {
    			if (gem % m == 0) {
    				cnt += gem / m;
    			} else {
    				cnt += gem / m + 1;
    			}
    		}
    		
    		if (cnt <= N) { // N명 이하 가넝(모든 학생에게 나눠줘야 하는 것이 아님!!!!) -> 더 작은 값도 가능한지 확인
    			ans = m;
    			e = m-1;
    		} else { // N명 넘게 가능 -> 더 큰 값 확인
    			s = m+1;
    		}
    	}
    	
    	System.out.print(ans);
    }
};
