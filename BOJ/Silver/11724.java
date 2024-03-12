import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, u, v, answer;
	static List<Integer>[] graph;
	static boolean[] visited;
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken()); // 정점의 개수
    	M = Integer.parseInt(st.nextToken()); // 간선의 개수
    	
    	graph = new LinkedList[N+1];
    	for (int i=0; i<=N; i++) {
    		graph[i] = new LinkedList<>();
    	}
    	
    	for (int i=0; i<M; i++) {
    		st = new StringTokenizer(br.readLine());
    		u = Integer.parseInt(st.nextToken());
    		v = Integer.parseInt(st.nextToken());
    		
    		graph[u].add(v);
    		graph[v].add(u);
    	}
    	
    	visited = new boolean[N+1];
    	
    	answer = 0;
    	for (int i=1; i<N+1; i++) {
    		if (!visited[i]) {
    			answer++;
    			dfs(i);
    		}
    	}
    	
    	System.out.print(answer);
    	
    }
    
    static void dfs(int cur) {
    	visited[cur] = true;
    	
    	for (int nxt : graph[cur]) {
    		if (visited[nxt]) continue;
    		dfs(nxt);
    	}
    }
    
};
