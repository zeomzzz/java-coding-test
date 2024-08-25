// 1억 = 100,000,000
import java.util.*;
import java.io.*;

class Main {
	
	static String s;
	static int answer;
	static int[] nums, prefixSum, lastCorrects;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        s = br.readLine();
        int l = s.length();
        nums = new int[l+1];
        prefixSum = new int[l+1];
        lastCorrects = new int[l+1];
        
        // ( : 1, ) : -1
        for (int i=0; i<l; i++) {
        	if (s.charAt(i) == '(') {
        		nums[i+1] = 1;
        	} else {
        		nums[i+1] = -1;
        	}
        	prefixSum[i+1] = prefixSum[i] + nums[i+1];
        	if (lastCorrects[i] == i && prefixSum[i+1] >= 0) {
        		lastCorrects[i+1] = i+1;
        	} else {
        		lastCorrects[i+1] = lastCorrects[i];
        	}
        }
        
        answer = 0;
        for (int i=1; i<=l; i++) {
        	if (prefixSum[l] * nums[i] > 0) {
        		// i전까지는 correct 여야 함
        		if (lastCorrects[i] < i-1) continue;
        		
        		boolean flag = true;
        		for (int j=i; j<=l; j++) {
        			if (prefixSum[j] - 2*(nums[i]) < 0) {
        				flag = false;
        				break;
        			}
        		}
        		
        		if (flag) {
        			answer++;
        		}
        	}
        }
        
        System.out.print(answer);
        
    }
   
};
