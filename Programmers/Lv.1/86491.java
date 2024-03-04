import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        
        int max1 = 0;
        int max2 = 0;
        
        for (int[] size : sizes) {
            int big = 0;
            int small = 0;
            if (size[0] <= size[1]) {
                small = size[0];
                big = size[1];
            } else {
                small = size[1];
                big = size[0];
            }
            
            max1 = Math.max(max1, small);
            max2 = Math.max(max2, big);
        }
        
        return max1*max2;
    }
}
