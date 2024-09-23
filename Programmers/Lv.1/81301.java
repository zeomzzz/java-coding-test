import java.util.*;

class Solution {
    
    static Map<String, String> numMap;
    
    public int solution(String s) {
        
        numMap = new HashMap<>();
        numMap.put("zero", "0");
        numMap.put("one", "1");
        numMap.put("two", "2");
        numMap.put("three", "3");
        numMap.put("four", "4");
        numMap.put("five", "5");
        numMap.put("six", "6");
        numMap.put("seven", "7");
        numMap.put("eight", "8");
        numMap.put("nine", "9");
        
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while (idx < s.length()) {
            if (s.charAt(idx) >= '0' && s.charAt(idx) <= '9') {
                sb.append(s.substring(idx, idx+1));
                idx++;
            } else {
                if (numMap.containsKey(s.substring(idx, idx+3))) {
                    sb.append(numMap.get(s.substring(idx, idx+3)));
                    idx += 3;
                } else if (numMap.containsKey(s.substring(idx, idx+4))) {
                    sb.append(numMap.get(s.substring(idx, idx+4)));
                    idx += 4;
                } else {
                    sb.append(numMap.get(s.substring(idx, idx+5)));
                    idx += 5;
                }
            }
        }
        
        return Integer.parseInt(sb.toString());
    }
}
