import java.io.*;
import java.util.*;

public class Main {
	
	static int V, E, K, u, v, w;
	static List<Node>[] graph;
	static int[] dist;
	static PriorityQueue<Node> q;
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	V = Integer.parseInt(st.nextToken()); // 정점 1 ~ V
    	E = Integer.parseInt(st.nextToken()); // 간선 E개
    	K = Integer.parseInt(br.readLine());
    	
    	graph = new LinkedList[V+1];
    	for (int i=0; i<V+1; i++) graph[i] = new LinkedList<>();
    	
    	for (int i=0; i<E; i++) {
    		st = new StringTokenizer(br.readLine());
    		u = Integer.parseInt(st.nextToken());
    		v = Integer.parseInt(st.nextToken());
    		w = Integer.parseInt(st.nextToken());
    		
    		graph[u].add(new Node(v, w));
    	}
    	
    	// 다잌 ㄱㄱ
    	dist = new int[V+1];
    	Arrays.fill(dist, Integer.MAX_VALUE);
    	q = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
    	
    	q.offer(new Node(K, 0));
    	dist[K] = 0;
    	
    	Node cur;
    	while (!q.isEmpty()) {
    		cur = q.poll();
    		
    		int curIdx = cur.idx;
    		int curW = cur.w;
    		
    		for (Node nxt : graph[curIdx]) {
    			int nxtIdx = nxt.idx;
    			int nxtW = nxt.w;
    			if (curW + nxtW < dist[nxtIdx]) {
    				dist[nxtIdx] = curW + nxtW;
    				q.offer(new Node(nxtIdx, curW + nxtW));
    			}
    		}
    	}
    	
    	for (int i=1; i<V+1; i++) {
    		if (dist[i] != Integer.MAX_VALUE) System.out.println(dist[i]);
    		else System.out.println("INF");
    	}
    }
    
    static class Node {
    	int idx, w;
    	
    	Node(int idx, int w) {
    		this.idx = idx;
    		this.w = w;
    	}
    }
    
};
