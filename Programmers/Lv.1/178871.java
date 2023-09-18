import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        
        HashMap<String, Integer> ranking = new HashMap<>();
        int rank = 0;
        for (String player : players) { ranking.put(player, rank++); } // 순위 넣기
        
        for (String calling : callings) {
            int curRank = ranking.get(calling); // 불린 사람의 순위(앞 사람을 추월함)
            ranking.put(calling, curRank - 1); // 앞 순위로..
            String prev = players[curRank - 1]; // 원래 앞 순위인 사람
            players[curRank - 1] = calling; // 순위 바꿈
            players[curRank] = prev;
            ranking.put(prev, curRank);
        }
        
        return players;
    }
}
