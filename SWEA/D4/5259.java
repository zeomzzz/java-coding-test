// 크루스칼 풀이
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
 
public class Solution {
    static int[] p;
 
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
 
        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
 
            int v = sc.nextInt(); // 0 ~ 마지막 노드번호 -> 노드 v+1개
            int e = sc.nextInt(); // 간선 e개
            int[][] edges = new int[e][3]; // 노드 n1, n2, 가중치 w
            for (int i = 0; i < e; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                edges[i][2] = sc.nextInt();
            }
 
            // 1. 정렬 : 가중치를 기준으로
            Arrays.sort(edges, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[2] - o2[2];
                }
            });
 
            // 2. 간선 뽑기 (v개)
            p = new int[v + 1]; // 부모 담는 배열. 노드번호가 0 ~ v+1
            for (int i = 0; i < v + 1; i++) { // 자기 자신이 대표자이도록 초기화
                p[i] = i;
            }
 
            int sum = 0; // 가중치의 합
            int pick = 0; // 뽑은 간선의 수 (v+1개 뽑아야 함)
 
            int i = 0;
            while (pick != v && i < e) {
                int px = findset(edges[i][0]);
                int py = findset(edges[i][1]);
 
                if (px != py) { // 다른 집합이면
                    union(px, py); // union ㄱ
                    sum += edges[i][2];
                    pick++;
                }
 
                i++;
            }
             
//          if(pick < v) { // 간선 v개 뽑지 않았는데 끝났다면
//              도 추가할 수 있음
//          }
             
            System.out.printf("#%d %d\n", tc, sum);
             
        } // tc
 
    }
 
    private static void union(int x, int y) {
        p[y] = x; // y, x 모두 대표자니까
    }
 
    private static int findset(int x) {
        if (x != p[x])
            p[x] = findset(p[x]);
        return p[x];
    }
 
}


// 프림(반복문) 풀이
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	static final int INF = Integer.MAX_VALUE;

	// 프림 반복문 풀이
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc=1; tc<=t; tc++) {
			
			int v = sc.nextInt(); // 마지막 노드 번호: 노드 0 ~ v : v+1개
			int e = sc.nextInt(); // 간선의 개수
			
			int[][] adj = new int[v+1][v+1];
			
			Nodes[] nodes = new Nodes[e];
			for(int i=0; i<e; i++) {
				nodes[i] = new Nodes(sc.nextInt(), sc.nextInt(), sc.nextInt());
				adj[nodes[i].n1][nodes[i].n2] = nodes[i].w;
				adj[nodes[i].n2][nodes[i].n1] = nodes[i].w;
			} // input
			
			// 방문처리 위한 세팅
			boolean[] visited = new boolean[v+1];
			int[] dist = new int[v+1];
			Arrays.fill(dist, INF);
			
			// 방문 시작 초기화
			dist[0] = 0;
			
			int ans = 0; // 정답
			
			// 프림 동작
			for(int i=0; i<v; i++) {
				
				// 1. dist가 가장 작은 값을 뽑기
				int min = INF;
				int idx = -1;
				
				for(int j=0; j<v+1; j++) {
					if(!visited[j] && dist[j]<min) { // 방문 안했고  dist가 min보다 작으면
						min = dist[j]; // 갱신
						idx = j;
					}
				}
				visited[idx] = true; // 선택!
				
				// 2. dist를 갱신
				for(int j=0; j<v+1; j++) {
					if(!visited[j] && adj[idx][j] != 0 && dist[j] > adj[idx][j]) { // j에 방문 안했고 / idx랑 j랑 인접하고 / idx와 j가 인접할때 가중치가 dis보다 작으면
						dist[j] = adj[idx][j];
					}
				}
			} // 프림 반복문 종료
			
			for(int i=0; i<v+1; i++) {
				ans += dist[i];
			}
			
			System.out.printf("#%d %d\n", tc, ans);
			
		} // tc
		
	}
	
	public static class Nodes {
		
		int n1, n2, w;
		
		public Nodes(int n1, int n2, int w) {
			this.n1 = n1;
			this.n2 = n2;
			this.w = w;
		}
		
	}


}

