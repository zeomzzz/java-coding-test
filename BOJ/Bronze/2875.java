import java.io.*;
import java.util.*;

// 100(전체 여학생 수) * 100(전체 남학생 수) < 1억 -> 완탐 가능
public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken()); // 전체 여학생 0 ~ 100
    	int M = Integer.parseInt(st.nextToken()); // 전체 남학생 0 ~ 100
    	int K = Integer.parseInt(st.nextToken());
    	
    	int ans = 0;
    	for (int f=0; f<=N; f++) {
    		for (int m=0; m<=M; m++) {
    			if (f == 2*m && N+M-f-m >= K) {
    				ans = Math.max(ans, Math.min(f, m));
    			}
    		}
    	}
    	
    	System.out.print(ans);
    	
    }

}

// 240425
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, K;
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	K = Integer.parseInt(st.nextToken());
    	
    	int ans = 0;
    	
    	for (int n=0; n<=N; n++) { // 100
    		for (int m=0; m<=M; m++) { // 100
    			if (N+M-n-m != K) continue;
    			ans = Math.max(Math.min(n/2, m), ans);
    		}
    	}
    	
    	System.out.print(ans);
    }
    
};
