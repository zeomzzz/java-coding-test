import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int N = Integer.parseInt(br.readLine());
    	int[][] paper = new int[101][101];
    	
    	StringTokenizer st;
    	
    	int ans = 0;
    	for (int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine());
    		int x = Integer.parseInt(st.nextToken());
    		int y = Integer.parseInt(st.nextToken());
    		
    		for (int k=0; k<10; k++) {
    			for (int j=0; j<10; j++) {
    				paper[x+k][y+j] = 1;
    			}
    		}
    		
    	}
    	
    	for (int i=0; i<101; i++) {
    		for (int j=0; j<101; j++) {
    			ans += paper[i][j];
    		}
    	}
    	
    	System.out.print(ans);
    	
    }

};
