import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	
    	// 10**6 이하의 소수를 구하고, 그 소수들로 숫자가 나눠지지 않으면 ok
    	int[] primes = new int[1000001];
    	primes[0] = -1;
    	primes[1] = -1;
    	
    	for (int i=2; i<=1000000; i++) {
    		if (primes[i] == 0) {
    			for (int j=i+i; j<=1000000; j+=i) {
    				primes[j] = -1;
    			}
    		}
    	}
    	
    	List<Integer> primeLst = new ArrayList<>();
    	for (int i=2; i<=1000000; i++) {
    		if (primes[i] == 0) primeLst.add(i);
    	}
    	
    	for (int i=0; i<N; i++) {
    		boolean flag = true;
    		long input = Long.parseLong(br.readLine());
    		for (int prime : primeLst) {
    			if (input % (long)prime == 0L) {
    				flag = false;
    				break;
    			}
    		}
    		
    		if (flag) {
    			System.out.println("YES");
    		} else {
    			System.out.println("NO");
    		}
    	}
    	
    }
    
};

// 240426
import java.io.*;
import java.util.*;

// 암호의 조건
// - 모든 소인수가 10^6보다 큰 수
// -> 소인수가 10^6 이하면 안됨
// -> 10^6 이하의 소수가 인수이면 안됨

public class Main {
	
	static int N;
	static boolean[] isPrimes;
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(br.readLine());
    	
    	// 10^6 이하의 소수 구하기
    	isPrimes = new boolean[1000001];
    	Arrays.fill(isPrimes, true);
    	isPrimes[0] = false;
    	isPrimes[1] = false;
    	for (int i=2; i<=1000000; i++) {
    		for (int j=i+i; j<=1000000; j+=i) {
    			isPrimes[j] = false;
    		}
    	}
    	
    	long S = 0;
    	for (int i=0; i<N; i++) {
    		S = Long.parseLong(br.readLine());
    		if (isProper(S)) System.out.println("YES");
    		else System.out.println("NO");
    	}
    	
    }
    
    static boolean isProper(long S) {
    	for (int i=2; i<=1000000; i++) {
    		if (isPrimes[i]) {
    			if (S % (long) i == 0) {
    				return false;
    			}
    		}
    	}
    	
    	return true;
    }
    
};
