// dfs 풀이
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
        
        dfs(numbers, sum+numbers[idx], idx+1, target);
        dfs(numbers, sum-numbers[idx], idx+1, target);
    }
}

// bfs 풀이
import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        Queue<Integer> q = new LinkedList<>();
        int idx = 0;
        q.offer(0);
        
        while (!q.isEmpty()) {
            if (idx == numbers.length) {
                break;
            }
            
            int l = q.size();
            for (int i=0; i<l; i++) {
                int cur = q.poll();
                q.offer(cur + numbers[idx]);
                q.offer(cur - numbers[idx]);
            }
            idx++;
            
        }
        
        while (!q.isEmpty()) {
            if (q.poll() == target) {
                answer++;
            }
        }
        
        return answer;
    }
}
