// 1. 일단, 전체를 bfs 돌리고, 석유 덩어리의 양 구한다. 이 때, 넘버링도 해준다
// 2. 아래로 내려가면서 set에 덩어리의 번호를 담고, add true인 경우에만 석유 양에 합침
import java.util.*;

class Solution {
    public int solution(int[][] land) {
        int answer = 0;
        int n = land.length; // 세로
        int m = land[0].length; // 가로
        
        int[][] oilNums = new int[n][m];
        Map<Integer, Integer> oilSize = new HashMap<>();
        Queue<int[]> q;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int index = 0;
        for (int r=0; r<n; r++) {
            for (int c=0; c<m; c++) {
                if (land[r][c] == 1) {
                    int size = 0;
                    // bfs
                    q = new LinkedList<>();
                    q.add(new int[]{r, c});
                    
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        int curR = cur[0];
                        int curC = cur[1];
                        
                        if (land[curR][curC] != 1) continue;
                        oilNums[curR][curC] = index; // 덩어리인덱스 표시
                        size++;
                        land[curR][curC]++; // 방문 표시
                        
                        for (int i=0; i<4; i++) {
                            int nxtR = curR + dr[i];
                            int nxtC = curC + dc[i];
                            
                            if (nxtR >= 0 && nxtR < n && nxtC >= 0 && nxtC < m) {
                                if (land[nxtR][nxtC] == 1) {
                                    q.add(new int[]{nxtR, nxtC});
                                }
                            }
                        }
                    } // q
                    
                    oilSize.put(index, size);
                    index++;
                }
            }
        }
        
        Set<Integer> oilIndexSet;
        for (int c=0; c<m; c++) {
            int tmp = 0;
            oilIndexSet = new HashSet<>();
            for (int r=0; r<n; r++) {
                if (land[r][c] != 0) {
                    int oilIndex = oilNums[r][c];
                    if (oilIndexSet.add(oilIndex)) {
                        tmp += oilSize.get(oilIndex);
                    }
                }
            }
            answer = Math.max(answer, tmp);
        }
        return answer;
    }
}
