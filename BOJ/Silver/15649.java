import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken()); // 1 ~ N
    	int M = Integer.parseInt(st.nextToken()); // 길이 M
    	
    	int[] selected = new int[M];
    	boolean[] visited = new boolean[N+1];
    	backtracking(0, N, M, selected, visited);
    }
    
    static void backtracking(int cur, int N, int M, int[] selected, boolean[] visited) {
    	
    	if (cur == M) {
    		StringBuilder sb = new StringBuilder();
    		for (int select : selected) {
    			sb.append(select);
    			sb.append(" ");
    		}
    		System.out.println(sb);
    		return;
    	}
    	
    	for (int i=1; i<=N; i++) {
    		if (visited[i]) continue;
    		
    		selected[cur] = i;
    		visited[i] = true;
    		backtracking(cur+1, N, M, selected, visited);
    		visited[i] = false;
    	}
    }
};

// 240502
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static boolean[] visited;
	static int[] selected;
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	selected = new int[M];
    	visited = new boolean[N+1];
    	
    	recur(0);
    }
    
    public static void recur(int cur) {
    	
    	if (cur == M) {
    		for (int select : selected) {
    			System.out.print(select + " ");
    		}
    		System.out.println();
    		return;
    	}
    	
    	for (int i=1; i<=N; i++) {
    		if (visited[i]) continue;
    		
    		selected[cur] = i;
    		visited[i] = true;
    		recur(cur+1);
    		
    		visited[i] = false;
    	}
    } 
    
};
