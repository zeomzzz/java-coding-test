import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	int[][] cows = new int[N][2];
    	
    	StringTokenizer st;
    	// 입력
    	for (int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine());
    		cows[i][0] = Integer.parseInt(st.nextToken());
    		cows[i][1] = Integer.parseInt(st.nextToken());
    	}
    	
    	int ans = 0;
    	// 제외할 소 선택
    	for (int i=0; i<N; i++) {
    		int[] visited = new int[1002];
    		for (int j=0; j<N; j++) {
    			if (i != j) {
    				for (int idx=cows[j][0]; idx<cows[j][1]; idx++) {
    					visited[idx] = 1;
    				}
    			}
    		}
    		
    		int cnt = 0;
    		for (int j=0; j<=1001; j++) {
    			cnt += visited[j];
    		}
    		
    		ans = Math.max(ans, cnt);
    	}
    	
    	System.out.print(ans);
    	
    }

};
