import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
 
public class Solution {
 
    static int[][] depth, map;
    static int n;
    static final int INF = Integer.MAX_VALUE;
 
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
 
        int t = sc.nextInt(); // tc
        for (int tc = 1; tc <= t; tc++) {
 
            n = sc.nextInt(); // 지도의 크기 n*n // 정점 n개.. 인 유방향
            map = new int[n][n];
            depth = new int[n][n];
            for (int r = 0; r < n; r++) {
                String tmp = sc.next();
                for (int c = 0; c < n; c++) {
                    map[r][c] = tmp.charAt(c) - '0';
                }
                Arrays.fill(depth[r], INF);
            }
 
            // 출발점 초기화
            Node start = new Node(0, 0, map[0][0]);
 
            dijkstra(start);
             
            System.out.printf("#%d %d\n", tc, depth[n-1][n-1]);
 
        } // tc
 
    } // main
 
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, 1, -1 };
 
    private static void dijkstra(Node start) { // 시작 Node 넣기
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(start);
        depth[start.r][start.c] = 0;
         
        boolean[][] visited = new boolean[n][n];
         
        outer : while(!pq.isEmpty()) {
             
            // 현재 노드 방문처리
            Node cur = pq.poll();
            int cr = cur.r;
            int cc = cur.c;
            visited[cr][cc] = true;
             
            // 인접 노드 중 d 가장 작은 것 찾기
            for(int i=0; i<4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                 
                // 배열 안에 있고
                if(!inArr(nr, nc)) continue;
                // 방문 하지 않았으면
                if(visited[nr][nc]) continue;
                // 갱신할지 판단
                depth[nr][nc] = Math.min(depth[nr][nc], depth[cr][cc] + map[nr][nc]);
                 
                if(nr == n-1 && nc == n-1) break outer; //  도착지에 오면 중단 
                 
                // 노드 pq에 넣고 계속 확인
                pq.add(new Node(nr, nc, depth[nr][nc]));
                 
            }
             
        }
 
    } // dijkstra
     
    public static boolean inArr(int r, int c) {
        if(r >= 0 && r < n && c >= 0 && c < n) return true;
        else return false;
    }
     
    public static class Node implements Comparable<Node> {
        int r, c, d;
 
        public Node(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
 
        @Override
        public int compareTo(Node o) {
            return this.d - o.d;
        }
    }
 
}
