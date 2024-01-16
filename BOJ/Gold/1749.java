import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	
    	int[][] intSum = new int[N+1][M+1];
    	for (int r=1; r<N+1; r++) {
    		st = new StringTokenizer(br.readLine());
    		for (int c=1; c<M+1; c++) {
    			intSum[r][c] = Integer.parseInt(st.nextToken()) + intSum[r-1][c] + intSum[r][c-1] - intSum[r-1][c-1];
    		}
    	}
    	
    	int max = Integer.MIN_VALUE;
    	for (int r1=1; r1<N+1; r1++) {
    		for (int r2=r1; r2<N+1; r2++) {
    			for (int c1=1; c1<M+1; c1++) {
    				for (int c2=c1; c2<M+1; c2++) {
    					max = Math.max(max, intSum[r2][c2] - (intSum[r1-1][c2] + intSum[r2][c1-1]) + intSum[r1-1][c1-1]);
    				}
    			}
    		}
    	}
    	System.out.print(max);
    }    
};
