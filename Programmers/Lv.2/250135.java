// 분침, 초침 : 분침은 60*60초에 한 바퀴, 초침은 그 동안 60바퀴 -> 60*60 / 59초에 한 번 울림
// 시침, 초침 : 시침은 12*60*60초에 한 바퀴, 초침은 그동안 720바퀴 -> 12*60*60 / 719초에 한 번 울림
// 00시, 12시에는 다 겹쳐서 count -1

import java.util.*;

class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = -1;
        int time1 = timeToSec(h1, m1, s1);
        int time2 = timeToSec(h2, m2, s2);
        
        answer = countAlarm(time2) - countAlarm(time1) + isAlarmTime(time1);
        
        return answer;
    }
    
    int countAlarm(int time) {
        int count = 0;
        
        count += time * 59 / (60 * 60);
        count += time * 719 / (12 * 60 * 60);
        // 낮 12시 포함되면 -2, 아니면 -1
        if (time >= 12*60*60) {
            count -= 2;
        } else {
            count--;
        }
        
        return count;
    }
    
    int timeToSec(int h, int m, int s) {
        return h*60*60 + m*60 + s;
    }
    
    int isAlarmTime(int time) {
        if (time * 719 % (12 * 60 * 60) == 0 || time * 59 % (60 * 60) == 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
