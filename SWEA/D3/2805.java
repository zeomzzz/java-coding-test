import java.util.Scanner;
  
public class Solution {
    public static void main(String[] args) {
          
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
         
        for(int tc=1; tc<=t; tc++) { 
             
            int n = sc.nextInt(); // 농장 크기 n
            // n*n 배열에 농장의 수익 입력
            int[][] land = new int[n][n];
            for(int r=0; r<n; r++) {
                String line = sc.next();
                for(int c=0; c<n; c++) {
                    land[r][c] = (int) line.charAt(c) - 48;
                }               
            }
             
            int sum = 0;
            int m = n/2;
             
            // row idx 0 ~ m에서 해당 구역의 sum
            for(int r=0; r<=m; r++) {
                for(int c=m-r; c<=m+r; c++) {
                    sum += land[r][c];
                }
            }
             
            // row m+1 ~ n-1에서 해당 구역의 sum
            for(int r=0; r<m; r++) {
                for(int c=r+1; c<n-1-r; c++) {
                    sum += land[m+1+r][c];
                }
            }
             
            System.out.printf("#%d %d\n", tc, sum);
             
        } // tc
         
    }//main
}
