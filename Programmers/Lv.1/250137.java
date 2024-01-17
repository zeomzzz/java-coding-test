class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        // int answer = 0;
        int curHealth = health;
        int time = 1;
        int sucCnt = 0;
        for (int[] attack : attacks) { // 공격 시간, 피해량
            // 공격 전까지는 회복
            while (time != attack[0]) {
                sucCnt++;
                curHealth += bandage[1];
                if (curHealth > health) curHealth = health;
                
                // 시전 성공
                if (sucCnt == bandage[0]) {
                    curHealth += bandage[2]; // 추가 체력 회복
                    if (curHealth > health) curHealth = health;
                    sucCnt = 0; // 연속성공 초기화
                }
                
                time++;
            }
            
            // 공격 당함
            sucCnt = 0;
            curHealth -= attack[1];
            if (curHealth <= 0) {
                return -1;
            }
            time++;
        }
        
        return curHealth;
    }
}
