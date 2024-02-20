import java.io.*;
import java.util.*;

// 1. 백트래킹으로 짠다.
// 2. return 방식으로 바꾼다.
// 3. dp로 바꾼다.
public class Main {
	
	static int N;
	static int[][] nums;
	static int max;
	static int min;
	static int[][] dpMax;
	static int[][] dpMin;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	nums = new int[N+1][3];
    	StringTokenizer st;
    	
    	for (int i=1; i<N+1; i++) {
    		st = new StringTokenizer(br.readLine());
    		for (int j=0; j<3; j++) {
    			nums[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	dpMax = new int[N+1][3];
    	dpMin = new int[N+1][3];
    	for (int[] tmp : dpMax) Arrays.fill(tmp, Integer.MIN_VALUE);
    	for (int[] tmp : dpMin) Arrays.fill(tmp, Integer.MAX_VALUE);
    	
    	max = recur(0, 1);
    	min = recur2(0, 1);
    	
    	System.out.printf("%d %d", max, min);
    	
    }
    
    static int recur(int cur, int idx) { //, int score) { // score를 return
    	
    	if (idx < 0 || idx > 2) return -10000;
    	
    	if (cur == N+1) {
    		return 0;
    	}
    	
    	if (dpMax[cur][idx] != Integer.MIN_VALUE) return dpMax[cur][idx];
    	
    	return dpMax[cur][idx] = Math.max(Math.max(recur(cur+1, idx)+nums[cur][idx], recur(cur+1, idx-1)+nums[cur][idx]), recur(cur+1, idx+1)+nums[cur][idx]);
    }

    static int recur2(int cur, int idx) { //, int score) { // score를 return
    	
    	if (idx < 0 || idx > 2) return 9000000;
    	
    	if (cur == N+1) {
    		return 0;
    	}
    	
    	if (dpMin[cur][idx] != Integer.MAX_VALUE) return dpMin[cur][idx];
    	
    	return dpMin[cur][idx] = Math.min(Math.min(recur2(cur+1, idx)+nums[cur][idx], recur2(cur+1, idx-1)+nums[cur][idx]), recur2(cur+1, idx+1)+nums[cur][idx]);
    }
};
