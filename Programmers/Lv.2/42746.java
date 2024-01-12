import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        int l = numbers.length;
        String[] strNums = new String[l];
        
        for (int i=0; i<l; i++) {
            strNums[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(strNums, (o1, o2) -> {
           return (o2+o1).compareTo(o1+o2); 
        });
        
        for (String str : strNums) {
            answer += str;
        }
        
        if (answer.charAt(0) == '0') {
            return "0";
        }
        
        return answer;
    }
}
