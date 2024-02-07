// 점수 : 0 ~ 10, 보너스 : S, D, T, 옵션 : *, #
// 기회 별로 쪼개서 계산
import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int[] chances = new int[3];
        
        Queue<String> darts = new LinkedList<>();
        String[] dartResultSplitted = dartResult.split("");
        for (String result : dartResultSplitted) {
            darts.add(result);
        }
        
        int idx = 0;
        while (!darts.isEmpty()) {
            String peeked = darts.peek();
            
            if (peeked.equals("S") || peeked.equals("D") || peeked.equals("T")) {
                if (peeked.equals("D")) {
                    chances[idx] *= chances[idx];
                } else if (peeked.equals("T")) {
                    chances[idx] *= chances[idx] * chances[idx];
                }
                idx++;
                
            } else if (peeked.equals("*") || peeked.equals("#")) {
                if (peeked.equals("*")) {
                    if (idx > 1) {
                        chances[idx-2] *= 2;
                    }
                    chances[idx-1] *= 2;
                } else {
                    chances[idx-1] *= -1;
                }
                
            } else {
                chances[idx] = chances[idx] * 10 + Integer.parseInt(peeked);
            }
            darts.poll();
        }
        
        for (int chance : chances) answer += chance;
        
        return answer;
    }
}
