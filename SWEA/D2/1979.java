import java.util.Scanner;
 
public class Solution {
 
    public static void main(String[] args) {
         
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
         
        for(int tc=0; tc<T; tc++) {
             
            int N = sc.nextInt(); // 가로, 세로 길이
            int K = sc.nextInt(); // 넣으려는 단어의 길이
             
            // 퍼즐 1, 0을 배열 puzzle에 입력 받음
            // 사방에 0이 입력된 줄 하나 추가
            int[][] puzzle = new int[N+2][N+2];
            for(int r=1; r<N+1; r++) {
                for(int c=1; c<N+1; c++) {
                    puzzle[r][c] = sc.nextInt();
                }
            }
             
            int cnt = 0; // 가능한 자리의 수를 count
             
            // 1. 가로 검사
            for(int r=1; r<N+1; r++) {
                int len = 0; // 퍼즐에 들어갈 수 있는 단어의 길이
                for(int c=1; c<N+2; c++) {
                    // 1) 현재 위치가 1일 때
                    if(puzzle[r][c] == 1) {
                        // 1-1) -1 한 위치가 0이면 시작점(len = 1)
                        if(puzzle[r][c-1] == 0) {
                            len = 1;
                        // 1-2) -1 한 위치가 1이면 중간 (len++)
                        } else {
                            len++;
                        }
                    // 2) 현재 위치가 0일 때
                    } else {
                        // 2-1) -1 한 위치가 1이면 끝 (len == K 인 경우 cnt++)
                        if(puzzle[r][c-1] == 1) {
                            if(len == K) {
                                cnt++;
                            }
                        }
                    }
                }
            }
             
            // 2. 세로 검사
            for(int c=1; c<N+1; c++) {
                int len = 0;
                for(int r=1; r<N+2; r++) {
                    if(puzzle[r][c] == 1) {
                        if(puzzle[r-1][c] == 0) {
                            len = 1;
                        } else {
                            len++;
                        }
                    } else {
                        if(puzzle[r-1][c] == 1) {
                            if(len == K) {
                                cnt++;
                            }
                        }
                    }
                }
            }
             
            System.out.printf("#%d %d\n", tc+1, cnt);
             
        }// tc
         
    }//main 
         
}
