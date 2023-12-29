import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	
    	int[] columns = new int[1001];
    	StringTokenizer st;
    	for (int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine());
    		int L = Integer.parseInt(st.nextToken());
    		int H = Integer.parseInt(st.nextToken());
    		columns[L] = H;
    	}
    	
    	int[] roof = new int[1001];
    	roof[0] = columns[0];
    	for (int i=1; i<1001; i++) {
    		roof[i] = Math.max(roof[i-1], columns[i]);
    	}
    	
    	roof[1000] = columns[1000];
    	for (int i=999; i>=0; i--) {
    		roof[i] = Math.min(roof[i], Math.max(roof[i+1], columns[i]));
    	}
    	
    	int ans = 0;
    	for (int h : roof) {
    		ans += h;
    	}
    	
    	System.out.print(ans);
    	
    }
    
};
