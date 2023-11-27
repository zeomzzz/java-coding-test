import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        
        int l = elements.length;
        int[][] sums = new int[l][l];
        Set<Integer> uniqueSums = new HashSet<>();
        
        for(int i=0; i<l; i++) {
            sums[0][i] = elements[i];
            uniqueSums.add(sums[0][i]);
        }
        
        for(int r=1; r<l; r++) {
            for(int c=0; c<l; c++) {
                sums[r][c] = sums[0][c] + sums[r-1][(c-1+l) % l];
                uniqueSums.add(sums[r][c]);
            }
        }
        
        return uniqueSums.size();
    }
}
