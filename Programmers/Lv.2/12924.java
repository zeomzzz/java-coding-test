class Solution {
    public int solution(int n) {
        int answer = 0;
        int start = 1; // start 이상
        int end = 2; // end 미만
        int sum = start;
        
        while (start < end) {
            if (sum == n) {
                answer++;
                sum += end++;
            } else if (sum < n) {
                sum += end++;
            } else {
                sum -= start++;
            }
        }
        
        return answer;
    }
}
