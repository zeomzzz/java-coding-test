import java.util.*;

class Solution {
    public int[] solution(String s) {
        // int[] answer = {};
        
        // 1. ","로 끊어서 담기
        List<String> tupleSets = new ArrayList<>();
        String tupleSet = "";
        int sl = s.length();
        for (int i=0; i<sl; i++) {
            if (s.charAt(i) == '}') {
                if (tupleSet.length() > 0) {
                    tupleSets.add(tupleSet);
                    tupleSet = ""; 
                }
            } else if (s.charAt(i) == '{') {
                tupleSet = ""; 
            } else {
                tupleSet += String.valueOf(s.charAt(i));
            }
        }
        
        // 2. 길이 순으로 정렬
        Collections.sort(tupleSets, (o1, o2) -> o1.length() - o2.length());
        
        // 3. 튜플 만들기
        int l = tupleSets.size();
        int[] answer = new int[l];
        Set<Integer> answerSet = new HashSet<>();
        for (int i=0; i<l; i++) {
            // 일단 튜플을 꺼내보자
            String[] tuple = tupleSets.get(i).split(",");
            for (String number : tuple) {
                int num = Integer.parseInt(number);
                int prev = answerSet.size();
                answerSet.add(num);
                int cur = answerSet.size();
                
                if (prev != cur) {
                    answer[i] = num;
                    break;
                }
            }
        }
        
        return answer;
    }
}
