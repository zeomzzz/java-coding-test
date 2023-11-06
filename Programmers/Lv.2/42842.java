class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        
        for (int h=3; h< total; h++) { // h가 세로
            int w = total / h;
            if (w * h == total) { // 가로 w를 구할 수 있음
                if (2 * w + 2 * h - 4 == brown) {
                    answer[0] = w;
                    answer[1] = h;
                    break;
                }
            }
        }
        
        return answer;
    }
}
