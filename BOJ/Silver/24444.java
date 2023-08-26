import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 정점의 수
		int M = Integer.parseInt(st.nextToken()); // 간선의 수
		int R = Integer.parseInt(st.nextToken()); // 시작 정점
		
		ArrayList<Integer>[] graph = new ArrayList[N + 1];
		for (int i=1; i < N+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i=0; i<M; i++) { // 간선 표시
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph[u].add(v);
			graph[v].add(u);
		}
		
		for (int i=1; i<N+1; i++) {
			Collections.sort(graph[i]);
		}
		
		int[] visited = new int[N + 1]; // 0으로 초기화. 정점번호가 1 ~ N
		
		Queue<Integer> q = new LinkedList<>();
		
		q.add(R); // 시작점 q에 넣고
		visited[R] = 1; // 방문처리
		
		int cnt = 1;
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			
			for (int i = 0; i < graph[cur].size(); i++) {
				int nxt = graph[cur].get(i);
				if (visited[nxt] == 0) {
					q.add(nxt); // q에 넣고
					visited[nxt] = ++cnt; // 방문 처리
				}
			}
		}
		
		for (int idx=1; idx<visited.length; idx++) {
				System.out.println(visited[idx]);
		}
		
	}

}
