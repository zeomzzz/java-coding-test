import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        int camera = -30001;
        
        // 진출 지점 기준으로 오름차순 정렬
        Arrays.sort(routes, Comparator.comparingInt((int[] o) -> o[1]));
        for (int[] route : routes) {
            if (camera < route[0]) {
                answer++;
                camera = route[1];
            }
        }
        
        return answer;
    }
}
