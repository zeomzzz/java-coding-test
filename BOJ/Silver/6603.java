import java.io.*;

// 1. CCTV 종류 별로 감시 방향 정하기
// 2. 감시 범위 체크
// 3. 계산
import java.util.*;

public class Main {
	
	static int k;
	static int[] S, selected;
	static StringBuilder answer;
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    	StringTokenizer st = new StringTokenizer(br.readLine());
    	StringTokenizer st;
    	
    	answer = new StringBuilder();
    	selected = new int[6];
    	
    	while (true) {
    		st = new StringTokenizer(br.readLine());
    		k = Integer.parseInt(st.nextToken());
    		
    		if (k == 0) break;
    		
    		S = new int[k];
        	for (int i=0; i<k; i++) {
        		S[i] = Integer.parseInt(st.nextToken());
        	}
        	
        	recur(0, 0);
        	answer.append("\n");
        	
    	}
    	
    	System.out.print(answer);
    	
    }
    
    public static void recur(int cur, int start) {
    	
    	if (cur == 6) {
    		for (int select : selected) {
    			answer.append(select + " ");
    		}
    		answer.append("\n");
    		return;
    	}
    	
    	for (int i=start; i<k; i++) {
    		selected[cur] = S[i];
    		recur(cur+1, i+1);
    	}
    	
    }
    
};
