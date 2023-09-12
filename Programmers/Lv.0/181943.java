class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        
        for (int i=0; i<s; i++) { answer += Character.toString(my_string.charAt(i)); }
        
        answer += overwrite_string;
        int tmp = answer.length();
        if (my_string.length() > s - 1 + overwrite_string.length()) {
            for (int i = tmp; i<my_string.length(); i++) {
                answer += Character.toString(my_string.charAt(i));
            }
        }
        return answer;
    }
}
