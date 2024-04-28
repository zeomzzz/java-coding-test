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

// 240428
import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static boolean[][] paper;
	
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	N = Integer.parseInt(br.readLine());
    	paper = new boolean[100][100];
    	
//    	StringTokenizer st = new StringTokenizer(br.readLine());
    	StringTokenizer st;
    	int left = 0;
    	int under = 0;
    	for (int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine());
    		left = Integer.parseInt(st.nextToken());
    		under = Integer.parseInt(st.nextToken());
    		
    		for (int r=left; r<left+10; r++) {
    			for (int c=under; c<under+10; c++) {
    				paper[r][c] = true;
    			}
    		}
    	}
    	
    	int ans = 0;
    	for (int r=0; r<100; r++) {
    		for (int c=0; c<100; c++) {
    			if (paper[r][c]) ans++;
    		}
    	}
    	
    	System.out.print(ans);
    	
    }
    
};
