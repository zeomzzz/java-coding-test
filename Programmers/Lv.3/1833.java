// 1. 완탐 방식
// 2개 뽑아서 가능한지 다 확인 -> 3중 for문 (고르기 2중 + 확인 1중)
// 2. 최적화
// 좌표는 압축
// (0, 0) ~ (i, j) 내부에 존재하는 쐐기의 개수를 저장
import java.util.*;

class Solution {
    public int solution(int n, int[][] data) {
        int answer = 0;
        
        // 1. 좌표 압축
        List<Integer> xList = new ArrayList<>();
        List<Integer> yList = new ArrayList<>();
        
        for (int[] pos : data) {
            xList.add(pos[0]);
            yList.add(pos[1]);
        }
        
        List<Integer> xPosList = new ArrayList<>(new HashSet<Integer>(xList));
        List<Integer> yPosList = new ArrayList<>(new HashSet<Integer>(yList));
        
        Collections.sort(xPosList);
        Collections.sort(yPosList);
        
        int[][] sums = new int[n][n];
        for (int i=0; i<n; i++) {
            
            data[i][0] = xPosList.indexOf(data[i][0]);
            data[i][1] = yPosList.indexOf(data[i][1]);
            
            sums[data[i][0]][data[i][1]] = 1;
        }
        
        // 2. 누적합 배열로 만들기
        for (int x=0; x<n; x++) {
            for (int y=0; y<n; y++) {
                if (x-1 >= 0) {
                    sums[x][y] += sums[x-1][y];
                }
                if (y-1 >= 0) {
                    sums[x][y] += sums[x][y-1];
                }
                if (x-1 >= 0 && y-1 >= 0) {
                    sums[x][y] -= sums[x-1][y-1];
                }
            }
        }
        
        // 3. 가능한 쐐기의 조합 찾기
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                int minX = Math.min(data[i][0], data[j][0]);
                int maxX = Math.max(data[i][0], data[j][0]);
                int minY = Math.min(data[i][1], data[j][1]);
                int maxY = Math.max(data[i][1], data[j][1]);
                
                if (minX == maxX || minY == maxY) continue; // 직사각형 안됨
                if (sums[maxX-1][maxY-1] - (sums[maxX-1][minY] + sums[minX][maxY-1]) + sums[minX][minY] == 0) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}
