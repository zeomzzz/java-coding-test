import java.io.*;
import java.util.*;

// 백트래킹으로 확인
public class Main {
	
	static List<Integer> answer;
	static int cnt = 0;
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int n = Integer.parseInt(st.nextToken()); // target
    	int k = Integer.parseInt(st.nextToken()); // k
    	
    	answer = new ArrayList<>();
    	List<Integer> selected = new ArrayList<>();
    	backtracking(0, 0, n, k, selected);
    	
    	if (answer.size() == 0) {
    		System.out.print(-1);
    	} else {
    		StringBuilder sb = new StringBuilder();
    		for (int ans : answer) {
    			sb.append(ans);
    			sb.append("+");
    		}
    		sb.deleteCharAt(sb.length()-1);
    		System.out.print(sb);
    	}
    	
    }
    
    static void backtracking(int cur, int sum, int target, int k, List<Integer> selected) {
    	
    	if (sum == target) {
    		cnt++;
    		if (cnt == k) {
    			for (int select : selected) {
    				answer.add(select);
    			}
    			return;
    		}
    		return;
    	}
    	
    	for (int i=1; i<4; i++) {
    		if (sum+i <= target && cnt <= k) {
    			selected.add(i);
    			backtracking(cur+1, sum+i, target, k, selected);
    			selected.remove(cur);
    		}
    	}
    	
    }
    
};
