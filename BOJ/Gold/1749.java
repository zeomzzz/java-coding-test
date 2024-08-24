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

// 240824
import java.util.*;
import java.io.*;

class Main {
	
	static int N, M;
	static long[][] prefixSum;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        prefixSum = new long[N+1][M+1];
        
        long tmp = 0;
        for (int i=1; i<=N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j=1; j<=M; j++) {
        		tmp = Long.parseLong(st.nextToken());
        		prefixSum[i][j] = tmp + prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1];
        	}
        }
        
        long answer = Long.MIN_VALUE;
        tmp = 0;
        for (int x1=1; x1<=N; x1++) {
        	for (int y1=1; y1<=M; y1++) {
        		
        		for (int x2=1; x2<=x1; x2++) {
        			for (int y2=1; y2<=y1; y2++) {
        				
        				tmp = prefixSum[x1][y1] - prefixSum[x2-1][y1] - prefixSum[x1][y2-1] + prefixSum[x2-1][y2-1];
        				answer = (long) Math.max(tmp, answer);
        				
        			}
        		}
        		
        	}
        }
        
        System.out.print(answer);
    }
    
};
