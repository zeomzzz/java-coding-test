class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        
        for (int h=3; h< total; h++) { // h가 세로
            int w = total / h;
            if (w * h == total) { // 가로 w를 구할 수 있음
                if (2 * w + 2 * h - 4 == brown) {
                    answer[0] = w;
                    answer[1] = h;
                    break;
                }
            }
        }
        
        return answer;
    }
}

// 241107
import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int w = 0;
        int h = 0;
        outer : for (int i=1; i<2500; i++) { // 가로
            for (int j=1; j<=i; j++) { // 세로
                if (2*i + 2*j - 4 == brown) {
                    if ((i-2) * (j-2) == yellow) {
                        w = i;
                        h = j;
                        break outer;
                    }
                }
            }
        }
        
        answer[0] = w;
        answer[1] = h;
        
        return answer;
    }
}
