import java.io.*;
import java.util.*;

// 백트래킹으로 확인
// 스킬 2n개 중에 n개 고르고
// 퀘스트 돌면서 몇 개 깰 수 있는지 확인
public class Main {
	
	static int max = Integer.MIN_VALUE;
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int n = Integer.parseInt(st.nextToken()); // 키의 개수 n
    	int m = Integer.parseInt(st.nextToken()); // 퀘스트 m개
    	int k = Integer.parseInt(st.nextToken()); // 퀘스트당 사용해야하는 스킬 k개
    	
    	int[][] quests = new int[m][k];
    	for (int i=0; i<m; i++) {
    		st = new StringTokenizer(br.readLine());
    		for (int j=0; j<k; j++) {
    			quests[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	// 1~2n 중 n개 고르기
    	boolean[] visited = new boolean[2*n+1];
    	backtracking(1, 0, n, visited, quests);
    	
    	System.out.print(max);
    }
    
    static void backtracking(int cur, int cnt, int n, boolean[] visited, int[][] quests) {
    	
    	if (cur == 2*n+1) {
    		if (cnt == n) { // n개 다 고른 경우만
    			int tmp = 0; // 몇 개 퀘스트 깰 수 있는지
    			for (int[] quest : quests) {
    				boolean flag = true;
    				for (int skill : quest) {
    					if (!visited[skill]) { // 없는 스킬
    						flag = false;
    						break;
    					}
    				}
    				if (flag) {
    					tmp++;
    				}
    			}
    			max = Math.max(max, tmp);
    		}
    		return;
    	}
    	
    	// 이번거 선택
    	visited[cur] = true;
    	backtracking(cur+1, cnt+1, n, visited, quests);
    	// 이번거 선택 안함
    	visited[cur] = false;
    	backtracking(cur+1, cnt, n, visited, quests);
    }
    
};
