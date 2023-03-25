import java.util.Scanner;
 
public class Solution {
 
    public static void main(String[] args) {
         
        Scanner sc = new Scanner(System.in);
         
        for(int tc=0; tc<10; tc++) {
             
            int t = sc.nextInt(); // tc번호 t
             
            // 1. 2차원 배열 arr 입력 받음
            int[][] arr = new int[100][100];
            for(int r=0; r<100; r++) {
                for(int c=0; c<100; c++) {
                    arr[r][c] = sc.nextInt();
                }
            }
             
            // 현재까지의 최댓값 max
            int max = 0;
             
            // 2. 행 방향의 합
            int sum;
            for(int r=0; r<100; r++) {
                sum = 0;
                for(int c=0; c<100; c++) {
                    sum += arr[r][c];
                }
                 
                // sum 이 max보다 크면 max를 sum으로 바꿔줌
                if(sum > max) {
                    max = sum;
                }
             
            }
             
            // 3. 열 방향의 합
            for(int c=0; c<100; c++) {
                sum = 0;
                for(int r=0; r<100; r++) {
                    sum += arr[r][c];
                }
                 
                if(sum > max) {
                    max = sum;
                }
            }
             
            //4. 대각선 방향의 합 : 우하향
            sum = 0;
            for(int r=0; r<100; r++) {
                sum += arr[r][r];
            }
             
            if(sum > max) {
                max = sum;
            }
             
            // 5. 대각선 : 좌하향
            sum = 0;
            for(int r=99; r>=0; r--) {
                sum += arr[r][99-r];
            }
             
            if(sum > max) {
                max = sum;
            }
             
            System.out.printf("#%d %d\n", t, max);
             
        }// tc
         
    }//main 
         
}
