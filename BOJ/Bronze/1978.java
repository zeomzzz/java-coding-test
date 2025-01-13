import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int cnt = 0;
    	for (int i=0; i<N; i++) {
    		int n = Integer.parseInt(st.nextToken());
    		if (checkPrime(n)) cnt++;
    	}
    	
    	System.out.println(cnt);
    }
    
    static boolean checkPrime(int n) {
    	 int cnt = 0;
    	 
    	 for (int i=1; i<=Math.pow(n, 0.5); i++) {
    		 if (n%i == 0) {
    			 if (i*i == n) {
        			 cnt++;
        		 } else {
        			 cnt += 2;
        		 }
    		 }
    		 
    		 if (cnt > 2) break;
    	 }
    	 
    	 if (cnt == 2) {
    		 return true;
    	 } else {
    		 return false;
    	 }
    }
    
};

// 250113
import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int cnt = 0;
        for (int i=0; i<N; i++) {
        	if (isPrime(Integer.parseInt(st.nextToken()))) {
        		cnt++;
        	}
        }
        
        System.out.println(cnt);
    }
    
    public static boolean isPrime(int n) {
    	if (n == 1) {
    		return false;
    	}
    	
    	for (int i=2; i*i<=n; i++) {
    		if (n % i == 0) {
    			return false;
    		}
    	}
    	
    	return true;
    }
    
}

