// 완탐으로 구한다면 : (t-1)*m + p 개를 미리 구하고 / 인덱스를 m으로 나눴을 때 나머지가 p-1인 수

import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        
        List<String> results = new ArrayList<>();
        int num = 0;
        while (results.size() < (t-1)*m + p) {
            String numN = Integer.toString(num++, n); // n진수로 num을 바꿈
            String[] numNSplitted = numN.split("");
            for (String numNSplit : numNSplitted) {
                results.add(numNSplit);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i=p-1; i<(t-1)*m + p; i+=m) {
            sb.append(results.get(i).toUpperCase());
        }
        
        String answer = sb.toString();
        
        return answer;
    }
}
