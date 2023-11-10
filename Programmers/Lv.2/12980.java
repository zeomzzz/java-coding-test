import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        int result = n;
        
        while (result > 0) {
            if (result % 2 == 1) {
                ans++;
                result--;
            } else {
                result /= 2;
            }
        }
        return ans;
    }
}
