import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken()); // 1~N
    	int M = Integer.parseInt(st.nextToken()); // M
    	
    	int[] selected = new int[M];
    	backtracking(0, 1, N, M, selected);
    }
    
    static void backtracking(int cur, int start, int N, int M, int[] selected) {
    	
    	if (cur == M) { // M개 다 고름
    		StringBuilder sb = new StringBuilder();
    		for (int select : selected) {
    			sb.append(select);
    			sb.append(" ");
    		}
    		System.out.println(sb);
    		return;
    	}
    	
    	for (int i=start; i<=N; i++) {
    		selected[cur] = i;
    		backtracking(cur+1, i+1, N, M, selected);
    	}
    }
    
};
