import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[] A;
	static int[] prev;
	static int[] dp;
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	A = new int[N];
    	for (int i=0; i<N; i++) {
    		A[i] = Integer.parseInt(st.nextToken());
    	}
    	dp = new int[N];
    	Arrays.fill(dp, 1);
    	prev = new int[N];
    	Arrays.fill(prev, -1);
    	
    	for (int i=0; i<N; i++) {
    		for (int j=0; j<i; j++) {
    			if (A[j] < A[i]) {
    				if (dp[i] < dp[j] + 1) {
    					dp[i]= dp[j] + 1;
    					prev[i] = j;
    				}
    			}
    		}
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	int max = -1;
    	int idx = 0;
    	for (int i=0; i<N; i++) {
    		if (max < dp[i]) {
    			max = dp[i];
    			idx = i; // 역추적을 시작할 값의 idx를 찾기
    		}
    	}
    	sb.append(max);
    	sb.append("\n");
    	List<Integer> lst = new ArrayList<>();
    	
    	while (idx != -1) {
    		lst.add(A[idx]);
    		idx = prev[idx];
    	}
    	
    	Collections.reverse(lst);
    	for (int l : lst) {
    		sb.append(l);
    		sb.append(" ");
    	}
    	
    	System.out.print(sb);
    }
    
};
