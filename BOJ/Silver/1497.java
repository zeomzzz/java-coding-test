import java.io.*;
import java.util.*;

// 백트래킹으로 확인
public class Main {
	
	static int maxS = Integer.MIN_VALUE;
	static int minG = Integer.MAX_VALUE;
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken()); // 기타의 개수
    	int M = Integer.parseInt(st.nextToken()); // 곡의 개수
    	boolean[] visited = new boolean[M];
    	
    	String[] gs = new String[N];
    	for (int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine());
    		String g = st.nextToken();
    		gs[i] = st.nextToken();
    	}
    	
    	backtracking(0, 0, 0, N, M, gs, visited);
    	
    	if (minG == Integer.MAX_VALUE) {
    		minG = -1;
    	}
    	
    	System.out.print(minG);
    }
    
    static void backtracking(int cur, int gCnt, int songCnt, int N, int M, String[] gs, boolean[] visited) {
    	
    	if (songCnt > 0) {
    		if (songCnt == maxS) {
        		minG = Math.min(minG, gCnt);
        	} else if (songCnt > maxS) {
        		maxS = songCnt;
        		minG = gCnt;
        	}
    	}
    	
    	if (cur == N) return;
    	
    	backtracking(cur+1, gCnt, songCnt, N, M, gs, visited);
    	List<Integer> idxs = new LinkedList<>();
    	for (int i=0; i<M; i++) {
    		if (gs[cur].charAt(i)=='Y') {
    			if (!visited[i]) {
    				visited[i] = true;
    				songCnt++;
    				idxs.add(i);
    			}
    		}
    	}
    	backtracking(cur+1, gCnt+1, songCnt, N, M, gs, visited);
    	for (int idx : idxs) {
    		visited[idx] = false;
    	}
    	
    }
    
};
