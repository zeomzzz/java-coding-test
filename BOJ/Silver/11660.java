import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	
    	int[][] sumArr = new int[N+1][N+1];
    	for (int i=1; i<N+1; i++) {
    		st = new StringTokenizer(br.readLine());
    		for (int j=1; j<N+1; j++) {
    			sumArr[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	// 누적합으로 업데이트
    	for (int i=1; i<N+1; i++) {
    		for (int j=1; j<N+1; j++) {
    			sumArr[i][j] += sumArr[i-1][j] + sumArr[i][j-1] - sumArr[i-1][j-1];
    		}
    	}
    	
    	// tc 구하기
    	for (int tc=0; tc<M; tc++) {
    		st = new StringTokenizer(br.readLine());
    		int x1 = Integer.parseInt(st.nextToken());
    		int y1 = Integer.parseInt(st.nextToken());
    		int x2 = Integer.parseInt(st.nextToken());
    		int y2 = Integer.parseInt(st.nextToken());
    		
    		sb.append((sumArr[x2][y2] - (sumArr[x2][y1-1] + sumArr[x1-1][y2]) + sumArr[x1-1][y1-1]) + "\n");
    	}
    	
    	System.out.print(sb);
    	
    }
    
};
