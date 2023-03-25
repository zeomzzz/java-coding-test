import java.util.LinkedList;
import java.util.Scanner;
  
public class Solution {
    public static void main(String[] args) {
          
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
         
        for(int tc=1; tc<=t; tc++) { 
             
            int n = sc.nextInt();
             
            // arr에 배열 입력
            int[][] arr = new int[n][n];
            for(int r=0; r<n; r++) {
                for(int c=0; c<n; c++) {
                    arr[r][c] = sc.nextInt();
                }
            }
             
            System.out.printf("#%d\n", tc);
             
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                     
                    // 90도
                    System.out.print(arr[n-1-j][i]);
                }
                 
                System.out.print(" ");
                 
                for(int jj=0; jj<n; jj++) {
                    // 180도
                    System.out.print(arr[n-1-i][n-1-jj]);
                }
                 
                System.out.print(" ");
                 
                for(int jjj=0; jjj<n; jjj++) {
                    // 270도
                    System.out.print(arr[jjj][n-1-i]);
                }   
                    System.out.println();
            }
 
        } // tc
         
    }//main
}
