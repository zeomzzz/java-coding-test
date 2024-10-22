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

// 241022
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, T, ans;
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visited;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList<>();
        for (int i=0; i<=N; i++) {
        	graph.add(new ArrayList<>());
        }
        
        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        
        for (int i=1; i<=T; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	graph.get(a).add(b);
        	graph.get(b).add(a);
        }
        
        visited = new boolean[N+1];
        
        ans = 0;
        dfs(1);
        
        System.out.print(ans);
    }
    
    static void dfs(int cur) {
    	
    	visited[cur] = true;
    	
    	for (int nxt : graph.get(cur)) {
    		if (!visited[nxt]) {
    			ans++;
    			dfs(nxt);
    		}
    	}
    }
}
