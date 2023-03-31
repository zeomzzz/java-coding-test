import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	
	static int INF = Integer.MAX_VALUE; 
	static int[] time;
	static int[][] contact;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1; tc<=10; tc++) {
			
			int n = sc.nextInt(); // n/2 쌍
			int start = sc.nextInt();
			contact = new int[101][101];
			time = new int[101]; // 최단시간 저장
			
			for(int i=0; i<(int)(n/2); i++) {
				contact[sc.nextInt()][sc.nextInt()] = 1;
			}
			
			// time 초기화
			Arrays.fill(time, INF);
			
			djk(start);
			
			int maxidx = 0;
			int maxtime = 0;
			
			for(int i=0; i<101; i++) {
				if(time[i] != INF && time[i] >= maxtime) { // 못들은곳은 INF여서 제외
					maxtime = time[i];
					maxidx = i;
				}
			}
			
			System.out.printf("#%d %d\n", tc, maxidx);
			
		} // tc
		
	}
	
	public static void djk(int start) {
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[101];
		
		pq.add(new Node(start, time[start]));
		time[start] = 0;

		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			int cp = n.p1;
			visited[cp] = true;
			
			for(int i=0; i<101; i++) {
				if(contact[cp][i] == 0 || visited[i]) continue; // 연락 할 수 없거나 방문했으면 continue
				
				if(time[i] > time[cp] + contact[cp][i]) { // 갱신 가능한 경우 갱신하고 큐에 다음 노드 넣기
					time[i] = time[cp] + contact[cp][i];
					pq.add(new Node(i, time[i]));
				}
			}
			
		}
		
		
	}
	
	public static class Node implements Comparable<Node> {
		int p1, t;
		
		Node(int p1, int t){
			this.p1 = p1;
			this.t = t;
		}

		@Override
		public int compareTo(Node o) {
			return this.t - o.t;
		}
	}

}
