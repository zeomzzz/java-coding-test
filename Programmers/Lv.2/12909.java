import java.util.*;

class Solution {
    boolean solution(String s) {
        
        int l = s.length();
        
        if (l % 2 == 1) return false;

        Stack<Character> stack = new Stack<>();
        
        for (int idx=0; idx<l; idx++) {
            char c = s.charAt(idx);
            if (c == '(') {
                stack.push('(');
            } else {
                if (stack.empty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        
        if (stack.size() > 0) return false;

        return true;
    }
}
