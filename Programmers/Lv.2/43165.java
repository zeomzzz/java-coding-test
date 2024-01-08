import java.util.*;

class Solution {
    static int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        
        dfs(numbers, 0, 0, target);
        
        return answer;
    }
    
    static void dfs(int[] numbers, int sum, int idx, int target) {
        
        if (idx == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }
        
        int[] arr = {1, -1};
        for (int i=0; i<2; i++) {
            dfs(numbers, sum+numbers[idx]*arr[i], idx+1, target);
        }
    }
}
