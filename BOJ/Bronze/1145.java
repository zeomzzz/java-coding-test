import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int[] nums = new int[5];
    	
    	for (int i=0; i<5; i++) {
    		nums[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	int ans = 1;
    	while (true) {
    		int cnt = 0;
    		
    		for (int i=0; i<5; i++) {
    			if (ans/nums[i] >= 1 && ans%nums[i] == 0) {
    				cnt++;
    			}
    		}
    		
    		if (cnt >= 3) {
    			break;
    		} else {
    			ans++;
    		}
    	}
    	
    	System.out.print(ans);
    	
    }

};

// 240425
import java.io.*;
import java.util.*;

// 100 * 100 * 100 = 1,000,000 < 100,000,000

public class Main {
	
	static int A, B, C, D, E;
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	A = Integer.parseInt(st.nextToken());
    	B = Integer.parseInt(st.nextToken());
    	C = Integer.parseInt(st.nextToken());
    	D = Integer.parseInt(st.nextToken());
    	E = Integer.parseInt(st.nextToken());
    	
    	int cnt = 0;
    	for (int i=0; i<1000000; i++) {
    		cnt = 0;
    		if (i>=A && i%A == 0) cnt++;
    		if (i>=B && i%B == 0) cnt++;
    		if (i>=C && i%C == 0) cnt++;
    		if (i>=D && i%D == 0) cnt++;
    		if (i>=E && i%E == 0) cnt++;
    		
    		if (cnt >= 3) {
    			System.out.print(i);
    			break;
    		}
    	}
    	
    }
    
};

