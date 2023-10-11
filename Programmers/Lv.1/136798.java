class Solution {
    static int[] nums;
    
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for (int i=1; i<=number; i++) { // i의 약수 개수 구하기
            int cnt = 0;
            for (int j=1; j*j<=i; j++) {
                if (i % j == 0) {
                    if (j*j == i) cnt++;
                    else cnt += 2;
                }
            }
            
            answer = (cnt <= limit) ? answer + cnt : answer + power;
        }
        
        return answer;
    }
}
