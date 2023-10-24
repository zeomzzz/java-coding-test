import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        int start = 0;
        int end = people.length - 1;
        
        while (start <= end) {
            
            if (start == end) {
                answer ++;
                break;
            } else {
                if (people[start] + people[end] <= limit) { // 둘 다 탑승
                    answer ++;
                    start ++;
                    end --;
                } else { // 무거운 사람만 탑승
                    end --;
                    answer ++;
                }
            }
            
        }
        
        return answer;
    }
}
