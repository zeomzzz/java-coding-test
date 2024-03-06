import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        List<Integer> lst = new LinkedList<>();
        int n = 0;
        for (int[] command : commands) {
            int i = command[0];
            int j = command[1];
            int k = command[2];
            
            for (int idx=i-1; idx<j; idx++) {
                lst.add(array[idx]);
            }
            
            Collections.sort(lst);
            
            answer[n++] = lst.get(k-1);
            lst.clear();
        }
        
        return answer;
    }
}
