import java.io.*;
import java.util.*;

// 1~N 중 M개를 고름. 중복 X. 사전 순 출력
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
    	boolean[] visited = new boolean[N];
    	backtracking(0, N, M, nums, selected, visited);
    	
    	System.out.print(sb);
    	
    }
    
    static void backtracking(int cur, int N, int M, int[] nums, int[] selected, boolean[] visited) {
    	
    	if (cur == M) {
    		for (int select : selected) {
    			sb.append(select);
    			sb.append(" ");
    		}
    		sb.append("\n");
    		return;
    	}
    	
    	for (int i=0; i<N; i++) {
    		if (visited[i]) continue;
    		
    		selected[cur] = nums[i];
    		visited[i] = true;
    		backtracking(cur+1, N, M, nums, selected, visited);
    		visited[i] = false;
    	}
    }
    
};
