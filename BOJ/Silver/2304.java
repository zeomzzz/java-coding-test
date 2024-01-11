import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	
    	int[] columns = new int[1001];
    	StringTokenizer st;
    	for (int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine());
    		int L = Integer.parseInt(st.nextToken());
    		int H = Integer.parseInt(st.nextToken());
    		columns[L] = H;
    	}
    	
    	int[] roof = new int[1001];
    	roof[0] = columns[0];
    	for (int i=1; i<1001; i++) {
    		roof[i] = Math.max(roof[i-1], columns[i]);
    	}
    	
    	roof[1000] = columns[1000];
    	for (int i=999; i>=0; i--) {
    		roof[i] = Math.min(roof[i], Math.max(roof[i+1], columns[i]));
    	}
    	
    	int ans = 0;
    	for (int h : roof) {
    		ans += h;
    	}
    	
    	System.out.print(ans);
    	
    }
    
};

// 240111 : 누적합 풀이
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	int[] columns = new int[1001];
    	
    	StringTokenizer st;
    	// 기둥 높이 입력
    	for (int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine());
    		int L = Integer.parseInt(st.nextToken());
    		int H = Integer.parseInt(st.nextToken());
    		columns[L] = H;
    	}
    	
    	// i까지의 최대 높이
    	int[] prefixMax = new int[1001];
    	prefixMax[1] = columns[1];
    	for (int i=2; i<1001; i++) {
    		prefixMax[i] = Math.max(prefixMax[i-1], columns[i]);
    	}
    	
    	// i이전까지의 최대 높이
    	int[] suffixMax = new int[1001];
    	suffixMax[1000] = columns[1000];
    	for (int i=999; i>0; i--) {
    		suffixMax[i] = Math.max(suffixMax[i+1], columns[i]);
    	}
    	
    	int answer = 0;
    	for (int i=1; i<1001; i++) {
    		answer += Math.min(prefixMax[i], suffixMax[i]);
    	}
    	
    	System.out.print(answer);
    	
    }
    
};
