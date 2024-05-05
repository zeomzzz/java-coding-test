import java.io.*;
import java.util.*;

// 8! = 40320

public class Main {
	
	static int N, answer;
	static int[] nums, selected;
	static boolean[] visited;
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	
    	nums = new int[N];
    	st = new StringTokenizer(br.readLine());
    	for (int i=0; i<N; i++) {
    		nums[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	visited = new boolean[N];
    	selected = new int[N];
    	answer = 0;
    	
    	recur(0);
    	
    	System.out.print(answer);
    }
    
    public static int cal() {
    	
    	int result = 0;
    	for (int i=0; i<N-1; i++) {
    		result += Math.abs(selected[i]-selected[i+1]);
    	}
    	
    	return result;
    }
    
    public static void recur(int cur) {
    	
    	if (cur == N) {
    		answer = Math.max(answer, cal());
    		return;
    	}
    	
    	for (int i=0; i<N; i++) {
    		if (visited[i]) continue;
    		
    		visited[i] = true;
    		selected[cur] = nums[i];
    		recur(cur+1);
    		
    		visited[i] = false;
    	}
    	
    }
    
};
