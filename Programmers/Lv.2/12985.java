import java.util.*;

class Solution {
    public int solution(int n, int a, int b) {
        int answer = 1;
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        
        while (max - min != 1 || max % 2 != 0) {
            max = max / 2 + max % 2;
            min = min / 2 + min % 2;
            answer++;
        }
        
        return answer;
    }
}
