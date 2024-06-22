// 1. map으로 각 토핑이 몇 개씩 있는지 구하고 모두 형에게 할당
// 2. 한 칸 씩 옮기면서 Set에 넣으며 동생에게 할당
// 3. 길이가 같으면 answer++, 동생의 길이가 더 길어지면 그만
import java.util.*;

class Solution {
    
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> toppingMap = new HashMap<>();
        for (int top : topping) {
            toppingMap.put(top, toppingMap.getOrDefault(top, 0) + 1);
        }
        
        Set<Integer> broSet = new HashSet<>();
        for (int top : topping) {
            broSet.add(top);
            toppingMap.put(top, toppingMap.get(top) - 1);
            if (toppingMap.get(top) == 0) toppingMap.remove(top);
            if (toppingMap.size() == broSet.size()) {
                answer++;
            } else if (toppingMap.size() < broSet.size()) {
                break;
            }
        }
        
        return answer;
    }
}
