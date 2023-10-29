import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int maxDist = 0;
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n+1; i++) graph.add(new ArrayList<Integer>());
        for (int[] nodes : edge) {
            int n1 = nodes[0];
            int n2 = nodes[1];
            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }
        
        int[] visited = new int[n + 1];
        
        Deque<Integer> q = new ArrayDeque<>();
        q.add(1);
        visited[1] = 1;
        
        while(q.size() > 0) {
            int cur = q.remove();
            
            for(int nxt : graph.get(cur)) {
                if (visited[nxt] == 0 || visited[cur] + 1 < visited[nxt]) {
                    visited[nxt] = visited[cur] + 1;
                    q.add(nxt);
                    
                    if (visited[nxt] > maxDist) {
                        maxDist = visited[nxt];
                        answer = 1;
                    } else if (visited[nxt] == maxDist) {
                        answer += 1;
                    }
                }
            }
        }
        
        return answer;
    }
}
