import java.util.Scanner;
 
public class Solution {
 
    public static void main(String[] args) {
         
        Scanner sc = new Scanner(System.in);
 
        for(int tc=0; tc<10; tc++) { // tc 10
             
            int t = sc.nextInt(); //  t : tc번호
             
            // letters 입력
            char[][] letters = new char[100][100];
            for(int r=0; r<100; r++) {
                char[] line = sc.next().toCharArray();
                 
                for(int c=0; c<100; c++) {
                    letters[r][c] = line[c];
                }
            } // letters 입력
             
            // 길이 100, 99, 98, .. 순으로 가로, 세로 확인
            // 회문의 길이 l
            boolean isPal = true;
            int l;
             
            outer : for(l=100; l>0; l--) {
                 
                // 1. 가로 확인
                for(int r=0; r<100; r++) {
                    for(int c=0; c<100-l+1; c++) { // 시작점 설정
                         
                        isPal = true;
                        for(int i=0; i<l/2; i++) {
                            if(letters[r][c+i] != letters[r][c+l-1-i]) {
                                isPal = false;
                                break;
                            }
                        }
                         
                        if(isPal) break outer;
                     
                    }
                } // 가로
                 
                // 2. 세로 확인
                for(int c=0; c<100; c++) {
                    for(int r=0; r<100-l+1; r++) { // 시작점 설정
                         
                        isPal = true;
                        for(int i=0; i<l/2; i++){
                            if(letters[r+i][c] != letters[r+l-1-i][c]) {
                                isPal = false;
                                break;
                            }
                        }
                         
                        if(isPal) break outer;
                     
                    }
                } // 세로 
                 
            }
             
            System.out.printf("#%d %d\n", t, l);
             
        } //tc
         
    }//main    
 
}
