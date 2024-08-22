import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	
    	// j가 N 이하이므로 N+1 크기의 누적합 배열 만들기
    	int[] prefixSum = new int[N+1];
    	st = new StringTokenizer(br.readLine());
    	for (int idx=1; idx<=N; idx++) {
    		prefixSum[idx] = prefixSum[idx-1] + Integer.parseInt(st.nextToken());
    	}
    	
    	for (int tc=0; tc<M; tc++) {
    		st = new StringTokenizer(br.readLine());
    		int i = Integer.parseInt(st.nextToken());
    		int j = Integer.parseInt(st.nextToken());
    		
    		sb.append(prefixSum[j] - prefixSum[i-1] + "\n");
    	}
    	
    	System.out.print(sb);
    }
    
};

// 240822
import java.util.*;
import java.io.*;

class Main {
	
	static int N, M;
	static int[] prefix_sum;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	prefix_sum = new int[N+1];
    	
    	st = new StringTokenizer(br.readLine());
    	for (int i=1; i<=N; i++) {
    		prefix_sum[i] += prefix_sum[i-1] + Integer.parseInt(st.nextToken());
    	}
        
    	StringBuilder sb = new StringBuilder();
    	int a, b = 0;
    	for (int i=0; i<M; i++) {
    		st = new StringTokenizer(br.readLine());
    		a = Integer.parseInt(st.nextToken());
    		b = Integer.parseInt(st.nextToken());
    		
    		sb.append(prefix_sum[b] - prefix_sum[a-1] + "\n");
    	}
    	
    	System.out.print(sb);
    	
    }
    
};
