// 1. board를 stack을 담은 배열로 바꾸기. bascket도 stack으로
// 2. moves 따라가면서 pop & push. 이때 현재 pop한 값과 peek이 일치하면 answer++
import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int n = board.length;
        Stack<Integer>[] boardStack = new Stack[n+1];
        for (int i=0; i<=n; i++) {
            boardStack[i] = new Stack<>();
        }
        
        for (int i=n-1; i>=0; i--) {
            for (int j=0; j<n; j++) {
                if (board[i][j] != 0) boardStack[j+1].push(board[i][j]);
            }
        }
        
        Stack<Integer> basket = new Stack<>();
        
        // moves 따라가면서 작동
        for (int move : moves) {
            // 인형 꺼내기
            if (boardStack[move].empty()) continue;
            int curDoll = boardStack[move].pop();
            // 현재 바구니 맨 위와 비교
            if (!basket.empty() && basket.peek() == curDoll) {
                basket.pop();
                answer += 2;
            } else {
                basket.push(curDoll);
            }
        }
        
        return answer;
    }
}
