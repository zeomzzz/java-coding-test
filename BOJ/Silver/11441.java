import java.io.*;
import java.util.*;

public class Main {
	
	static int N, T, a, b;
	static int[] nums;
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	nums = new int[N+1];
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for (int i=1; i<N+1; i++) {
    		nums[i] = nums[i-1] + Integer.parseInt(st.nextToken());
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	T = Integer.parseInt(br.readLine());
    	for (int tc=0; tc<T; tc++) {
    		st = new StringTokenizer(br.readLine());
    		a = Integer.parseInt(st.nextToken());
    		b = Integer.parseInt(st.nextToken());
    		sb.append(nums[b]- nums[a-1]);
    		sb.append("\n");
    	}
    	
    	System.out.print(sb.toString());
    	
    }
    
};
