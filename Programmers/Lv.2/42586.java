// 1. Queue에 인덱스를 넣고
// 2. 인덱스로 접근해서 progresses를 업데이트
// 3. 이전 것이 배포되어야 배포 가능 -> isDeploy로 판단

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answerList = new ArrayList<>();
        int n = progresses.length;
        
        // 1. Queue에 인덱스 넣기
        Queue<Integer> idxQ = new LinkedList<>();
        for (int idx=0; idx<n; idx++) {
            idxQ.offer(idx);
        }
        
        // 2. Queue 돌리면서 progress 업데이트
        int cur = 0;
        int l = 0;
        while (idxQ.size() > 0) {
            boolean isDeploy = true;
            int cnt = 0;
            l = idxQ.size();
            for (int i=0; i<l; i++) {
                cur = idxQ.poll();
                progresses[cur] += speeds[cur];
                
                // 배포여부 결정
                if (isDeploy && progresses[cur] >= 100) {
                    cnt++;
                } else {
                    isDeploy = false;
                    idxQ.offer(cur);
                }
            }
            
            if (cnt > 0) {
                answerList.add(cnt);
            }
        }
        
        int[] answer = new int[answerList.size()];
        int idx = 0;
        for (int cnt : answerList) {
            answer[idx++] = cnt;
        }
        
        return answer;
    }
}

// 240111
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answerList = new ArrayList<>();
        
        // 1. progresses, speeds를 큐에 넣기
        Queue<Integer> progressesQ = new LinkedList<>();
        Queue<Integer> speedsQ = new LinkedList<>();
        for (int progress : progresses) {
            progressesQ.offer(progress);
        }
        for (int speed : speeds) {
            speedsQ.offer(speed);
        }
        
        // progress가 다 끝날 때까지
        while (!progressesQ.isEmpty()) {
            
            // 2. 한 바퀴 돌면서 작업
            for (int i=0; i<progressesQ.size(); i++) {
                int progress = progressesQ.poll();
                int speed = speedsQ.poll();
                progressesQ.offer(progress+speed);
                speedsQ.offer(speed);
            }
            
            // 3. peek으로 확인해서 poll할 수 있을 때까지 poll
            int cnt = 0;
            while (!progressesQ.isEmpty() && progressesQ.peek() >= 100) {
                progressesQ.poll();
                speedsQ.poll();
                cnt++;
            }
            
            if (cnt != 0) {
                answerList.add(cnt);
            }
        }
        
        int[] answer = new int[answerList.size()];
        for (int i=0; i<answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}
