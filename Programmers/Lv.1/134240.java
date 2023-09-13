class Solution {
    public String solution(int[] food) {
        String answer = "";
        StringBuffer sb = new StringBuffer();
        StringBuffer sb_reversed = new StringBuffer();
        StringBuffer tmp = new StringBuffer();

        for (int i=1; i<food.length; i++) {
            int cnt = food[i] / 2;
            for (int j=0; j<cnt; j++) { 
                sb.append(Integer.toString(i));
            }
        }
        tmp.append(sb);
        sb_reversed = sb.reverse();
        tmp.append("0");
        tmp.append(sb_reversed);
        
        answer = tmp.toString();
        
        
        return answer;
    }
}
