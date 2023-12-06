import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> types = new HashMap<>();
        int l = clothes.length;
        
        for (int i=0; i<l; i++) {
            types.put(clothes[i][1], types.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        List<String> clothTypes = new ArrayList<>(types.keySet());
        for (String type : clothTypes) {
            answer *= types.get(type) + 1;
        }
        
        answer--;
        
        return answer;
    }
}
