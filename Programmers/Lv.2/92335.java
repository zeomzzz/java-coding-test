// 1. n을 k진수로 바꾸기
// 2. 0 기준으로 split
// 3. 소수 개수 확인
import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String str = Integer.toString(n, k);
        String[] numsStr = str.split("0");
        ArrayList<Long> nums = new ArrayList<>();
        for (int i=0; i<numsStr.length; i++) {
            if (numsStr[i].length() > 0) {
                nums.add(Long.parseLong(numsStr[i]));
            }
        }
        
        for (long num : nums) {
            if (isPrime(num)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    static boolean isPrime(long n) {
        int cnt = 0;
        for (long i=1; i<=Math.pow(n, 0.5); i++) {
            if (n % i == 0) {
                if (i * i == n) {
                    return false;
                } else {
                    cnt += 2;
                }
                if (cnt > 2) return false;
            }
        }
        
        if (cnt == 2) {
            return true;
        }
        return false;
    }
}
