import java.io.*;

// 1. CCTV 종류 별로 감시 방향 정하기
// 2. 감시 범위 체크
// 3. 계산
import java.util.*;

public class Main {
	
	static String A, B;
	static int l;
	static long answer;
	static char[] aArr;
	static int[] selected;
	static boolean[] visited;
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	A = st.nextToken();
    	B = st.nextToken();
    	answer = -1;
    	
    	aArr = A.toCharArray();
    	l = aArr.length;
    	selected = new int[l];
    	visited = new boolean[l];
    	
    	recur(0);
    	
    	System.out.print(answer);
    	
    }
    
    public static void recur(int cur) {
    	
    	if (cur == l) {
    		if (aArr[selected[0]] == '0') return;
    		
    		StringBuilder sb = new StringBuilder();
    		for (int select : selected) {
    			sb.append(aArr[select]);
    		}
    		long sbToLong = Long.parseLong(sb.toString());
    		
    		if (sbToLong < Long.parseLong(B)) answer = Math.max(answer, sbToLong);
    		
    		return;
    	}
    	
    	for (int i=0; i<l; i++) {
    		if (visited[i]) continue;
    		
    		selected[cur] = i;
    		visited[i] = true;
    		
    		recur(cur+1);
    		visited[i] = false;
    	}
    }
    
};
