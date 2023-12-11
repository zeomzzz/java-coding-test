import java.util.*;

class Solution {
    static int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        int l = dungeons.length;
        int[] visited = new int[l];
        
        backtracking(k, dungeons, visited, 0);
        
        return answer;
    }
    
    public void backtracking(int k, int[][] dungeons, int[] visited, int cnt) {
        answer = Math.max(answer, cnt);
        int l = dungeons.length;
        for (int i=0; i<l; i++) {
            if (visited[i] == 0 && k >= dungeons[i][0]) { // 탐험 가능한 경우
                visited[i] = 1; // 탐험
                backtracking(k - dungeons[i][1], dungeons, visited, cnt + 1);
                visited[i] = 0; // 원복
            }
        }
    }
}
