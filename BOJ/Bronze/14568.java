import java.io.*;

// N <= 100 이므로 100*100*100 < 1억 -> 1초에 가능
public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	
    	int cnt = 0;
    	
    	for (int i=0; i<=N; i++) { // 택희
    		for (int j=0; j<=N; j++) { // 영훈
    			for (int k=0; k<=N; k++) { // 남규
    				if (i+j+k == N && k-j >= 2 && i*j*k != 0 && i%2 == 0) {
    					cnt++;
    				}
    			}
    		}
    	}
    	
    	System.out.println(cnt);
    	
    }

}

// 240425
import java.io.*;
import java.util.*;

// 100 * 100 * 100 = 1,000,000 < 100,000,000 

public class Main {
	
	static int N;
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(br.readLine());
    	
    	int ans = 0;
    	
    	for (int a=1; a<=N; a++) { // 택희
    		for (int b=1; b<=N; b++) { // 영훈
    			for (int c=1; c<=N; c++) { // 남규
    				if (a+b+c != N) continue;
    				if (c < b+2) continue;
    				if (a%2 == 1) continue;
    				ans++;
    			}
    		}
    	}
    	
    	System.out.print(ans);
    }
    
};
