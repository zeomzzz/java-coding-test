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
    	
    	Queue<Integer> q = new LinkedList<>();
    	visited = new int[100001];
    	Arrays.fill(visited, -1);
    	q.offer(N);
    	visited[N] = 0;
    	
    	int cur;
    	while (!q.isEmpty()) {
    		cur = q.poll();
    		
    		if (cur == K) break;
    		
    		if (cur-1 >= 0 && visited[cur-1] == -1) {
    			q.offer(cur-1);
    			visited[cur-1] = visited[cur]+1;
    		}
    		if (cur+1 <= 100000 && visited[cur+1] == -1) {
    			q.offer(cur+1);
    			visited[cur+1] = visited[cur]+1;
    		}
    		if (cur*2 <= 100000 && visited[cur*2] == -1) {
    			q.offer(cur*2);
    			visited[cur*2] = visited[cur]+1;
    		}
    	}
    	
    	System.out.print(visited[K]);
    	
    }
    
};
