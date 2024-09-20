// 1. priorites는 idx와 함께 queue에 담고, pq를 하나 더 만들기
// 2. pq를 pop하면서 일치하면 실행(answer++). 아니면 다시 queue에 넣기

import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<int[]> prioritiesQ = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int l = priorities.length;
        
        // 1. queue에 담기
        for (int i=0; i<l; i++) {
            int idx = i;
            int priority = priorities[i];
            int[] element = new int[2];
            element[0] = priority;
            element[1] = idx;
            
            prioritiesQ.offer(element);
            pq.offer(priority);
        }
        
        // 2. pq를 pop하면서 실행
        outer : while (pq.size() > 0) {
            // 실행해야하는 우선순위
            int priority = pq.poll();
            
            while (prioritiesQ.size() > 0) {
                int[] polled = prioritiesQ.poll();
                
                // 실행하는 경우
                if (polled[0] == priority) {
                    answer++;
                    // location을 실행하는 경우
                    if (polled[1] == location) {
                        break outer;
                    }
                    break;
                // 실행하지 않는 경우 다시 queue에 넣기
                } else {
                    prioritiesQ.offer(polled);
                }
            }
        }
        
        return answer;
    }
}

// 다른 풀이
// 1. priorities를 q를 담기
// 2. array sort하여 priorities를 정렬
// 3. locations를 조정하여 값을 찾기

import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Integer> q = new LinkedList<>();
        for (int priority : priorities) {
            q.add(priority);
        }
        
        Arrays.sort(priorities);
        int l = location;
        int n = priorities.length - 1;
        
        while (!q.isEmpty()) {
            int priority = priorities[n - answer];
            int polled = q.poll();
            
            // 실행하는 경우
            if (polled == priority) {
                answer++;
                l--;
                if (l < 0) { // location이 실행되면 음수가 됨
                    break;
                }
            } else {
                q.offer(polled);
                l--;
                if (l < 0) {
                    l = q.size() - 1; // 음수면 다시 맨 뒤로 보냄
                }
            }
        }
        
        return answer;
    }
}

// 240921
import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> indexQueue = new LinkedList<>();
        
        for (int i=0; i<priorities.length; i++) {
            priorityQueue.add(priorities[i]);
            indexQueue.add(i);
        }
        
        while (indexQueue.size() != 0) {
            int idx = indexQueue.poll();
            
            if (priorities[idx] == priorityQueue.peek()) {
                answer++;
                priorityQueue.poll();
                if (idx == location) {
                    break;
                }
            } else {
                indexQueue.add(idx);
            }
            
        }
        
        return answer;
    }
}
