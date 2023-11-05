import java.util.*;

class Solution {
    public int solution(String s) {
        
        Deque<Character> deque = new LinkedList<>();
        deque.add(s.charAt(0));
        for (int i=1; i<s.length(); i++) {
            if (deque.size() == 0) {
                deque.add(s.charAt(i));
            } else {
                int end = deque.peekLast();
                if (end == s.charAt(i)) {
                    deque.removeLast();
                } else {
                    deque.add(s.charAt(i));
                }
            }
        }
        
        if (deque.size() == 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
