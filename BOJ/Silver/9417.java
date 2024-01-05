import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	
    	for (int i=0; i<N; i++) {
    		int max = Integer.MIN_VALUE;
    		String[] nums = (br.readLine()).split(" ");
    		int l = nums.length;
    		
    		for (int k=0; k<l-1; k++) {
    			for (int j=k+1; j<l; j++) {
    				max = Math.max(max, get_gcd(nums[k], nums[j]));
    			}
    		}
    		
    		System.out.println(max);
    	}
    }
    
    static int get_gcd(String a, String b) {
    	int n = Integer.parseInt(a);
    	int m = Integer.parseInt(b);
    	
    	if (n > m) {
    		int tmp = n;
    		n = m;
    		m = tmp;
    	}
    	
    	int gcd = 0;
    	if (n == 0) {
    		gcd = m;
    	} else {
    		while (m%n != 0) {
        		m %= n;
        		
        		int tmp = n;
        		n = m;
        		m = tmp;
        	}
    		gcd = n;
    	}
    	
    	return gcd;
    	
    }
    
    
};
