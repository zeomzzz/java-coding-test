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
