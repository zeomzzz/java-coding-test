/*
* 1. 3개를 고르고 합을 구함 (backtracking)
* 2. 소수인지 확인
*/

class Solution {
    
    static int answer;
    
    public int solution(int[] nums) {
        answer = 0;
        
        backtracking(0, 0, 0, nums);
        
        return answer;
    }
    
    public boolean isPrime(int sum) {
        for (int i=2; i*i<=sum; i++) {
            if(sum % i == 0) return false;
        }
        return true;
    }
    
    public void backtracking(int idx, int sum, int depth, int[] nums) {
        
        if (depth == 3) {
            if (isPrime(sum)) {
                answer += 1;
                return;
            }
        } else {
            for (int i=idx; i<nums.length; i++) backtracking(i+1, sum+nums[i], depth+1, nums);
        }
    }
}
