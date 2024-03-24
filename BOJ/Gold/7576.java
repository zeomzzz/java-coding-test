import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, day;
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	static int[][] box;
	static boolean[][] visited;
	static Queue<Node> q;
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	box = new int[M][N];
    	q = new LinkedList<>();
    	
    	for (int r=0; r<M; r++) {
    		st = new StringTokenizer(br.readLine());
    		for (int c=0; c<N; c++) box[r][c] = Integer.parseInt(st.nextToken());
    	}
    	
    	for (int r=0; r<M; r++) {
    		for (int c=0; c<N; c++) {
    			if (box[r][c] == 1) q.offer(new Node(r, c));
    		}
    	}
    	
    	Node cur;
    	int curR, curC, nxtR, nxtC;
    	while (!q.isEmpty()) {
    		cur = q.poll();
    		curR = cur.r;
    		curC = cur.c;
    		
    		for (int i=0; i<4; i++) {
    			nxtR = curR + dr[i];
    			nxtC = curC + dc[i];
    			
    			if (nxtR < 0 || nxtR >= M) continue;
    			if (nxtC < 0 || nxtC >= N) continue;
    			if (box[nxtR][nxtC] == -1) continue;
    			
    			if (box[nxtR][nxtC] == 0) {
    				q.offer(new Node(nxtR, nxtC));
    				box[nxtR][nxtC] = box[curR][curC] + 1;
    			} else if (box[nxtR][nxtC] > box[curR][curC] + 1) {
    				q.offer(new Node(nxtR, nxtC));
    				box[nxtR][nxtC] = box[curR][curC] + 1;
    			}
    		}
    	}
    	
    	boolean isUnable = false;
    	outer: for (int r=0; r<M; r++) {
    		for (int c=0; c<N; c++) {
    			if (box[r][c] == 0) {
    				isUnable = true;
    				break outer;
    			}
    			day = Math.max(day, box[r][c]);
    		}
    	}
    	
    	if (isUnable) day = 0;
    	System.out.print(day-1);
    	
    }
    
    static class Node {
    	int r, c;
    	
    	Node(int r, int c) {
    		this.r = r;
    		this.c = c;
    	}
    }
};
