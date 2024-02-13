import java.io.*;
import java.util.*;

// 백트래킹으로 확인
public class Main {
	
	static int max = Integer.MIN_VALUE;
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine()); // N+1일에 퇴사
    	int[][] counsels = new int[N][2];
    	
    	StringTokenizer st;
    	for (int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine());
    		counsels[i][0] = Integer.parseInt(st.nextToken());
    		counsels[i][1] = Integer.parseInt(st.nextToken());
    	}
    	
    	backtracking(0, 0, N, counsels);
    	
    	System.out.print(max);
    }
    
    static void backtracking(int cur, int income, int N, int[][] counsels) {
    	
    	if (cur == N) {
    		max = Math.max(max, income);
    		return;
    	}
    	
    	// 이번거 선택
    	if (cur + counsels[cur][0] - 1 < N) {
    		backtracking(cur+counsels[cur][0], income+counsels[cur][1], N, counsels);
    	}
    	// 이번거 선택 안함
    	backtracking(cur+1, income, N, counsels);
    	
    }
    
};
