import java.util.*;

class Solution {
    
    static Map<Integer, Node> map;
    
    public String solution(int[] numbers, String hand) {
        // String answer = "";
        StringBuilder sb = new StringBuilder();
        
        map = new HashMap<>();
        for (int i=1; i<=9; i++) {
            int r = (i - 1) / 3;
            int c = (i - 1) % 3;
            map.put(i, new Node(r, c));
        }
        map.put(-1, new Node(3, 0));
        map.put(0, new Node(3, 1));
        map.put(-2, new Node(3, 2));
        
        int left = -1; // *
        int right = -2; // #
        for (int num : numbers) {
            if (num % 3 == 1) {
                sb.append("L");
                left = num;
            } else if (num != 0 && num % 3 == 0) {
                sb.append("R");
                right = num;
            } else {
                int leftDistance = distance(left, num);
                int rightDistance = distance(right, num);
                
                if (leftDistance < rightDistance) {
                    sb.append("L");
                    left = num;
                } else if (leftDistance > rightDistance) {
                    sb.append("R");
                    right = num;
                } else {
                    if (hand.equals("right")) {
                        sb.append("R");
                        right = num;
                    } else {
                        sb.append("L");
                        left = num;
                    }
                }
            }
        }
        
        return sb.toString();
    }
    
    static int distance(int cur, int num) {
        Node curNode = map.get(cur);
        Node numNode = map.get(num);
        
        return Math.abs(curNode.r - numNode.r) + Math.abs(curNode.c - numNode.c);
    }
}

class Node {
    int r, c;
    
    Node(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
