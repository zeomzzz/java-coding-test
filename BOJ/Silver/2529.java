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

// 240505
import java.io.*;
import java.util.*;

public class Main {
	
	static int k;
	static String[] signs;
	static int[] selected;
	static List<String> answers;
	static boolean[] visited;
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	k = Integer.parseInt(br.readLine());
    	signs = new String[k];
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for (int i=0; i<k; i++) signs[i] = st.nextToken();
    	
    	selected = new int[k+1];
    	visited = new boolean[10];
    	answers = new LinkedList<>();

    	recur(0);
    	
    	System.out.println(Collections.max(answers));
    	System.out.print(Collections.min(answers));
    	
    }
    
    public static boolean check(int cur, int num) {
    	
    	if (cur == 0) {
    		return true;
    	} else {
    		if (signs[cur-1].equals("<")) {
    			if (selected[cur-1] < num) {
    				return true;
    			}
    		} else {
    			if (selected[cur-1] > num) {
    				return true;
    			}
    		}
    	}
    	
    	return false;
    	
    }
    
    public static void recur(int cur) {
    	
    	if (cur == k+1) {
    		StringBuilder sb = new StringBuilder();
    		for (int select : selected) sb.append(select);
    		
    		answers.add(sb.toString());
    		
    		return;
    	}
    	
    	for (int i=0; i<10; i++) {
    		if (visited[i]) continue;
    		if (!check(cur, i)) continue;
    		
    		visited[i] = true;
    		selected[cur] = i;
    		recur(cur+1);
    		visited[i] = false;
    	}
    	
    }
    
};

// 240922
import java.util.*;
import java.io.*;

class Main {
	
	static int K;
	static String[] signs;
	static int[] selected;
	static boolean[] visited;
	static String min, max;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        K = Integer.parseInt(st.nextToken());
        signs = new String[K];
        selected = new int[K+1];
        visited = new boolean[10];
        min = "";
        max = "";
        
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<K; i++) {
        	signs[i] = st.nextToken();
        }
        
        recur(0);
        
        System.out.println(max);
        System.out.print(min);
    }
    
    public static boolean check(int cur, int n) {
    	if (signs[cur-1].equals(">")) {
    		if (selected[cur-1] > n) {
    			return true;
    		}
    	} else {
    		if (selected[cur-1] < n) {
    			return true;
    		}
    	}
    	return false;
    }
    
    public static void recur(int cur) {
    	
    	if (cur == K+1) {
    		StringBuilder sb = new StringBuilder();
    		for (int select : selected) {
    			sb.append(select);
    		}
    		if (min.equals("")) {
    			min = sb.toString();
    		} else {
    			max = sb.toString();
    		}
    		return;
    	}
    	
    	for (int i=0; i<10; i++) {
    		if (!visited[i]) {
    			if (cur == 0) {
    				
    				visited[i] = true;
    				selected[cur] = i;
    				
    				recur(cur+1);
    				
    				visited[i] = false;
    				
    			} else {
    				if (check(cur, i)) {
    					
    					visited[i] = true;
    					selected[cur] = i;
    					
    					recur(cur+1);
    					
    					visited[i] = false;
    				}
    			}
    		}
    	}
    }
    
};
