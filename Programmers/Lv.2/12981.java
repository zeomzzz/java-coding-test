import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int cnt = 0;
        char end = words[0].charAt(0);
        Set<String> used = new HashSet<>();
        
        for (String word : words) {
            cnt++;
            // 1. 앞사람 단어의 마지막 문자로 시작하는가?
            if (end != word.charAt(0)) {
                break;
            }
            used.add(word);
            // 2. 나오지 않았던 단어인가?
            if (used.size() != cnt) {
                break;
            }
            
            end = word.charAt(word.length() - 1);
            
            if (cnt == words.length) {
                return answer;
            }
        }
        
        int idx = cnt % n;
        answer[0] = idx > 0 ? idx : n;
        answer[1] = idx > 0 ? cnt / n + 1 : cnt / n;
        
        return answer;
    }
}
