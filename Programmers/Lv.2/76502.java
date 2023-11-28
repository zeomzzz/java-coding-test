import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        ArrayList<String> list = new ArrayList<>(Arrays.asList(s.split("")));
        Stack<String> stack = new Stack<>();
        int l = list.size();
        
        for (int i=0; i<l; i++) {
            stack.empty();
            for (int j=0; j<l; j++) {
                String q = list.get(j);
                if (stack.isEmpty()) {
                    if (q.equals("(") || q.equals("[") || q.equals("{")) {
                        stack.add(q);
                    } else {
                        break;
                    }
                } else {
                    String p = stack.peek();
                    if (p.equals("(")) {
                        if (q.equals(")")) {
                            stack.pop();
                        } else if (q.equals("}") || q.equals("]")) {
                            break;
                        } else {
                            stack.add(q);
                        }
                    }
                    if (p.equals("{")) {
                        if (q.equals("}")) {
                            stack.pop();
                        } else if (q.equals(")") || q.equals("]")) {
                            break;
                        } else {
                            stack.add(q);
                        }
                    }
                    if (p.equals("[")) {
                        if (q.equals("]")) {
                            stack.pop();
                        } else if (q.equals(")") || q.equals("}")) {
                            break;
                        } else {
                            stack.add(q);
                        }
                    }
                }
                
                if (j == (l-1) && stack.isEmpty()) {
                answer++;
                }
            }
            
            String start = list.remove(0);
            list.add(start);
        }
        
        return answer;
    }
}
