import java.io.*;
import java.util.*;

// 500 * 500 < 1억 -> 완탐 가능
public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	
    	int cnt = 0;
    	for (int B=1; B<=500; B++) {
    		for (int A=1; A<=500; A++) {
    			if (B <= A && A*A - B*B == N) {
    				cnt++;
    			}
    		}
    	}
    	
    	System.out.println(cnt);
    	
    }

}

// 240425
import java.io.*;
import java.util.*;

// A * A = B * B + N
// 500 * 500 < 100,000,000

public class Main {
	
	static int N;
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(br.readLine());
    	
    	int ans = 0;
    	
    	for (int a=1; a<=500; a++) {
    		for (int b=1; b<=500; b++) {
    			if (a*a == b*b + N) ans++;
    		}
    	}
    	
    	System.out.print(ans);
    }
    
};
