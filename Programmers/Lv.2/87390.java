class Solution {
    public int[] solution(int n, long left, long right) {
        int l = (int) (right - left) + 1;
        int[] answer = new int[l];
        
        long idx = 0;
        int r = 0;
        int c = 0;
        
        for (long i=0; i<l; i++) {
            idx = left + i;
            r = (int) (idx / (long) n);
            c = (int) (idx % (long) n);
            
            if (c <= r) {
                answer[(int)i] = r+1;
            } else {
                answer[(int)i] = c+1;
            }
        }
        
        return answer;
    }
}
