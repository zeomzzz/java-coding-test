// 위상정렬
// 방법 1. Queue

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	
	static StringBuilder sb;
	static int v;
	static int[] indegree;
	static ArrayList<ArrayList<Integer>> adj;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1; tc<=10; tc++) {
			
			v = sc.nextInt(); // 정점의 개수
			int e = sc.nextInt(); // 간선의 개수
			
			adj = new ArrayList<>();
			for(int i=0; i<v+1; i++) { // v번째에서 출발하는 도착점 담는 ArrayList 만들기
				adj.add(new ArrayList<>());
			}
			
			indegree = new int[v+1]; // 진입차수 담는 배열
			
			for(int i=0; i<e; i++) { // 정점 담기
				int start = sc.nextInt();
				int end = sc.nextInt();
				adj.get(start).add(end);
				indegree[end]++; // 진입차수 담기
			}
			
			// 예쁘게 출력하려고.. 
//			for(int i=1; i<v+1; i++) {
//				Collections.sort(adj.get(i));
//			}
			
			sb = new StringBuilder();
			sb.append("#" + tc);
			
			tpg();
			
			System.out.println(sb);
			
		} // tc 10개
	}

	private static void tpg() {
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<v+1; i++) { // 진입차수 0인 정점(바로 출발 가능) 담기
			if(indegree[i] == 0) q.add(i);
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll(); // 하나 꺼내서(방문)
			sb.append(" " + cur);// 출력할 sb에 추가
			
			for(int node : adj.get(cur)) {
				indegree[node]--; // 선행조건 하나 처리함
				if(indegree[node] == 0) q.add(node); // 선행조건 다 처리됐으면 큐에 넣기
			}
		}
	}
}
