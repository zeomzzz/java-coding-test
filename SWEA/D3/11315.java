import java.util.Scanner;
 
public class Solution {
 
    public static void main(String[] args) {
         
        Scanner sc = new Scanner(System.in);
 
        int T = sc.nextInt();
        for(int tc=0; tc<T; tc++){
             
            int n = sc.nextInt();
             
            // 배열 omok에 돌 입력 받음
            char[][] omok = new char[n][n];
            char[] line = new char[n];
             
            for(int j=0; j<n; j++) {
                 
                String str = sc.next();
                 
                for(int i=0; i<n; i++) {
                    line[i] = str.charAt(i);
                }
                 
                for(int k=0; k<n; k++) {
                    omok[j][k] = line[k];
                }
                 
            } // 2차원 배열로 입력 확인
             
             
            boolean isOmok = false;
            int cnt;
             
            // 1. 가로 확인
            // c 가능한 범위 : 0 ~ n - 5
            for(int r=0; r<n; r++) {
                for(int c=0; c<n-4; c++) {
                     
                    cnt = 0;
                     
                    for(int nc=c; nc<c+5; nc++) {
                        if(omok[r][nc] == 'o') {
                            cnt++;
                        }
                    }
                     
                    if(cnt == 5) {
                        isOmok = true;
                        break;
                    }
                     
                }
            }
             
            // 2. 세로 확인
            // r 가능한 범위 : 0 ~ n - 5
            for(int c=0; c<n; c++) {
                for(int r=0; r<n-4; r++) {
                     
                    cnt = 0;
                     
                    for(int nr=r; nr<r+5; nr++) {
                        if(omok[nr][c] == 'o') {
                            cnt++;
                        }
                    }
                     
                    if(cnt == 5) {
                        isOmok = true;
                        break;
                    }
                     
                }
            }
             
             
            // 3. 우하향 대각선
            for(int r=0; r<n-4; r++) {
                for(int c=0; c<n-4; c++) {
                     
                    cnt = 0;
                     
                    for(int nr=r, nc=c; nr<r+5; nr++, nc++) {
                        if(omok[nr][nc] == 'o') {
                            cnt++;
                        }
                    }
                     
                    if(cnt == 5) {
                        isOmok = true;
                        break;
                    }
                     
                }
            }
            
            // 4. 좌하향 대각선
            for(int r=0; r<n-4; r++) {
                for(int c=n-1; c>3; c--) {
                     
                    cnt = 0;
                     
                    for(int nr=r, nc=c; nr<r+5; nr++, nc--) {
                        if(omok[nr][nc] == 'o') {
                            cnt++;
                        }
                    }
                     
                    if(cnt == 5) {
                        isOmok = true;
                        break;
                    }
                     
                }
            }
             
            if(isOmok == true) {
                System.out.printf("#%d %s\n", tc+1, "YES");
            } else {
                System.out.printf("#%d %s\n", tc+1, "NO");
            }
             
        }// tc
         
    }//main    
         
}
