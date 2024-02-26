// 일단 완탐
import java.util.*;

class Solution {
    
    static boolean[] visited;
    static String[] selected;
    static Set<Set<String>> answerSet;
    static Set<String> selectedSet;
    
    public int solution(String[] user_id, String[] banned_id) {
        visited = new boolean[user_id.length];
        selected = new String[banned_id.length];
        answerSet = new HashSet<>(new HashSet<>());
        
        recur(0, 0, user_id, banned_id);
        
        return answerSet.size();
    }
    
    static boolean check(String user_id, String banned_id) {
        if (user_id.length() != banned_id.length()) {
            return false;
        } else {
            for (int i=0; i<user_id.length(); i++) {
                if (banned_id.charAt(i) == '*') {
                    continue;
                } else {
                    if (user_id.charAt(i) != banned_id.charAt(i)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    // cur : banned_id의 인덱스
    static void recur(int cur, int cnt, String[] user_id, String[] banned_id) {
        
        if (cnt == banned_id.length) {
            selectedSet = new HashSet<>();
            for (String select : selected) selectedSet.add(select);
            answerSet.add(selectedSet);
            return;
        }
        
        if (cur >= banned_id.length) return;
        
        for (int i=0; i<user_id.length; i++) {
            if (!visited[i] && check(user_id[i], banned_id[cur])) {
                visited[i] = true;
                selected[cur] = user_id[i];
                recur(cur+1, cnt+1, user_id, banned_id);
                visited[i] = false;
            }
        }
    }
}


// 비트마스킹 이용
import java.util.*;

class Solution {
    
    static boolean[] visited;
    static String[] selected;
    static Set<Integer> answerSet;
    
    public int solution(String[] user_id, String[] banned_id) {
        visited = new boolean[user_id.length];
        selected = new String[banned_id.length];
        answerSet = new HashSet<>(new HashSet<>());
        
        recur(0, 0, 0, user_id, banned_id);
        
        return answerSet.size();
    }
    
    static boolean check(String user_id, String banned_id) {
        if (user_id.length() != banned_id.length()) {
            return false;
        } else {
            for (int i=0; i<user_id.length(); i++) {
                if (banned_id.charAt(i) == '*') {
                    continue;
                } else {
                    if (user_id.charAt(i) != banned_id.charAt(i)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    // cur : banned_id의 인덱스
    static void recur(int cur, int cnt, int selectedBit, String[] user_id, String[] banned_id) {
        
        if (cnt == banned_id.length) {
            answerSet.add(selectedBit);
            return;
        }
        
        if (cur >= banned_id.length) return;
        
        for (int i=0; i<user_id.length; i++) {
            if ((selectedBit & (1 << i)) == 0 && check(user_id[i], banned_id[cur])) {
                recur(cur+1, cnt+1, selectedBit | (1 << i), user_id, banned_id);
            }
        }
    }
}
