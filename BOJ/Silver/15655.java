import java.io.*;
import java.util.*;

// 1~N 중 M개를 고름. 중복 X. 오름차순. 사전 순 출력
public class Main {
	
	static StringBuilder sb = new StringBuilder();
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken()); // N개 자연수 중
    	int M = Integer.parseInt(st.nextToken()); // M개를 뽑음
    	
    	st = new StringTokenizer(br.readLine());
    	int[] nums = new int[N];
    	for (int i=0; i<N; i++) {
    		nums[i] = Integer.parseInt(st.nextToken());
    	}
    	Arrays.sort(nums);
    	
    	int[] selected = new int[M];
    	backtracking(0, 0, N, M, selected, nums);
    	
    	System.out.print(sb);
    }
    
    static void backtracking(int cur, int start, int N, int M, int[] selected, int[] nums) {
    	
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
    		backtracking(cur+1, i+1, N, M, selected, nums);
    	}
    	
    }
    
};

// 240505
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[] selected, nums;
	static StringBuilder answer;
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	selected = new int[M];
    	answer = new StringBuilder();
    	
    	st = new StringTokenizer(br.readLine());
    	nums = new int[N];
    	for (int i=0; i<N; i++) {
    		nums[i] = Integer.parseInt(st.nextToken());
    	}
    	Arrays.sort(nums);
    	
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
    		recur(cur+1, i+1);
    	}
    	
    }
    
};
