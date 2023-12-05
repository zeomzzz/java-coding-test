import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int playerNum = stages.length;
        
        // 1. 스테이지 별로 클리어하지 못한 사용자의 수 구하기
        int[] fails = new int[N+1];
        for (int stage : stages) {
            if (stage != N+1) {
                fails[stage]++;
            }
        }
        
        // 2. 스테이지별 실패율 저장
        Map<Integer, Double> failure = new HashMap<>();
        for (int i=1; i<=N; i++) {
            if (playerNum != 0) {
                failure.put(i, fails[i] / (double) playerNum);
            } else {
                failure.put(i, (double) 0);
            }
            
            playerNum -= fails[i];
        }
        
        // 3. value에 따라 failure Map을 정렬
        List<Integer> stageList = new ArrayList<>(failure.keySet());
        Collections.sort(stageList, (v1, v2) -> (failure.get(v2).compareTo(failure.get(v1))));
        int[] answer = new int[N];
        for (int i=0; i<N; i++) {
            answer[i] = stageList.get(i);
        }
        
        return answer;
    }
}
