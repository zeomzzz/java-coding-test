import java.util.*;

class Solution {
    public String solution(String new_id) {
        String tmp = new_id;
        String answer = "";
        
        StringBuilder sb;
        while (true) {
            // 1단계
            answer = tmp.toLowerCase();
            
            // 2단계
            sb = new StringBuilder();
            for (int i=0; i<answer.length(); i++) {
                char c = answer.charAt(i);
                if ((c >= 'a' && c <= 'z') || c >= '0' && c <= '9' || c == '-' || c == '_' || c == '.') {
                    sb.append(String.valueOf(c));
                }
            }
            answer = sb.toString();
            for (int i=0; i<answer.length(); i++) {
                answer = answer.replace("..", ".");
            }

            // 4단계
            sb = new StringBuilder(answer);
            if (answer.charAt(answer.length() - 1) == '.') sb.deleteCharAt(answer.length() - 1);
            if (sb.length() > 0 && answer.charAt(0) == '.') sb.deleteCharAt(0);
            answer = sb.toString();

            // 5단계
            if (answer.isEmpty()) answer = "a";

            // 6단계
            if (answer.length() > 15) answer = answer.substring(0, 15);

            // 7단계
            sb = new StringBuilder(answer);
            while (sb.length() < 3) sb.append(sb.charAt(sb.length() - 1));
            answer = sb.toString();
            
            if (tmp.equals(answer)) break;
            tmp = answer;
        }
        
        return answer;
    }
}
