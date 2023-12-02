class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        int size = section.length;
        int nxt = section[0];
        int idx = 0;
        
        while(idx < size) {
            if (nxt <= section[idx]) {
                nxt = section[idx] + m;
                answer++;
            }
            idx++;
        }
        
        return answer;
    }
}
