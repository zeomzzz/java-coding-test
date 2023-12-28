import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int[] nums = new int[5];
    	
    	for (int i=0; i<5; i++) {
    		nums[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	int ans = 1;
    	while (true) {
    		int cnt = 0;
    		
    		for (int i=0; i<5; i++) {
    			if (ans/nums[i] >= 1 && ans%nums[i] == 0) {
    				cnt++;
    			}
    		}
    		
    		if (cnt >= 3) {
    			break;
    		} else {
    			ans++;
    		}
    	}
    	
    	System.out.print(ans);
    	
    }

};
