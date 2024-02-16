// 1. 각 q 요소의 합을 구함 + 하면서 q에 넣기
// 2. 더 큰쪽을 꺼내서 작은쪽에 넣는거 반복. 이게 몇 번인지 확인

import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1 = 0;
        long sum2 = 0;
        
        for (int i=0; i<queue1.length; i++) {
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
            sum1 += queue1[i];
            sum2 += queue2[i];
        }
        
        for (int i=0; i<queue1.length * 3; i++) {
            if (sum1 == sum2) break;
            if (sum1 > sum2) {
                int tmp = q1.poll();
                q2.offer(tmp);
                sum1 -= tmp;
                sum2 += tmp;
            } else {
                int tmp = q2.poll();
                q1.offer(tmp);
                sum1 += tmp;
                sum2 -= tmp;
            }
            answer++;
        }
        
        if (sum1 != sum2) answer = -1;
        
        return answer;
    }
}

// 이분탐색 풀이
import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        int[] nums = new int[queue1.length * 2];
        int idx = 0;
        long sum1 = 0;
        long sum2 = 0;
        for (int num : queue1) {
            nums[idx++] = num;
            sum1 += num;
        }
        for (int num : queue2) {
            nums[idx++] = num;
            sum2 += num;
        }
        
        int s = 0;
        int e = queue1.length;
        
        while (s < e && e < nums.length) {
            if (sum1 == sum2) break;
            else if (sum1 > sum2) {
                sum1 -= nums[s];
                sum2 += nums[s];
                s++;
            } else {
                sum1 += nums[e];
                sum2 -= nums[e];
                e++;
            }
            answer++;
        }
        
        if (sum1 != sum2) answer = -1;
        
        return answer;
    }
}
