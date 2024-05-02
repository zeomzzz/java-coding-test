import java.io.*;
import java.util.*;

// 1~N 중에 M개를 고름. 오름 차순으로 중복 가능. 사전순으로 출력
public class Main {

	static StringBuilder sb = new StringBuilder();
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken()); // 1~N
    	int M = Integer.parseInt(st.nextToken()); // M
    	
    	int[] selected = new int[M];
    	backtracking(0, 1, N, M, selected);
    	
    	System.out.print(sb);
    }
    
    static void backtracking(int cur, int start, int N, int M, int[] selected) {
    	if (cur == M) {
    		for (int select : selected) {
    			sb.append(select);
    			sb.append(" ");
    		}
    		sb.append("\n");
    		return;
    	}
    	
    	for (int i=start; i<=N; i++) {
    		selected[cur] = i;
    		backtracking(cur+1, i, N, M, selected);
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
    	
    	recur(0, 1);
    	
    	System.out.print(answer);
    }
    
    public static void recur(int cur, int start) {
    	
    	if (cur == M) {
    		StringBuilder sb = new StringBuilder();
    		for (int select : selected) {
    			sb.append(select + " ");
    		}
    		sb.append("\n");
    		answer.append(sb);
    		return;
    	}
    	
    	for (int i=start; i<=N; i++) {
    		selected[cur] = i;
    		recur(cur+1, i);
    	}
    }
    
};
