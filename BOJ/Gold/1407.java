import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	long A = Long.parseLong(st.nextToken());
    	long B = Long.parseLong(st.nextToken());
    	
    	System.out.print(function(B) - function(A-1));
    	
    }
    
    static long function(long n) {
    	
    	long sum = 0;
    	long tmp = n;
    	
    	for (long i=0; (long)Math.pow(2, i)<=n; i++) {
    		if (tmp%2 == 1) {
    			sum += ((tmp/2) + 1) * (long)Math.pow(2, i); 
    		} else {
    			sum += (tmp/2) * (long)Math.pow(2, i);
    		}
    		tmp /= 2;
    	}
    	
    	return sum;
    }
    
};
