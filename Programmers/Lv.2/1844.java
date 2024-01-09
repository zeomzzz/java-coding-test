// dfs (효율성 4/5)
import java.util.*;

class Solution {
    static int answer;
    public int solution(int[][] maps) {
        answer = Integer.MAX_VALUE;
        
        int rMax = maps.length;
        int cMax = maps[0].length;
        int[][] visited = new int[rMax][cMax];
        
        visited[0][0] = 1; // 출발 위치 방문처리
        dfs(0, 0, rMax, cMax, maps, visited);
        
        if (answer == Integer.MAX_VALUE) {
            return -1;
        } else {
            return answer;
        }
    }
    
    static void dfs(int cr, int cc, int rMax, int cMax, int[][] maps, int[][] visited) {
        
        if (cr == rMax - 1 && cc == cMax - 1) {
            answer = visited[rMax - 1][cMax - 1];
            return;
        }
        
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        
        for (int i=0; i<4; i++) {
            int nr = cr + dr[i];
            int nc = cc + dc[i];
            
            if (nr >= 0 && nr < rMax && nc >= 0 && nc < cMax && maps[nr][nc] == 1) { // 범위 안 + 갈 수 있는 곳
                if (visited[nr][nc] == 0) { // 아직 방문 안함
                    visited[nr][nc] = visited[cr][cc] + 1; // 방문 처리
                    dfs(nr, nc, rMax, cMax, maps, visited);
                } else { // 방문 한 적 있음
                    if (visited[cr][cc] + 1 < visited[nr][nc]) { // 그런데 업데이트 가능
                        visited[nr][nc] = visited[cr][cc] + 1;
                        dfs(nr, nc, rMax, cMax, maps, visited);
                    }
                }
            }
        }
    }
}

// bfs
import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = -1;
        int maxR = maps.length;
        int maxC = maps[0].length;
        int[][] visited = new int[maxR][maxC];
        
        Deque<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0));
        visited[0][0] = 1;
        
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        
        while (!q.isEmpty()) {
            
            Node cur = q.poll();
            int cr = cur.r;
            int cc = cur.c;
            
            if (cr == maxR - 1 && cc == maxC - 1) {
                answer = visited[maxR-1][maxC-1];
                break;
            }
            
            // 다음 노드를 q에 담음
            for (int i=0; i<4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                
                if (nr >= 0 && nr < maxR && nc >= 0 && nc < maxC && maps[nr][nc] == 1 && visited[nr][nc] == 0) {
                    visited[nr][nc] = visited[cr][cc] + 1;
                    q.offer(new Node(nr, nc));
                }
            }
        }
        
        return answer;
    }
    
    class Node {
        private int r;
        private int c;
        
        Node (int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
