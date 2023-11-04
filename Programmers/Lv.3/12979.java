class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int right = 0;
        
        for (int station : stations) {
            if (right < station - w) {
                answer += Math.ceil((double)(station - w - 1 - right) / (2 * w + 1));
            }
            if (right < station + w) right = station + w;
            if (right >= n) break;
        }
        
        if (right < n) {
            answer += Math.ceil((double) (n - right) / (2 * w + 1));
        }

        return answer;
    }
}
