import java.util.*;

class Solution {
    
    static int[] pattern1 = {1, 2, 3, 4, 5};
    static int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
    static int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    
    public int[] solution(int[] answers) {
        
        int l = answers.length;
        int l1 = pattern1.length;
        int l2 = pattern2.length;
        int l3 = pattern3.length;
        
        int score1 = 0;
        int score2 = 0;
        int score3 = 0;
        
        for (int i=0; i<l; i++) {
            int answer = answers[i];
            if (pattern1[i%l1] == answer) score1++;
            if (pattern2[i%l2] == answer) score2++;
            if (pattern3[i%l3] == answer) score3++;
        }
        
        int max = Math.max(score1, Math.max(score2, score3));
        List<Integer> lst = new LinkedList<>();
        if (score1 == max) lst.add(1);
        if (score2 == max) lst.add(2);
        if (score3 == max) lst.add(3);
        
        int[] answer = new int[lst.size()];
        int idx = 0;
        for (int tmp : lst) {
            answer[idx++] = tmp;
        }
        
        return answer;
    }
}
