import java.io.*;
import java.util.*;

// 백트래킹으로 확인
public class Main {
	
	static int answer = 0;
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken()); // 정수의 개수
    	long S = Long.parseLong(st.nextToken()); // 합
    	
    	st = new StringTokenizer(br.readLine());
    	long[] nums = new long[N];
    	for (int i=0; i<N; i++) {
    		nums[i] = Long.parseLong(st.nextToken());
    	}
    	Arrays.sort(nums);
    	backtracking(0, 0, 0, S, N, nums);
    	
    	System.out.print(answer);
    	
    }
    
    static void backtracking(int cur, int start, long sum, long target, int N, long[] nums) {
    	
    	if (cur != 0 && sum == target) {
    		answer++;
    	}
    	
    	for (int i=start; i<N; i++) {
    		backtracking(cur+1, i+1, sum+nums[i], target, N, nums);
    	}
    }
    
};
