import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int l = citations.length;
        
        Arrays.sort(citations);
        
        int hIndex = l;
        for (int i=0; i<l; i++) {
            hIndex = l-i;
            if (citations[i] >= hIndex) {
                answer = hIndex;
                break;
            }
        }
        
        return answer;
    }
}
