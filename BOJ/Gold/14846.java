import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	
    	int[][][] graph = new int[N+1][N+1][11];
    	StringTokenizer st;
    	for (int i=1; i<N+1; i++) {
    		st = new StringTokenizer(br.readLine());
    		for (int j=1; j<N+1; j++) {
    			int n = Integer.parseInt(st.nextToken());
    			
    			for (int k=1; k<11; k++) {
    				graph[i][j][k] = graph[i-1][j][k] + graph[i][j-1][k] - graph[i-1][j-1][k];
    			}
    			graph[i][j][n]++;
    		}
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	int Q = Integer.parseInt(br.readLine());
    	for (int i=0; i<Q; i++) {
    		st = new StringTokenizer(br.readLine());
    		int x1 = Integer.parseInt(st.nextToken());
    		int y1 = Integer.parseInt(st.nextToken());
    		int x2 = Integer.parseInt(st.nextToken());
    		int y2 = Integer.parseInt(st.nextToken());
    		
    		int cnt = 0;
    		int[] cntArr = new int[11];
    		for (int j=1; j<11; j++) {
    			if (graph[x2][y2][j] - (graph[x1-1][y2][j] + graph[x2][y1-1][j]) + graph[x1-1][y1-1][j] > 0) {
    				cnt++;
    			}
    		}
    		sb.append(cnt + "\n");
    	}
    	System.out.print(sb);
    	
    }    
};
