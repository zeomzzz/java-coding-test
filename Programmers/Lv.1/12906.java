// Stack에 넣고 꺼내기
import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer;
        
        Stack<Integer> stack = new Stack<>();
        int l = arr.length;
        for (int i=0; i<l; i++) {
            int tmp = arr[i];
            if (!stack.empty()) {
                if (stack.peek() != tmp) {
                    stack.push(tmp);
                }
            } else {
                stack.push(tmp);
            }
        }
        
        int sl = stack.size();
        answer = new int[sl];
        for (int i=sl-1; i>=0; i--) {
            answer[i] = stack.pop();
        }
        
        return answer;
    }
}

// 240916
import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int l = arr.length;
        
        Stack<Integer> stack = new Stack<>();
        for (int i=l-1; i>=0; i--) {
            if (stack.empty()) {
                stack.push(arr[i]);
            } else if (stack.peek() != arr[i]) {
                stack.push(arr[i]);
            }
        }
        
        int[] answer = new int[stack.size()];
        int idx = 0;
        while (!stack.empty()) {
            answer[idx++] = stack.pop();
        }
        
        return answer;
    }
}
