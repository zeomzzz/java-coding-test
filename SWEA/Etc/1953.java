import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class Solution {
     
    static int start, n, m;
    static int[][] tunnel;
     
    static int[] dr = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dc = {0, 0, -1, 1};
     
    public static void main(String[] args) {
         
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // tc개수
         
        for(int tc=1; tc<=t; tc++) {
             
            n = sc.nextInt(); // 지도의 세로 크기 n
            m = sc.nextInt(); // 지도의 가로 크기 m
            int r = sc.nextInt(); // 맨홀 위치 세로 r
            int c = sc.nextInt(); // 맨홀 위치 가로 c
            int l = sc.nextInt(); // 탈출에 소요되는 시간 l
             
            tunnel = new int[n][m];
            boolean[][] visited = new boolean[n][m];
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    tunnel[i][j] = sc.nextInt();
                }
            }
             
            Queue<Point> q = new LinkedList<>();
            q.add(new Point(r, c, 1));
             
            int ans = 1;
            visited[r][c] = true;
             
            while(!q.isEmpty()) {
                 
                Point cur = q.poll();
                int cr = cur.r;
                int cc = cur.c;
                int ct = cur.time;
                 
                if(ct == l) break;
                 
                switch (tunnel[cr][cc]) {
                 
                case 1 :
                    for(int i=0; i<4; i++) {
                        int nr = cr + dr[i];
                        int nc = cc + dc[i];
                         
                        if(nr>=0 && nr<n && nc>=0 && nc<m && !visited[nr][nc] && check(nr, nc, i)) {
                            q.add(new Point(nr, nc, ct + 1));
                            ans++;
                            visited[nr][nc] = true;
                        }
                    }
                    break;
                 
                case 2 :
                    for(int i=0; i<2; i++) {
                        int nr = cr + dr[i];
                         
                        if(nr>=0 && nr<n && !visited[nr][cc] && check(nr, cc, i)) {
                            q.add(new Point(nr, cc, ct+1));
                            ans++;
                            visited[nr][cc] = true;
                        }
                    }
                    break;
                 
                case 3 :
                    for(int i=2; i<4; i++) {
                        int nc = cc + dc[i];
                         
                        if(nc>=0 && nc<m && !visited[cr][nc] && check(cr, nc, i)) {
                            q.add(new Point(cr, nc, ct+1));
                            ans++;
                            visited[cr][nc] = true;
                        }
                    }
                    break;
                 
                case 4 :
                    for(int i=0; i<=3; i+=3) {
                        int nr = cr + dr[i];
                        int nc = cc + dc[i];
                         
                        if(nr>=0 && nr<n && nc>=0 && nc<m && !visited[nr][nc] && check(nr, nc, i)) {
                            q.add(new Point(nr, nc, ct+1));
                            ans++;
                            visited[nr][nc] = true;
                        }   
                    }
                    break;
                 
                case 5 :
                    for(int i=1; i<=3; i+=2) {
                        int nr = cr + dr[i];
                        int nc = cc + dc[i];
                         
                        if(nr>=0 && nr<n && nc>=0 && nc<m && !visited[nr][nc] && check(nr, nc, i)) {
                            q.add(new Point(nr, nc, ct+1));
                            ans++;
                            visited[nr][nc] = true;
                        }   
                    }
                    break;
                 
                case 6 :
                    for(int i=1; i<=2; i++) {
                        int nr = cr + dr[i];
                        int nc = cc + dc[i];
                         
                        if(nr>=0 && nr<n && nc>=0 && nc<m && !visited[nr][nc] && check(nr, nc, i)) {
                            q.add(new Point(nr, nc, ct+1));
                            ans++;
                            visited[nr][nc] = true;
                        }   
                    }
                    break;
                 
                case 7 :
                    for(int i=0; i<=2; i+=2) {
                        int nr = cr + dr[i];
                        int nc = cc + dc[i];
                         
                        if(nr>=0 && nr<n && nc>=0 && nc<m && !visited[nr][nc] && check(nr, nc, i)) {
                            q.add(new Point(nr, nc, ct+1));
                            ans++;
                            visited[nr][nc] = true;
                        }   
                    }
                    break;
                }
                 
            } // while
 
            System.out.printf("#%d %d\n", tc, ans);
             
        } // tc
    }
 
    public static class Point{
        int r, c, time;
         
        Point(int r, int c, int time){
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }
     
    static boolean check(int nr, int nc, int d) {
        int pipe = tunnel[nr][nc];
         
        switch(d) {
        case 0 : // 상
            if(pipe == 1 || pipe == 2 || pipe == 5 || pipe == 6) return true;
            else return false;
         
        case 1 : // 하
            if(pipe == 1 || pipe == 2 || pipe == 4 || pipe == 7) return true;
            else return false;
         
        case 2 :  // 좌
            if(pipe == 1 || pipe == 3 || pipe == 4 || pipe == 5) return true;
            else return false;
         
        case 3 :  // 우
            if(pipe == 1 || pipe == 3 || pipe == 6 || pipe == 7) return true;
            else return false;
        }
         
        return false;
         
    }
     
}
