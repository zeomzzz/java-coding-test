import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
   
public class Solution {
    public static void main(String[] args) {
           
        Scanner sc = new Scanner(System.in);
         
        int t = sc.nextInt();
        for(int tc=1; tc<=t; tc++) {
             
            int n = sc.nextInt(); // r
            int m = sc.nextInt(); // c
             
            // 현재 깃발 입력
            char[][] flag = new char[n][m];
            for(int r=0; r<n; r++) {
                char[] arr = sc.next().toCharArray();
                for(int c=0; c<m; c++) {
                    flag[r][c] = arr[c];
                }
            }
             
            int min = n*m; // 가능한 최댓값(=모두 바꿈)을 min으로 설정
             
            // for문 중첩하여 가능한 흰, 파랑, 빨강 범위 정함
            // cnt에 바꿔야하는 칸 수를 더해주고 min과 비교하여 min을 찾음
            for(int w=0; w<n-2; w++) {
                for(int b=w+1; b<n-1; b++) {
                     
                    int cnt = 0;
                     
                    for(int r=0; r<n; r++) {
                        for(int c=0; c<m; c++) {
                            if(r<=w) {
                                if(flag[r][c] != 'W') {
                                    cnt++;
                                }
                            } else if(r<=b) {
                                if(flag[r][c] != 'B') {
                                    cnt++;
                                }
                            } else {
                                if(flag[r][c] != 'R') {
                                    cnt++;
                                }
                            }
                        }
                    }
                     
                    if(cnt < min) min = cnt;
                     
                }
            }
             
            System.out.printf("#%d %d\n", tc, min);
 
        }  // tc
    }
}
