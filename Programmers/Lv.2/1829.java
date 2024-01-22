import java.util.*;

class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        for (int r=0; r<m; r++) {
            for (int c=0; c<n; c++) {
                if (picture[r][c] != 0 && !visited[r][c]) {
                    int size = 0;
                    numberOfArea++;
                    q.clear();
                    
                    q.offer(new int[]{r, c});
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        int curR = cur[0];
                        int curC = cur[1];
                        int curColor = picture[curR][curC];
                        
                        if (visited[curR][curC]) continue;
                        visited[curR][curC] = true;
                        size++;
                        
                        for (int i=0; i<4; i++) {
                            
                            int nxtR = curR + dr[i];
                            int nxtC = curC + dc[i];
                            
                            if (nxtR < 0 || nxtR >= m || nxtC < 0 || nxtC >= n) continue;
                            if (visited[nxtR][nxtC] || curColor != picture[nxtR][nxtC]) continue;
                            q.offer(new int[]{nxtR, nxtC});
                        }
                    }
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, size);
                }
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        
        return answer;
    }
}
