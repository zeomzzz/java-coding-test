import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        int n = nums.length / 2;
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        
        return answer = Math.min(n, numSet.size());
    }
}
