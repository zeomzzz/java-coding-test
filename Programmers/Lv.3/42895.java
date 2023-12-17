// 1. dp[i] : i개로 만들 수 있는 조합의 개수
// 2. dp[i] = dp[i-j] + dp[j]

import java.util.*;

class Solution {
    public int solution(int N, int number) {
        
        if (N == number) return 1;
        
        Set<Integer>[] dp = new HashSet[9]; // 8보다 크면 -1 return 하므로
        int num = 0;
        for (int i=1; i<9; i++) {
            num = 10 * num + N;
            dp[i] = new HashSet<>();
            dp[i].add(num);
        }
        
        for (int i=2; i<9; i++) {
            for (int j=1; j<i; j++) {
                for (Integer a : dp[j]) {
                    for (Integer b : dp[i-j]) {
                        dp[i].add(a+b);
                        if (a-b>0) dp[i].add(a-b);
                        dp[i].add(a*b);
                        if (b>0) dp[i].add(a/b);
                        if (a>0) dp[i].add(b/a);
                    }
                }
            }
            if (dp[i].contains(number)) {
                return i;
            }
        }
        
        return -1;
    }
}
