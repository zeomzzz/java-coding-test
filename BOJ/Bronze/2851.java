import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int sum = 0;
    	int ans = 0;
    	int gap = Integer.MAX_VALUE;
    	
    	for (int i=0; i<10; i++) {
    		sum += Integer.parseInt(br.readLine());
    		if (Math.abs(sum-100) <= gap) {
    			gap = Math.abs(sum-100);
    			ans = sum;
    		}
    	}
    	
    	System.out.println(ans);
    	
    }

}

// 240425
import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int sum = 0;
    	int gap = 100;
    	int ans = 0;
    	for (int i=0; i<10; i++) {
    		sum += Integer.parseInt(br.readLine());
    		if (Math.abs(sum - 100) > gap) continue;
    		gap = Math.abs(sum - 100);
    		ans = Math.max(ans, sum);
    	}
    	
    	System.out.print(ans);
    }
    
};
