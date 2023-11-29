import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        int l = completion.length;
    
        
        for (int i=0; i<l; i++) {
            if (!participant[i].equals(completion[i])) {
                return participant[i];
            }
        }
        
        return participant[l];
        
    }
}
