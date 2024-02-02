import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> dic = new HashMap<>();
        int l = msg.length();
        // 1. A ~ Z 초기화
        for (int i=0; i<26; i++) {
            dic.put(String.valueOf((char)('A'+i)), i+1);
        }
        
        // 2. 검사
        int s = 0;
        int e = 1;
        int idx = 27;
        while (true) {
            String cur = msg.substring(s, e);
            if (e<l) { // 다음이 가능
                String nxt = msg.substring(s, e+1);
            
                if (dic.containsKey(cur) && !dic.containsKey(nxt)) {
                    result.add(dic.get(cur));
                    dic.put(nxt, idx++);
                    s = e;
                    e = s+1;
                } else {
                    e++;
                }
            } else { // 다음이 불가능
                if (!dic.containsKey(cur)) {
                    dic.put(cur, idx); // 없으면 넣고
                }
                result.add(dic.get(cur)); // 추가
                break;
            }
        }
        
        // 정답 만들기
        int[] answer = new int[result.size()];
        for (int i=0; i<result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}
