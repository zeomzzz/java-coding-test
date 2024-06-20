// visited = new int[11][11][4]; (4 : UDRL)

import java.util.*;

class Solution {
    static int x, y, l, answer;
    static boolean[][][] visited;
    
    public int solution(String dirs) {
        answer = 0;
        x = 5;
        y = 5;
        l = dirs.length();
        visited = new boolean[11][11][4];
        
        for (int i=0; i<l; i++) {
            move(dirs.charAt(i));
        }
        
        return answer;
    }
    
    static void move(char dir) {
        if (dir == 'U' && y + 1 <= 10) {
            if (!visited[x][y][0]) {
                visited[x][y][0] = true;
                answer++;
            }
            y += 1;
            visited[x][y][1] = true;
        } else if (dir == 'D' && y - 1 >= 0) {
            if (!visited[x][y][1]) {
                visited[x][y][1] = true;
                answer++;
            }
            y -= 1;
            visited[x][y][0] = true;
        } else if (dir == 'R' && x + 1 <= 10) {
            if (!visited[x][y][2]) {
                visited[x][y][2] = true;
                answer++;
            }
            x += 1;
            visited[x][y][3] = true;
        } else if (dir == 'L' && x - 1 >= 0) {
            if (!visited[x][y][3]) {
                visited[x][y][3] = true;
                answer++;
            }
            x -= 1;
            visited[x][y][2] = true;
        }
    }
    
}
