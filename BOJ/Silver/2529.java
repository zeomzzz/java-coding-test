import java.io.*;
import java.util.*;

// 숫자 고르면서 부등호 관계 맞는지 확인
public class Main {
	
	static long min = 0;
	static long max = 0;
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int k = Integer.parseInt(br.readLine());
    	String[] signs = new String[k];
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for (int i=0; i<k; i++) {
    		signs[i] = st.nextToken();
    	}
    	
    	boolean[] visited = new boolean[10];
    	int[] selected = new int[k+1];
    	for (int i=0; i<10; i++) {
    		selected[0] = i;
    		visited[i] = true;
    		
    		backtracking(1, k, signs, selected, visited);
    		visited[i] = false;
    	}
    	
    	String strMax = Long.toString(max);
    	String strMin = Long.toString(min);
    	
    	if (strMax.length() != k+1) {
    		StringBuilder sb = new StringBuilder();
    		sb.append("0");
    		sb.append(strMax);
    		System.out.println(sb.toString());
    	} else {
    		System.out.println(max);
    	}
    	
    	if (strMin.length() != k+1) {
    		StringBuilder sb = new StringBuilder();
    		sb.append("0");
    		sb.append(strMin);
    		System.out.println(sb.toString());
    	} else {
    		System.out.println(min);
    	}
    }
    
    static void backtracking(int cur, int k, String[] signs, int[] selected, boolean[] visited) {
    	
    	if (cur == k+1) {
    		if (min == 0) {
    			for (int select : selected) {
    				min *= 10;
    				min += select;
    			}
    		} else {
    			max = 0;
    			for (int select : selected) {
    				max *= 10;
    				max += select;
    			}
    		}
    		return;
    	}
    	
    	for (int i=0; i<10; i++) {
    		if (visited[i]) continue;
    		if (!check(selected[cur-1], signs[cur-1], i)) continue;
    		selected[cur] = i;
    		visited[i] = true;
    		
    		backtracking(cur+1, k, signs, selected, visited);
    		
    		visited[i] = false;
    	}
    }
    
    static boolean check(int n, String sign, int m) {
    	if (sign.equals(">")) {
    		if (n > m) return true;
    	} else {
    		if (n < m) return true;
    	}
    	return false;
    }
    
};
