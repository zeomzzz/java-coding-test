import java.util.Scanner;
 
public class Solution {
 
    public static void main(String[] args) {
         
        Scanner sc = new Scanner(System.in);
         
        for(int tc=0; tc<10; tc++) {
             
            int l = sc.nextInt(); // 회문의 길이 l
             
            char[][] letters = new char[8][8];
            for(int r=0; r<8; r++) {
                 
                char[] lineArr = sc.next().toCharArray();
                 
                for(int c=0; c<8; c++) {
                    letters[r][c] = lineArr[c];
                }
            }
             
            int cnt = 0; // 회문 개수 count
             
            // 1. 가로 검사
            // 첫 글자 가능한 위치 범위 : 0 ~ 8-l+1
            for(int r=0; r<8; r++) {
                 
                for(int start=0; start<=8-l; start++) {
                     
                    StringBuilder sb1 = new StringBuilder();
                    StringBuilder sb2 = new StringBuilder();
                     
                    for(int i=0; i<l; i++) {
                        sb1.append(letters[r][start+i]);
                    }
                     
                    for(int j=l-1; j>=0; j--) {
                        sb2.append(letters[r][start+j]);
                    }
                     
                    if(sb1.toString().equals(sb2.toString())) cnt++;
                }
            } // 가로 검사
             
            // 2. 세로 검사
            // 첫 글자 가능한 위치 범위 : 0 ~ 8-l+1                       
            for(int c=0; c<8; c++) {
                             
                for(int start=0; start<=8-l; start++) {
                                 
                    StringBuilder sb1 = new StringBuilder();
                    StringBuilder sb2 = new StringBuilder();
                                 
                    for(int i=0; i<l; i++) {
                        sb1.append(letters[start+i][c]);
                    }
                                 
                    for(int j=l-1; j>=0; j--) {
                        sb2.append(letters[start+j][c]);
                    }
                                 
                    if(sb1.toString().equals(sb2.toString())) cnt++;
                }
            } // 세로 검사
                         
            System.out.printf("#%d %d\n", tc+1, cnt);
             
        }//tc
    }//main 
}
