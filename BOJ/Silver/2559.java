import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken()); // 온도를 측정한 전체 날짜 수
    	int K = Integer.parseInt(st.nextToken()); // 합을 구할 연속적인 날짜 수
    	
    	int[] temperatures = new int[N+1];
    	st = new StringTokenizer(br.readLine());
    	for (int i=1; i<=N; i++) { // 100,000
    		temperatures[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	int[] prefixSum = new int[N-K+2];
    	for (int i=1; i<=K; i++) {
    		prefixSum[1] += temperatures[i];
    	}
    	
    	int answer = prefixSum[1];
    	for (int i=2; i<N-K+2; i++) {
    		prefixSum[i] = prefixSum[i-1] - temperatures[i-1] + temperatures[i-1+K];
    		answer = Math.max(answer, prefixSum[i]);
    	}
    	
    	System.out.println(answer);
    }
    
};
