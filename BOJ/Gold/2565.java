import java.io.*;
import java.util.*;

// 가장 긴 증가하는 부분 수열의 길이를 찾고
// 전체 길이에서 빼기
public class Main {
	
	static int n;
	static int[][] lines;
	static int[] nums, dp;
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	n = Integer.parseInt(br.readLine());
    	lines = new int[n][2];
    	StringTokenizer st;
    	for (int i=0; i<n; i++) {
    		st = new StringTokenizer(br.readLine());
    		lines[i][0] = Integer.parseInt(st.nextToken());
    		lines[i][1] = Integer.parseInt(st.nextToken());
    	}
    	Arrays.sort(lines, (o1, o2) -> o1[0] - o2[0]);
    	
    	nums = new int[n];
    	for (int i=0; i<n; i++) nums[i] = lines[i][1];
    	
    	dp = new int[n];
    	Arrays.fill(dp, 1);
    	int max = 0;
    	
    	for (int i=0; i<n; i++) {
    		for (int j=0; j<i; j++) {
    			if (nums[j] < nums[i]) {
    				dp[i] = Math.max(dp[i], dp[j] + 1);
    				max = Math.max(max, dp[i]);
    			}
    		}
    	}
    	
    	System.out.print(n - max);
    	
    }
    
};
