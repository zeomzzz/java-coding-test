import java.io.*;
import java.util.*;

public class Main {
	
	static int N, K;
	static int[] visited;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	K = Integer.parseInt(st.nextToken());
    	
    	visited = new int[100001];
    	Arrays.fill(visited, Integer.MAX_VALUE);
    	
    	PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.time - o2.time);
    	q.offer(new Node(N, 0));
    	visited[N] = 0;
    	
    	Node cur;
    	int curIdx, curT;
    	while (!q.isEmpty()) {
    		cur = q.poll();
    		curIdx = cur.idx;
    		curT = cur.time;
    		if (curIdx == K) break;
    		
    		if (curIdx-1 >= 0 && visited[curIdx-1] > visited[curIdx]+1) {
    			q.offer(new Node(curIdx-1, visited[curIdx]+1));
    			visited[curIdx-1] = visited[curIdx]+1;
    		}
    		if (curIdx+1 <= 100000 && visited[curIdx+1] > visited[curIdx]+1) {
    			q.offer(new Node(curIdx+1, visited[curIdx]+1));
    			visited[curIdx+1] = visited[curIdx]+1;
    		}
    		if (curIdx*2 <= 100000 && visited[curIdx*2] > visited[curIdx]) {
    			q.offer(new Node(curIdx*2, visited[curIdx]));
    			visited[curIdx*2] = visited[curIdx];
    		}
    		
    	}
    	
    	System.out.print(visited[K]);
    	
    }
    
    static class Node {
    	int idx, time;
    	
    	Node(int idx, int time) {
    		this.idx = idx;
    		this.time = time;
    	}
    }
    
};
