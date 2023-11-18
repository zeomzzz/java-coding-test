import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int same = 0;
        int zero = 0;
        
        int[] visited = new int[46];
        
        for (int num : win_nums) {
            visited[num] = 1;
        }
        
        for (int lotto : lottos) {
            if (lotto == 0) {
                zero++;
            } else if (visited[lotto] == 1) {
                same++;
            }
        }
        
        answer[0] = get_rank(same + zero);
        answer[1] = get_rank(same);
        
        return answer;
    }
    
    public int get_rank(int cnt) {
        if (cnt == 6) {
            return 1;
        } else if (cnt == 5) {
            return 2;
        } else if (cnt == 4) {
            return 3;
        } else if (cnt == 3) {
            return 4;
        } else if (cnt == 2) {
            return 5;
        } 
        
        return 6;
        
    }
}
