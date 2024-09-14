/*
 * 1. 수열을 만든다
 * 2. 좋은 수열인지 확인한다.
 * 
 */
import java.util.*;
import java.io.*;

class Main {
	
	static int N;
	static int[] selected;
	static boolean flag;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
     
        N = Integer.parseInt(st.nextToken());
        selected = new int[N];
        
        recur(0);
        
    }
    
    public static boolean checkIsGoodNums(int cur) {
    	
    	for (int i=1; i<=cur/2; i++) {
    		int cnt = 0;
    		for (int j=1; j<=i; j++) {
    			if (selected[cur-j] == selected[cur-i-j]) {
    				cnt++;
    			}
    		}
    		if (cnt == i) {
    			return false;
    		}
    	}
    	
    	return true;
    }
    
    public static void recur(int cur) {
    	
    	if (flag) {
    		return;
    	}
    	
    	if (cur > 1) {
    		if (!checkIsGoodNums(cur)) {
    			return;
    		}
    	}
    	
    	if (cur == N) {
    		flag = true;
    		for (int select : selected) {
    			System.out.print(select);
    		}
    		return;
    	}
    	
    	for (int i=1; i<=3; i++) {
    		selected[cur] = i;
    		recur(cur+1);
    	}
    	
    }
    
};
