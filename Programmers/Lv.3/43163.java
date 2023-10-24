import java.util.*;

class Solution {
    static int l;
    static int answer;
    static int[] visited;
    
    public int solution(String begin, String target, String[] words) {
        l = words.length;
        answer = l;
        visited = new int[l];
        
        backtracking(begin, 0, target, words);
        
        if (answer == l) {
            boolean hasTarget = false;
            for (int i=0; i<words.length; i++) {
                if (words[i].equals(target)) {
                    hasTarget = true;
                    break;
                }
            }
            if (!hasTarget) {
                answer = 0;
            }
        }
        
        return answer;
    }
    
    static void backtracking(String curWord, int depth, String target, String[] words) {
        
        if (curWord.equals(target)) {
            answer = Math.min(answer, depth);
            return;
        }
        
        for (int i=0; i<l; i++) {
            if (visited[i] == 0 && compare(curWord, words[i])) {
                visited[i] = 1;
                backtracking(words[i], depth + 1, target, words);
                visited[i] = 0;
            }
        }
    }
    
    static boolean compare(String word1, String word2) {
        int cnt = 0;
        for (int i=0; i<word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) cnt++;
            if (cnt > 1) return false;
        }
        if (cnt == 1) return true;
        return false;
    }
}
