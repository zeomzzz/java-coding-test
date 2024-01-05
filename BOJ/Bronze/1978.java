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
