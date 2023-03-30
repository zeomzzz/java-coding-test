// 풀이 1 : 크루스칼
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

	static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int tc = 1; tc <= t; tc++) {

			int n = sc.nextInt(); // 섬의 개수 n
			int[][] pos = new int[n][2];
			// x좌표 입력
			for (int r = 0; r < n; r++) {
				pos[r][0] = sc.nextInt();
			}
			// y좌표 입력
			for (int r = 0; r < n; r++) {
				pos[r][1] = sc.nextInt();
			}
			
			double e = sc.nextDouble();

			int idx = 0;
			double[][] edges = new double[n * (n - 1) / 2][3];
			for (int i = 0; i < n - 1; i++) {
				for (int j = i + 1; j < n; j++) {
					edges[idx][0] = i;
					edges[idx][1] = j;
					edges[idx][2] = Math.pow(pos[i][0] - pos[j][0], 2) + Math.pow(pos[i][1] - pos[j][1], 2);
					idx++;
				}
			}

			// 가중치에 따라 정렬
			Arrays.sort(edges, new Comparator<double[]>() {
				@Override
				public int compare(double[] o1, double[] o2) {
					return Double.compare(o1[2], o2[2]);
				}
			});

			// make set
			p = new int[n];
			for (int i = 0; i < n; i++) {
				p[i] = i;
			}

			// 같은 집합 아니면 합치기
			int pick = 0;
			double min = 0;
			idx = 0;
			while (pick < n - 1) {
				int px = findset((int) edges[idx][0]);
				int py = findset((int) edges[idx][1]);
				
				if(px != py) {
					p[py] = px; // union
					pick++;
					min += edges[idx][2];
				}
				
				idx++;
				
			}
			
			System.out.printf("#%d %d\n", tc, Math.round(e * min));

		} // tc

	}

	private static int findset(int x) {
		if (p[x] != x) p[x] = findset(p[x]);
		return p[x];
	}

}

// 풀이 2 : 프림 우선순위 큐
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

	public static class Nodes implements Comparable<Nodes>{
		int n1, n2;
		double w;
		
		public Nodes(int n1, int n2, double w) {
			this.n1 = n1;
			this.n2 = n2;
			this.w = w;
		}
		
		@Override
		public int compareTo(Nodes n) {
			return Double.compare(this.w, n.w);
		}
	}

	// 프림 우선순위 큐 풀이
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc=1; tc<=t; tc++) {
			int n = sc.nextInt(); // 섬의 개수 n
			
			double[][] island = new double[n][2];
			for(int i=0; i<n; i++) { // x 입력
				island[i][0] = sc.nextInt();
			}
			for(int i=0; i<n; i++) { // y 입력
				island[i][1] = sc.nextInt();
			}
			
			double e = sc.nextDouble();
			
			// 노드, 가중치 입력하기
			List<Nodes>[] adj = new ArrayList[n];
			
			for(int i=0; i<n; i++) {
				adj[i] = new ArrayList<>();
			}
			
			for(int i=0; i<n-1; i++) {
				for(int j=i+1; j<n; j++) {
					double w = Math.pow(island[i][0] - island[j][0], 2) + Math.pow(island[i][1] - island[j][1], 2);
					adj[i].add(new Nodes(i, j, w));
					adj[j].add(new Nodes(j, i, w));					
				}
			} // adj에 입력 완료
			
			// 방문처리 세팅
			boolean[] visited = new boolean[n];
			PriorityQueue<Nodes> pq = new PriorityQueue<>();
			
			// 임의에서 시작할건데, 0을 선택!
			visited[0] = true;
			pq.addAll(adj[0]); // 우큐에 0번이랑 인접한 정점 다 넣기
			int pick = 1;
			double ans = 0;
			
			// 프림 
			while(pick != n) {
				Nodes node = pq.poll(); // 맨 앞의 것 꺼내
				
				if(!visited[node.n2]) { // 방문 안했으면
					ans += node.w;
					pq.addAll(adj[node.n2]);
					visited[node.n2] = true; // 방문했다
					pick++;
				}
			}
			
			System.out.printf("#%d %d\n", tc, Math.round(e * ans));
			
		} // tc
		
	}

}
