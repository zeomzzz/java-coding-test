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

// 241103
import java.util.*;

class Solution {
    static int n, answer;
    
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        n = dungeons.length;
        
        Arrays.sort(dungeons, (o1, o2) -> (o2[0] - o2[1]) - (o1[0] - o1[1]));
        
        backtracking(0, k, 0, dungeons);
        
        return answer;
    }
    
    public static void backtracking(int cur, int p, int cnt, int[][] dungeons) {
        
        if (cur == n) {
            answer = Math.max(answer, cnt);
            return;
        }
        
        if (p >= dungeons[cur][0]) { // 이번거 가능
            backtracking (cur+1, p-dungeons[cur][1], cnt+1, dungeons);
        }
        
        // 이번거 안가
        backtracking(cur+1, p, cnt, dungeons);
    }
}
