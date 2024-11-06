import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        
        StringBuilder sb = new StringBuilder();
        int l = number.length();
        int n = l - k; // n개를 골라야 함
        
        // i번째 수를 고름 : 이전 인덱스+1 ~ (n-i)개 남기는 인덱스 중 제일 큰 것
        int prevIdx = 0;
        for (int i=1; i<=n; i++) {
            char max = '0'-1;
            int maxIdx = 0;
            for (int j=prevIdx; j<l-(n-i); j++) {
                if (max < number.charAt(j)) {
                    max = number.charAt(j);
                    maxIdx = j;
                }
            }
            sb.append(String.valueOf(max));
            prevIdx = maxIdx + 1;
        }
        return sb.toString();
    }
}
