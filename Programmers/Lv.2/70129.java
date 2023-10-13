class Solution {
    public int[] solution(String s) {
        int[] answer = {0, 0}; // [0] : 변환 횟수, [1] : 제거된 0의 갯수
        
        String result = s;
        
        while (!result.equals("1")) {
            answer[0]++;
            String tmp = "";
            
            for (int i=0; i<result.length(); i++) {
                if (result.charAt(i) == '0') {
                    answer[1]++;
                } else {
                    tmp += Character.toString(result.charAt(i));
                }
            }
            result = Integer.toBinaryString(tmp.length());
        }
        
        return answer;
    }
}
