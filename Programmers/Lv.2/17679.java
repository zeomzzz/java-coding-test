import java.util.*;

// 0. board를 2차원 배열로
// 1. 2X2 검사해서 visited에 표시
// 2. 아무것도 없으면 끝내고, 아니면 없애기
// 3. 떨어뜨리기
class Solution {
    
    static char[][] blocks;
    static int cnt = 0;
    static Queue<int[]> toDelete = new LinkedList<>();
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        blocks = new char[m][n];
        for (int i=0; i<m; i++) blocks[i] = board[i].toCharArray();
        
        while (true) {
            cnt = 0;
            check(m, n);
            if (toDelete.isEmpty()) break;
            delete(m, n);
            move(m, n);
        }
        
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (blocks[i][j] == 'x') answer++;
            }
        }
        
        return answer;
    }
    
    static void check(int m, int n) {
        for (int r=0; r<m-1; r++) {
            for (int c=0; c<n-1; c++) {
                char cur = blocks[r][c];
                if (cur == 'x') continue;
                if (cur == blocks[r+1][c] && cur == blocks[r][c+1] && cur == blocks[r+1][c+1]) {
                    toDelete.offer(new int[]{r, c});
                    toDelete.offer(new int[]{r+1, c});
                    toDelete.offer(new int[]{r, c+1});
                    toDelete.offer(new int[]{r+1, c+1});
                }
            }
        }
    }
    
    static void delete(int m, int n) {
        int[] tmp = new int[2];
        while (!toDelete.isEmpty()) {
            tmp = toDelete.poll();
            blocks[tmp[0]][tmp[1]] = 'x';
        }
    }
    
    static void move(int m, int n) {
        Queue<Character> q = new LinkedList<>();
        for (int c=0; c<n; c++) {
            q.clear();
            for (int r=m-1; r>=0; r--) {
                if (blocks[r][c] != 'x') {
                    q.offer(blocks[r][c]);
                }
            }
            // 다시 입력
            for (int r=m-1; r>=0; r--) {
                if (q.isEmpty()) {
                    blocks[r][c] = 'x';
                } else {
                    blocks[r][c] = q.poll();
                }
            }
        }
    }
}
