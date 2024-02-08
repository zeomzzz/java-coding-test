import java.io.*;
import java.util.*;

// 백트래킹으로 확인
public class Main {
	
	static long min = 1000000000;
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	int N = Integer.parseInt(br.readLine());
    	long[][] foods = new long[N][2];
    	for (int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine());
    		foods[i][0] = Long.parseLong(st.nextToken());
    		foods[i][1] = Long.parseLong(st.nextToken());
    	}
    	
    	backtracking(0, 0, N, 1, 0, foods);
    	
    	System.out.print(min);
    }
    
    static void backtracking(int cur, int start, int N, long sour, long bitter, long[][] foods) {
    	
    	if (start == N) {
    		if (cur != 0) min = Math.min(min, Math.abs(sour - bitter));
    		return;
    	}
    	
    	// 선택할 때
    	backtracking(cur+1, start+1, N, sour*foods[start][0], bitter+foods[start][1], foods);
    	// 선택 안할 때
    	backtracking(cur, start+1, N, sour, bitter, foods);
    }
    
};
