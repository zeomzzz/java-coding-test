import java.io.*;
import java.util.*;

// N개 중 M개를 고름. 중복 가능. 비내림차순. 사전 순 출력
public class Main {
	
	static StringBuilder sb = new StringBuilder();
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	
    	int[] nums = new int[N];
    	st = new StringTokenizer(br.readLine());
    	for (int i=0; i<N; i++) {
    		nums[i] = Integer.parseInt(st.nextToken());
    	}
    	Arrays.sort(nums);
    	
    	int[] selected = new int[M];
    	backtracking(0, 0, N, M, nums, selected);
    	
    	System.out.print(sb);
    	
    }
    
    static void backtracking(int cur, int start, int N, int M, int[] nums, int[] selected) {
    	
    	if (cur == M) {
    		for (int select : selected) {
    			sb.append(select);
    			sb.append(" ");
    		}
    		sb.append("\n");
    		return;
    	}
    	
    	for (int i=start; i<N; i++) {
    		selected[cur] = nums[i];
    		backtracking(cur+1, i, N, M, nums, selected);
    	}
    	
    }
    
};

// 240505
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[] nums, selected;
	static StringBuilder answer;
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	nums = new int[N];
    	st = new StringTokenizer(br.readLine());
    	for (int i=0; i<N; i++) {
    		nums[i] = Integer.parseInt(st.nextToken());
    	}
    	Arrays.sort(nums);
    	
    	selected = new int[M];
    	answer = new StringBuilder();
    	
    	recur(0, 0);
    	
    	System.out.print(answer);
    }
    
    public static void recur(int cur, int start) {
    	
    	if (cur == M) {
    		StringBuilder sb = new StringBuilder();
    		for (int select : selected) {
    			sb.append(select + " ");
    		}
    		answer.append(sb);
    		answer.append("\n");
    		
    		return;
    	}
    	
    	for (int i=start; i<N; i++) {
    		selected[cur] = nums[i];
    		recur(cur+1, i);
    	}
    }
    
};
