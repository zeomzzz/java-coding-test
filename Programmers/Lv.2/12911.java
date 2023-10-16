class Solution {
    public int solution(int n) {
        int answer = 0;
        int cnt = Integer.bitCount(n);
        
        int tmp = n+1;
        while(true) {
            if (Integer.bitCount(tmp) == cnt) {
                answer = tmp;
                break;
            }
            tmp++;
        }
        
        return answer;
    }
}
