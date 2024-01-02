import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	long N = Long.parseLong(br.readLine());
    	
    	List<Long> gems = new ArrayList<>();
    	
    	for (long i=2; i<=Math.pow(N, 0.5); i++) {
    		while(N % i == 0) {
    			gems.add(i);
    			N /= i;
    		}
    	}
    	
    	if (N != 1) {
    		gems.add(N);
    	}
    	
    	System.out.println(gems.size());
    	for (long gem : gems) {
    		System.out.printf("%d ", gem);
    	}
    }
    
};
