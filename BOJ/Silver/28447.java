import java.io.*;
import java.util.*;

public class Main {
	
	static int N, K, answer;
	static int[][] tastes;
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	K = Integer.parseInt(st.nextToken());
    	
    	tastes = new int[N][N];
    	for (int r=0; r<N; r++) {
    		st = new StringTokenizer(br.readLine());
    		for (int c=0; c<N; c++) {
    			tastes[r][c] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	int[] selected = new int[K];
    	answer = Integer.MIN_VALUE;
    	recur(0, 0, selected);
    	
    	System.out.print(answer);
    	
    }
    
    public static void recur(int cur, int cnt, int[] selected) {
    	
    	if (cnt == K) {
    		// 맛 계산
    		calTaste(selected);
    		return;
    	}
    	
    	if (cur == N) {
    		return;
    	}
    	
    	// cur번째 고름
    	selected[cnt] = cur;
    	recur(cur+1, cnt+1, selected);
    	
    	// 고르지 않음
    	recur(cur+1, cnt, selected);
    	
    }
    
    public static void calTaste(int[] selected) {
    	
    	int taste = 0;
    	
    	for (int r=0; r<K; r++) {
    		for (int c=r; c<K; c++) {
    			taste += tastes[selected[r]][selected[c]];
    		}
    	}
    	
    	answer = Math.max(taste, answer);
    	
    }
    
};
