import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	long a = Long.parseLong(st.nextToken());
    	long d = Long.parseLong(st.nextToken());
    	long q = Long.parseLong(br.readLine());
    	
    	for (long tc=0; tc<q; tc++) {
    		st = new StringTokenizer(br.readLine());
    		long n = Long.parseLong(st.nextToken());
    		long l = Long.parseLong(st.nextToken());
    		long r = Long.parseLong(st.nextToken());
    		
    		if (n == 1) {
    			sb.append(sum(a, d, r) - sum(a, d, l-1)+"\n");
    		} else {
    			if ((r-l+1)%2 == 0) {
    				sb.append(gcd(a, d)+"\n");
    			} else {
    				if (l == r) {
    					sb.append(a+(l-1)*d+"\n");
    				} else {
    					sb.append(gcd(a+(l-1)*d, gcd(a, d))+"\n");
    				}
    				
    			}
    		}
    	}
    	System.out.println(sb);
    }
    
    static long sum(long a, long d, long i) {
    	return a*i + (i*(i-1)/2)*d;
    }
    
    static long gcd(long a, long b) {
    	
    	// a<=b 로 설정
    	if (a > b) {
    		long tmp = a;
    		a = b;
    		b = tmp;
    	}
    	
    	if (a == 0) {
    		return b;
    	}
    	
    	while (b%a != 0) {
    		b %= a;
    		
    		long tmp = a;
    		a = b;
    		b = tmp;
    	}
    	
    	return a;
    }
    
};
