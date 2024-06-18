// 1. 완탐으로 만들기
// 1) 자신 뒤를 모두 확인하여 가장 가까운 큰 수 찾기
// 시간 복잡도 : 1,000,000 * 1,000,000 > 100,000,000

// 2. 최적화
// 스택으로 푼다
// 1) stack.peek 의 인덱스에 있는 것보다 이번 거가 작거나 같으면 stack에 인덱스를 넣기
// 2) 크면 pop하고 그 값을 뒷 큰 수로 지정

import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int l = numbers.length;
        int[] answer = new int[l];
        Arrays.fill(answer, -1);
        
        Stack<Integer> stack = new Stack<>();
        for (int idx=0; idx<l; idx++) {
            while (!stack.empty() && numbers[stack.peek()] < numbers[idx]) {
                int pkIdx = stack.pop();
                answer[pkIdx] = numbers[idx];
            }
            
            stack.push(idx);
        }
        
        return answer;
    }
}
