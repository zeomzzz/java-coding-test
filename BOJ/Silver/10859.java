import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	long N = Long.parseLong(br.readLine());
    	
    	if (!checkPrime(N)) {
    		System.out.println("no");
    	} else {
    		long reversed = reverse(N);
    		if (reversed == -1) {
    			System.out.println("no");
    		} else {
    			if (checkPrime(reversed)) {
    				System.out.println("yes");
    			} else {
    				System.out.println("no");
    			}
    		}
    	}
    }
    
    static long reverse(long N) {
    	long[] reverseNums = new long[] {0, 1, 2, -1, -1, 5, 9, -1, 8, 6};
    	
    	long ans = 0;
    	int cnt = 0;
    	while (N > 0) {
    		if (reverseNums[(int)(N % 10)] == -1) {
    			return -1;
    		}
    		
    		ans *= 10;
    		ans += reverseNums[(int)(N%10)];
    		N /= 10;
    	}
    	
    	return ans;
    }
    
    static boolean checkPrime(long N) {
    	long cnt = 0;
    	for (long i=1; i<=Math.pow(N, 0.5); i++) {
    		if (N % i == 0) {
    			if (i * i != N) {
    				cnt+=2;
    			} else {
    				cnt++;
    			}
    		}
    		if (cnt >= 3) return false;
    	}
    	
    	if (cnt == 2) return true;
    	
    	return false;
    }
    
};
