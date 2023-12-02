class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        int idx = 0;
        int l = section.length;
        int start = section[idx];
        int end = start + m - 1;
        
        while (end < n+1 && idx < l) {
            if (section[idx] > end) {
                start = section[idx];
                end = start + m - 1;
                answer++;
            } 
            idx++;
        }
        
        return answer;
    }
}
