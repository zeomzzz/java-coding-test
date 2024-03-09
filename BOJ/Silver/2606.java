import java.io.*;
import java.util.*;

public class Main {
	
	static int answer;
	static List<Integer>[] graph;
	static boolean[] visited;
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	int tc = Integer.parseInt(br.readLine());
    	graph = new LinkedList[n+1];
    	for (int i=0; i<=n; i++) {
    		graph[i] = new LinkedList<>();
    	}
    	
    	StringTokenizer st;
    	for (int i=0; i<tc; i++) {
    		st = new StringTokenizer(br.readLine());
    		int c1 = Integer.parseInt(st.nextToken());
    		int c2 = Integer.parseInt(st.nextToken());
    		
    		graph[c1].add(c2);
    		graph[c2].add(c1);
    	}
    	
    	visited = new boolean[n+1];
    	dfs(1);
    	
    	System.out.print(answer - 1); // 1번 컴퓨터 제외
    }
    
    static void dfs(int cur) {
    	
    	answer++;
    	visited[cur] = true;
    	
    	for (int nxt : graph[cur]) {
    		if (visited[nxt]) continue;
    		dfs(nxt);
    	}
    }
    
};
