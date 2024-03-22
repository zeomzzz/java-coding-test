import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	static char[][] room;
	static int[][] visited;
	static Queue<Node> q;
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	M = Integer.parseInt(st.nextToken());
    	N = Integer.parseInt(st.nextToken());
    	room = new char[N][M];
    	
    	String tmp;
    	for (int r=0; r<N; r++) {
    		tmp = br.readLine();
    		for (int c=0; c<M; c++) room[r][c] = tmp.charAt(c);
    	}
    	
    	// bfs를 이용해서 각 칸까지 가기 위해 최소 몇 개의 벽을 부숴야 하는지 찾기
    	visited = new int[N][M];
    	for (int r=0; r<N; r++) Arrays.fill(visited[r], -1);
    	q = new LinkedList<>();
    	q.offer(new Node(0, 0));
    	visited[0][0] = 0;
    	
    	Node cur;
    	int curR, curC, nxtR, nxtC;
    	while (!q.isEmpty()) {
    		
    		cur = q.poll();
    		curR = cur.r;
    		curC = cur.c;
    		
    		for (int i=0; i<4; i++) {
    			nxtR = curR + dr[i];
    			nxtC = curC + dc[i];
    			
    			if (nxtR < 0 || nxtR >= N) continue;
    			if (nxtC < 0 || nxtC >= M) continue;
    			
    			if (room[nxtR][nxtC] == '1') {
    				if (visited[nxtR][nxtC] == -1 || visited[curR][curC] + 1 < visited[nxtR][nxtC]) {
    					q.offer(new Node(nxtR, nxtC));
    					visited[nxtR][nxtC] = visited[curR][curC] + 1;
    				}
    			} else {
    				if (visited[nxtR][nxtC] == -1 || visited[curR][curC] < visited[nxtR][nxtC]) {
    					q.offer(new Node(nxtR, nxtC));
    					visited[nxtR][nxtC] = visited[curR][curC];
    				}
    			}
    		}
    	}
    	
    	System.out.print(visited[N-1][M-1]);
    }
    
    static class Node {
    	int r, c;
    	
    	Node(int r, int c) {
    		this.r = r;
    		this.c = c;
    	}
    }
    
};
