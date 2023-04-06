import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[][] startmap, endmap;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int n, m;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt(); // 세로 n, 가로 m
		m = sc.nextInt();
		
		startmap = new int[n][m];
		endmap = new int[n][m];
		
		for(int r=0; r<n; r++) {
			char[] tmp = sc.next().toCharArray();
			for(int c=0; c<m; c++) {
				if(tmp[c] == '1') startmap[r][c] = endmap[r][c] = -1;
				else startmap[r][c] = endmap[r][c] = 0;
			}
		} // 입력
		
		bfs(0, 0, startmap);
		bfs(n-1, m-1, endmap);
		
		int min = Integer.MAX_VALUE;
		if(startmap[n-1][m-1] != 0) min = startmap[n-1][m-1];
		for(int r=0; r<n; r++) {
			for(int c=0; c<m; c++) {
				if(startmap[r][c] == -1) { // 벽
					ArrayList<Node> promNodes = new ArrayList<>();
					for(int i=0; i<4; i++) {
						int nr = r + dr[i];
						int nc = c + dc[i];
						
						// 범위 안에 있고 벽 아니면 벽 부쉈을 때 연결될 수 있는 위치로 추가
						if(nr>=0 && nr<n && nc>=0 && nc<m && startmap[nr][nc] != -1) promNodes.add(new Node(nr, nc));
					}
					
					int l = promNodes.size();
					if(l < 2) continue;
					for(int j=0; j<l; j++) {
						for(int k=0; k<l; k++) {
							if(j != k) { // 다른 노드일때
								int n1 = startmap[promNodes.get(j).r][promNodes.get(j).c];
								int n2 = endmap[promNodes.get(k).r][promNodes.get(k).c];
								
								if(n1 != 0 && n2 != 0 && n1+n2+1 < min) min = n1+n2+1;
							}
						}
					}
				}
			}
		}
		
		if(min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
		
	} // main
	
	
	private static void bfs(int r, int c, int[][] map) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(r, c)); // q에 넣고
		map[r][c] = 1; // 출발점도 경로 포함
		
		while(!q.isEmpty()) {
			
			Node cur = q.poll();
			int cr = cur.r;
			int cc = cur.c;
			
			for(int i=0; i<4; i++) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];
				
				if(nr>=0 && nr<n && nc>=0 && nc<m && map[nr][nc]==0) { // 범위 안에 있고 방문 안했으면
					map[nr][nc] = map[cr][cc] + 1;
					q.add(new Node(nr, nc));
				}
			}
		} // q
	} // bfs
	
	static class Node{
		int r, c;
		
		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
}
