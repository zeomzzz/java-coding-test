/*
 * 1. 완탐
 * 
 */
import java.util.*;
import java.io.*;

class Main {
	
	static int N, K, max;
	static int[] A, selected;
	static int[][] R, M;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); // 캔의 종류
        K = Integer.parseInt(st.nextToken()); // 날 수
        max = Integer.MIN_VALUE;
        selected = new int[N];
        
        st = new StringTokenizer(br.readLine());
        A = new int[N];
        for (int i=0; i<N; i++) {
        	A[i] = Integer.parseInt(st.nextToken());
        }
        
        R = new int[K][N];
        M = new int[K][N];
        for (int i=0; i<K; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j=0; j<N; j++) {
        		R[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        for (int i=0; i<K; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j=0; j<N; j++) {
        		M[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        recur(0, 0);
        
        System.out.print(max);
    }
    
    public static void recur(int cur, int sum) {
    	
    	if (cur == K) {
    		max = Math.max(max, sum);
    		return;
    	}
    	
    	// 랑이 선택
    	for (int i=0; i<N; i++) {
    		if (selected[i] + 1 <= A[i]) {
    			selected[i]++;
    			
    			// 메리 선택
    			for (int j=0; j<N; j++) {
    				if (selected[j]+1 <= A[j]) {
    					selected[j]++;
    					
    					recur(cur+1, sum+R[cur][i]+M[cur][j]);
    					
    					// 원복
    					selected[j]--;
    				}
    			}
    			
				// 원복
				selected[i]--;
    		}
    	}
    	
    }
    
};
