import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        // 1. pq에 스코빌 지수를 담음
        for (int scov : scoville) {
            pq.offer(scov);
        }
        
        // 2. 음식을 섞기
        while (pq.peek() < K) {
            if (pq.size() == 1) {
                answer = -1;
                break;
            }
            
            int food1 = pq.poll();            
            int food2 = pq.poll();
            pq.offer(food1 + food2 * 2);
            answer++;
        }
        
        return answer;
    }
}
