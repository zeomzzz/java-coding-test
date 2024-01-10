// dfs 풀이
import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        int[] visited = new int[n];
        
        for (int i=0; i<n; i++) {
            if (visited[i] == 0) {
                dfs(i, visited, computers);
                answer++;
            }
        }
        
        return answer;
    }
    
    static void dfs(int cur, int[] visited, int[][] computers) {
        
        visited[cur] = 1;
        
        for (int nxt=0; nxt<computers.length; nxt++) {
            if (visited[nxt] == 0 && computers[cur][nxt] == 1) {
                dfs(nxt, visited, computers);
            }
        }
    }
}

// bfs 풀이
import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        int[] visited = new int[n];
        Queue<Integer> q = new LinkedList<>();
        
        for (int i=0; i<n; i++) {
            if (visited[i] == 0) {
                
                answer++;
                q.offer(i);
                while (!q.isEmpty()) {
                    
                    int cur = q.poll();
                    visited[cur] = 1;
                    
                    for (int nxt=0; nxt<n; nxt++) {
                        if (visited[nxt] == 0 && computers[cur][nxt] == 1) {
                            q.offer(nxt);
                        }
                    }
                }
                
            }
        }
        
        return answer;
    }
}

// 240110
class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for (int i=0; i<n; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                answer++;
                dfs(i, n, computers);
            }
        }
        
        return answer;
    }
    
    static void dfs(int cur, int n, int[][] computers) {
        
        for (int nxt=0; nxt<n; nxt++) {
            if (visited[nxt] == false && computers[cur][nxt] == 1) {
                visited[nxt] = true;
                dfs(nxt, n, computers);
            }
        }
    }
}
