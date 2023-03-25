import java.util.Scanner;
 
public class Solution {
 
    public static void main(String[] args) {
         
        Scanner sc = new Scanner(System.in);
         
        for(int tc=0; tc<10; tc++) {
             
            int t = sc.nextInt(); // tc의 번호 입력 받음
             
            // 사다리 ladder에 입력 받음
            // 양 끝에 0으로된 column 하나씩 추가
            int[][] ladder = new int[100][102]; //[r][c]
             
            for(int r=0; r<100; r++) {
                for(int c=1; c<101; c++) {
                    ladder[r][c] = sc.nextInt();
                }
            }
             
            int nowR = 99;
            int nowC = 0;
             
            for(int x=1; x<101; x++) {
                if(ladder[99][x] == 2) {
                    nowC = x;
                }
            }
             
            while(nowR > 0) {
                 
                if(ladder[nowR][nowC-1] == 1) { // 왼쪽으로 가는 경우
                    ladder[nowR][nowC] = 0;
                    nowC--;
                } else if(ladder[nowR][nowC+1] == 1) { // 오른쪽으로 가는 경우
                    ladder[nowR][nowC] = 0;
                    nowC++;
                } else if(ladder[nowR-1][nowC] == 1) { // 위로 가는 경우
                    ladder[nowR][nowC] = 0;
                    nowR--;
                }
                 
            }// while
             
            System.out.printf("#%d %d\n", t, nowC-1);
             
        }// tc 10개
         
    }
         
}
