import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int l = prices.length;
        int[] answer = new int[l];
        Stack<Integer> stack = new Stack<>();
        
        for (int i=0; i<l; i++) {
            while (!stack.empty() && prices[i] < prices[stack.peek()]) {
                int tmp = stack.pop();
                answer[tmp] = i - tmp;
            }
            stack.push(i);
        }
        
        while (!stack.empty()) {
            int tmp = stack.pop();
            answer[tmp] = l - tmp - 1;
        }
        
        return answer;
    }
}
