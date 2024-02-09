// 1. 누적 시간을 구한다.
// 차량 번호를 key로 하는 map에 IN 시간 저장 + OUT 할 때 remove
// 누적 시간을 차량 번호를 key로 하는 treemap에 저장
// map이 빌 때까지 시간 누적
// 2. 누적 결과로 요금 계산
import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        Map<Integer, Integer> inTimeMap = new HashMap<>();
        Map<Integer, Integer> totalTimeMap = new TreeMap<>();
        
        // 1. 누적 시간 구하기
        for (String record : records) {
            String[] recordSplitted = record.split(" ");
            int time = timeToMin(recordSplitted[0]);
            int carNum = Integer.parseInt(recordSplitted[1]);
            if (recordSplitted[2].equals("IN")) {
                inTimeMap.put(carNum, time);
            } else {
                int inTime = inTimeMap.get(carNum);
                totalTimeMap.put(carNum, totalTimeMap.getOrDefault(carNum, 0) + time - inTime);
                inTimeMap.remove(carNum);
            }
        }
        
        for (int carNum : inTimeMap.keySet()) {
            totalTimeMap.put(carNum, totalTimeMap.getOrDefault(carNum, 0) + timeToMin("23:59") - inTimeMap.get(carNum));
        }
        
        List<Integer> totalFees = new LinkedList<>();
        for (int carNum : totalTimeMap.keySet()) {
            int totalTime = totalTimeMap.get(carNum);
            if (totalTime <= fees[0]) {
                totalFees.add(fees[1]);
            } else {
                int tmpFee = fees[1];
                int leftTime = totalTime - fees[0];
                if (leftTime % fees[2] == 0) {
                    tmpFee += (leftTime / fees[2]) * fees[3];
                } else {
                    tmpFee += ((leftTime / fees[2]) + 1) * fees[3];
                }
                totalFees.add(tmpFee);
            }
        }
        
        int[] answer = new int[totalFees.size()];
        int idx = 0;
        for (int totalFee : totalFees) {
            answer[idx] = totalFee;
            idx++;
        }
        
        return answer;
    }
    
    static int timeToMin(String time) {
        int hour = 0;
        int minute = 0;
        if (!time.substring(0, 2).equals("00")) hour = Integer.parseInt(time.substring(0, 2));
        if (!time.substring(3).equals("00")) minute = Integer.parseInt(time.substring(3));
        return hour * 60 + minute;
    }
}
