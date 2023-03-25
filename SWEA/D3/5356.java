import java.util.Scanner;
 
public class Solution {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
         
        for(int tc=0; tc<t; tc++) {
             
            char[][] words = new char[5][15];
            for(int r=0; r<5; r++) {
                String str = sc.next();
                int l = str.length();
                for(int s=0; s<l; s++) {
                    words[r][s] = str.charAt(s);
                }
            } //  2차원 배열로 입력 받음 : 입력 확인
             
            // 세로로 읽은 글자를 sb에 쌓음
            StringBuilder sb = new StringBuilder();
            for(int c=0; c<15; c++) {
                for(int r=0; r<5; r++) {
                    if(words[r][c] > 0) { 
                        sb.append(words[r][c]);
                    }
                }
            }
             
            System.out.printf("#%d %s\n", tc+1, sb.toString());
                         
        } // tc
    }
}
