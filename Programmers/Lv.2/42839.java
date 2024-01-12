import java.util.*;

class Solution {
    public int solution(String numbers) {
        int answer = 0;
        String[] pieces = numbers.split("");
        int l = pieces.length;
        
        boolean[] visited = new boolean[l];
        Set<Integer> set = new HashSet<>();
        backtracking("0", 0, visited, pieces, set);
        
        for (int n : set) {
            if (n == 1 || n == 0) continue;
            if (isPrime(n)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    static boolean isPrime(int n) {
        int cnt = 0;
        for (int i=1; i<=n/2; i++) {
            if (n%i == 0) {
                if (i*i == n) {
                    return false;
                } else {
                    cnt += 2;
                    if (cnt > 2) return false;
                }
            }
        }
        return true;
    }
    
    static void backtracking(String str, int depth, boolean[] visited, String[] pieces, Set<Integer> set) {
        if (depth == visited.length) {
            set.add(Integer.parseInt(str));
            return;
        }
        
        for (int i=0; i<visited.length; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                set.add(Integer.parseInt(str+pieces[i]));
                backtracking(str+pieces[i], depth+1, visited, pieces, set);
                visited[i] = false;
            }
        }
    }
}
