class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int n = board.length;
        
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        String color = board[h][w];
        
        for (int i=0; i<4; i++) {
            int nr = h + dr[i];
            int nc = w + dc[i];
            
            if (0 <= nr && nr < n && 0 <= nc && nc < n) {
                if (board[nr][nc].equals(color)) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}
