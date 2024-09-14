import java.io.*;
import java.util.*;

public class Main {
	
	static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken()); // 1~N
    	int M = Integer.parseInt(st.nextToken()); // M개
    	
    	int[] selected = new int[M];
    	backtracking(0, N, M, selected);
    	System.out.print(sb);
    }
    
    static void backtracking(int cur, int N, int M, int[] selected) {
    	if (cur == M) {
    		StringBuilder tmpSb = new StringBuilder();
    		for (int select : selected) {
    			tmpSb.append(select);
    			tmpSb.append(" ");
    		}
    		sb.append(tmpSb + "\n");
    		return;
    	}
    	
    	for (int i=1; i<=N; i++) {
    		selected[cur] = i;
    		backtracking(cur+1, N, M, selected);
    	}
    }
    
};

// 240502
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[] selected;
	static StringBuilder answer;
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	answer = new StringBuilder();
    	
    	selected = new int[M];
    	
    	recur(0);
    	System.out.print(answer);
    }
    
    public static void recur(int cur) {
    	
    	if (cur == M) {
    		StringBuilder sb = new StringBuilder();
    		for (int select : selected) {
    			sb.append(select + " ");
    		}
    		sb.append("\n");
    		answer.append(sb);
    		return;
    	}
    	
    	for (int i=1; i<=N; i++) {
    		selected[cur] = i;
    		recur(cur+1);
    	}
    }
    
};

// 240915
import java.util.*;
import java.io.*;

class Main {
	
	static int N, M;
	static int[] selected;
	static StringBuilder sb;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
     
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M];
        sb = new StringBuilder();
        
        recur(0);
        
        System.out.print(sb);
    }
    
    public static void recur(int cur) {
    	
    	if (cur == M) {
    		
    		for (int select : selected) {
    			sb.append(select + " ");
    		}
    		sb.append("\n");
    		
    		return;
    	}
    	
    	for (int i=1; i<=N; i++) {
    		selected[cur] = i;
    		recur(cur+1);
    	}
    	
    }
    
};
