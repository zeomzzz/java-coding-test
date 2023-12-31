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
