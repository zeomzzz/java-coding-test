import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> wants = new HashMap<>();
        int l = want.length;
        for (int i=0; i<l; i++) {
            wants.put(want[i], number[i]);
        }
        
        // 1. 10개 세팅
        String item = "";
        for (int i=0; i<10; i++) {
            item = discount[i];
            if (wants.containsKey(item)) {
                wants.put(item, wants.get(item) - 1);
            }
        }
        
        // 2. 처음에 검사
        if (check(wants)) {
            answer++;
        }
        
        // 3. 슬라이딩 윈도우
        int start = 0;
        int end = 9;
        String startItem = "";
        String endItem = "";
        while (end < discount.length) {
            startItem = discount[start];
            if (wants.containsKey(startItem)) {
                wants.put(startItem, wants.get(startItem) + 1);
            }
            start++;
            end++;
            if (end < discount.length) {
                endItem = discount[end];
                if (wants.containsKey(endItem)) {
                    wants.put(endItem, wants.get(endItem) - 1);
                }
            }

            if (check(wants)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public boolean check(Map<String, Integer> wants) {
        // System.out.println(wants.toString());
        boolean answer = true;
        for (String key : wants.keySet()) {
            if (wants.get(key) != 0) {
                answer = false;
            }
        }
        return answer;
    }
}
