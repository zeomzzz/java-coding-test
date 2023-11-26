import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        if (k == 1) {
            return 1;
        }
        
        Map<String, Integer> sizes = new HashMap<>();
        
        for (int size : tangerine) {
            String key = Integer.toString(size);
            if(sizes.containsKey(key)) {
                int value = sizes.get(key);
                sizes.put(key, ++value); // value를 갱신
                if (value == k) {
                    return 1;
                }
            } else {
                sizes.put(key, 1);
            }
        }
        
        List<String> keys = new ArrayList<>(sizes.keySet());
        Collections.sort(keys, (v1, v2) -> (sizes.get(v2).compareTo(sizes.get(v1))));
        
        int limit = k;
        for (String size : keys) {
            answer++;
            limit -= sizes.get(size);
            if (limit <= 0) {
                break;
            }
        }
        
        return answer;
    }
}

// 다른 풀이 : getOrDefault 이용
import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        if (k == 1) {
            return 1;
        }
        
        Map<Integer, Integer> sizes = new HashMap<>();
        
        for (int size : tangerine) {
            sizes.put(size, sizes.getOrDefault(size, 0) + 1);
        }
        
        List<Integer> keys = new ArrayList<>(sizes.keySet());
        Collections.sort(keys, (v1, v2) -> (sizes.get(v2).compareTo(sizes.get(v1))));
        
        int limit = k;
        for (int size : keys) {
            answer++;
            limit -= sizes.get(size);
            if (limit <= 0) {
                break;
            }
        }
        
        return answer;
    }
}
