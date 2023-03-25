import java.util.Scanner;
 
public class Solution {
     
    static int h; // 맵의 높이
    static int w; // 맵의 너비
    static char[][] map; // 지도
    static int cmdCnt; // 명령 길이
    static char[] cmd; // 명령
    static int posR; // 전차 초기 위치
    static int posC;
     
    public static void main(String[] args) {
          
        Scanner sc = new Scanner(System.in);
         
        int t = sc.nextInt();
         
        for(int tc=1; tc<=t; tc++) {
             
            h = sc.nextInt();
            w = sc.nextInt();
             
            map = new char[h][w];
            for(int i=0; i<h; i++) {
                map[i] = sc.next().toCharArray();
            }
             
            cmdCnt = sc.nextInt();
            cmd = new char[cmdCnt];
            cmd = sc.next().toCharArray();
             
            posR = 0;
            posC = 0;
             
            // 초기 전차 위치 찾기
            for(int r=0; r<h; r++) {
                for(int c=0; c<w; c++) {
                    if(map[r][c]=='^'||map[r][c]=='v'||map[r][c]=='<'||map[r][c]=='>') {
                        posR = r;
                        posC = c;
                    }
                }
            }
             
            for(int i=0; i<cmdCnt; i++) {
                action(cmd[i]);
            }
             
            System.out.printf("#%d ", tc);
            for(int r=0; r<h; r++) {
                for(int c=0; c<w; c++) {
                    System.out.print(map[r][c]);
                }
                System.out.println();
            }
             
        } // tc       
         
    }//main
     
    static void action(char cmd) {
         
        if(cmd == 'U') {
            map[posR][posC] = '^';
            if(posR-1>=0 && map[posR-1][posC] == '.') {
                map[posR][posC] = '.';
                map[--posR][posC] = '^';
            }
        } else if(cmd == 'D') {
            map[posR][posC] = 'v';
            if(posR+1<h && map[posR+1][posC] == '.') {
                map[posR][posC] = '.';
                map[++posR][posC] = 'v';
            }
        } else if(cmd == 'L') {
            map[posR][posC] = '<';
            if(posC-1>=0 && map[posR][posC-1] == '.') {
                map[posR][posC] = '.';
                map[posR][--posC] = '<';
            }
        } else if(cmd == 'R') {
            map[posR][posC] = '>';
            if(posC+1<w && map[posR][posC+1] == '.') {
                map[posR][posC] = '.';
                map[posR][++posC] = '>';
            }
        } else { // shoot
            if(map[posR][posC] == '^') { // 방향 : U
                for(int nr=posR-1; nr>=0; nr--) {
                    if(map[nr][posC] == '*') {
                        map[nr][posC] = '.';
                        break;
                    } else if(map[nr][posC] == '#') {
                        break;
                    }
                }
            } else if(map[posR][posC] == '>') {
                for(int nc=posC+1; nc<w; nc++) {
                    if(map[posR][nc] == '*') {
                        map[posR][nc] = '.';
                        break;
                    } else if(map[posR][nc] == '#') {
                        break;
                    }
                }
            } else if(map[posR][posC] == 'v') {
                for(int nr=posR+1;nr<h; nr++) {
                    if(map[nr][posC] == '*') {
                        map[nr][posC] = '.';
                        break;
                    } else if(map[nr][posC] == '#') {
                        break;
                    }
                }
            } else if(map[posR][posC] == '<') {
                for(int nc=posC-1;nc>=0;nc--) {
                    if(map[posR][nc] == '*') {
                        map[posR][nc] = '.';
                        break;
                    } else if(map[posR][nc] == '#') {
                        break;
                    }
                }
            }
        }
    }
}
