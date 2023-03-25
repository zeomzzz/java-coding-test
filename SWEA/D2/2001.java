import java.util.Scanner;
 
public class Solution {
 
    public static void main(String[] args) {
         
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
         
        for(int tc=0; tc<T; tc++) {
             
            // 파리를 fly 배열에 입력
            int n = sc.nextInt();
            int m = sc.nextInt();
             
            int[][] fly = new int[n][n];
            for(int r=0; r<n; r++) {
                for(int c=0; c<n; c++) {
                    fly[r][c] = sc.nextInt();
                }
            }
             
            int sum; // 파리의 수 합
            int max = 0; // 죽은 파리의 최대 개수
             
            // 2중 for문으로 합계 구할 때의 기준 점을 구함
            for(int r=0; r<n-m+1; r++) {
                for(int c=0; c<n-m+1; c++) {
                     
                    sum = 0;
                     
                    // 가로 m개, 세로 m개 범위에서 더함
                    for(int rr=r; rr<r+m; rr++) {
                        for(int cc=c; cc<c+m; cc++) {
                            sum += fly[rr][cc];
                        }
                    }
                     
                    if(sum>max) {
                        max = sum;
                    }
                     
                }
            }
             
            System.out.printf("#%d %d\n", tc+1, max);
             
        }// tc
         
    }//main 
         
}
