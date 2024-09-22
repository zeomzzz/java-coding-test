import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        // 1. 요청 시점 순으로 정렬
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        
        int curTime = 0; // 현재 시각
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]); // job을 넣음. 걸린 시간 순
        
        int idx = 0;
        while (true) {
            
            // pq에 job 넣기
            while (idx < jobs.length && jobs[idx][0] <= curTime) {
                pq.add(jobs[idx]);
                idx++;
            }
            if (pq.isEmpty()) {
                curTime = jobs[idx][0];
            }
            
            if (!pq.isEmpty()) {
                int[] curJob = pq.poll();
                curTime += curJob[1];
                answer += curTime - curJob[0];
            }
            
            if (idx == jobs.length && pq.isEmpty()) {
                break;
            }
            
        }
        
        answer = answer / jobs.length;
        
        return answer;
    }
}
