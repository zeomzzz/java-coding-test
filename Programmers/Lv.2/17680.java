import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
        Queue<String> cache = new LinkedList<>();
        String cityLowered = "";
        
        for (String city : cities) {
            cityLowered = city.toLowerCase();
            if (cache.contains(cityLowered)) { // cache hit
                answer += 1;
                cache.remove(cityLowered);
                cache.offer(cityLowered);
            } else { // cache miss
                if (cache.size() < cacheSize) {
                    cache.offer(cityLowered);
                } else {
                    cache.poll();
                    cache.offer(cityLowered);
                }
                answer += 5;
            }
        }
        
        return answer;
    }
}
