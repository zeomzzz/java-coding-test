import java.io.*;
import java.util.*;

public class Main {
	
	static int h, w, answer;
	static char[][] map;
	static int[][] visited;
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	h = Integer.parseInt(st.nextToken());
    	w = Integer.parseInt(st.nextToken());
    	answer = 0;
    	
    	map = new char[h][w];
    	String line;
    	for (int i=0; i<h; i++) {
    		line = br.readLine();
    		for (int j=0; j<w; j++) map[i][j] = line.charAt(j);
    	}
    	
    	Queue<Node> q = new LinkedList<>();
    	visited = new int[h][w];
    	for (int r=0; r<h; r++) {
    		for (int c=0; c<w; c++) {
    			if (map[r][c] == 'W') continue;
    			for (int i=0; i<h; i++) Arrays.fill(visited[i], -1);
    			
    			q.clear();
    			q.offer(new Node(r, c));
    			visited[r][c] = 0;
    			
    			while (!q.isEmpty()) {
    				Node cur = q.poll();
    				int curR = cur.r;
    				int curC = cur.c;
    				
    				for (int i=0; i<4; i++) {
    					int nxtR = curR + dr[i];
    					int nxtC = curC + dc[i];
    					if (nxtR < 0 || nxtR >= h || nxtC < 0 || nxtC >= w) continue;
    					if (visited[nxtR][nxtC] != -1) continue;
    					if (map[nxtR][nxtC] == 'W') continue;
    					
    					q.offer(new Node(nxtR,nxtC));
    					visited[nxtR][nxtC] = visited[curR][curC]+1;
    					answer = Math.max(answer, visited[nxtR][nxtC]);
    				}
    			}
    			
    		}
    		
    	}
    	System.out.print(answer);
    }
    
    static class Node {
    	int r, c;
    	
    	Node(int r, int c) {
    		this.r = r;
    		this.c = c;
    	}
    }
    
};
