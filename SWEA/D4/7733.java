import java.util.Scanner;
 
public class Solution {
     
    static int[][] chz;
    static boolean[][] visited;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int n;
 
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
 
        int t = sc.nextInt(); // tc
 
        for (int tc = 1; tc <= t; tc++) {
 
            int max = 0; // 덩어리 개수 max
             
            n = sc.nextInt(); // 치즈 한 변의 길이
            chz = new int[n][n];
            for(int r=0; r<n; r++) {
                for(int c=0; c<n; c++) {
                    chz[r][c] = sc.nextInt();
                }
            }
             
            for(int x=1; x<=100; x++) {
                 
                int cnt = 0;
                 
                for(int r=0; r<n; r++) {
                    for(int c=0; c<n; c++) {
                        if(chz[r][c] == x) chz[r][c] = 0; //x일 째에 맛 x인것 먹기 
                    }
                }
                 
                visited = new boolean[n][n];
                for(int r=0; r<n; r++) {
                    for(int c=0; c<n; c++) {
                        if(chz[r][c] > 0 && !visited[r][c]) {
                            dfs(r, c);
                            cnt++;
                        }
                    }
                }
                 
                max = Math.max(max, cnt);
                 
            } // 1일차, 2일차,,,,
             
            if(max == 0) max = 1; // 덩어리는 모두 먹은 경우 아니면 최소 1개
             
            System.out.printf("#%d %d\n", tc, max);
             
        } // tc
 
    }
     
    public static void dfs(int x, int y) {
         
        visited[x][y] = true;
         
        for(int i=0; i<4; i++) {
            int nr = x + dr[i];
            int nc = y + dc[i];
             
            if(nr>=0 && nr<n && nc>=0 && nc<n && !visited[nr][nc] && chz[nr][nc]>0) {
                dfs(nr, nc);
            }
             
        }
         
    }
 
}
