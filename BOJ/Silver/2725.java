import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int C = Integer.parseInt(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	
    	int[] dp = new int[1001];
    	
    	int tmp = 0;
    	for (int i=1; i<=1000; i++) {
    		for (int j=0; j<i; j++) {
    			if (gcd(j, i) == 1) {
    				tmp++;
    			}
    		}
    		dp[i] = tmp*2 + 1;
    	}
    	
    	for (int tc=0; tc<C; tc++) {
    		int N = Integer.parseInt(br.readLine());
    		sb.append(dp[N] + "\n");
    	}
    	
    	System.out.println(sb);
    }
    
    static int gcd(int i, int j) { // i < j
    	
    	if (i==0) {
    		if (j == 1) {
    			return 1;
    		}
    		return 0;
    	}
    	
    	while (j%i != 0) {
    		j %= i;
    		
    		int tmp = i;
    		i = j;
    		j = tmp;
    	}
    	
    	return i;
    }
    
};
