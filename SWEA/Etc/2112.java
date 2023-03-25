import java.util.Scanner;
 
public class Solution {
 
    static int ans;
    static int[][] film;
    static int d, w, k;
 
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
 
        int t = sc.nextInt();
 
        for (int tc = 1; tc <= t; tc++) {
 
            d = sc.nextInt(); // 두께
            w = sc.nextInt(); // 가로 크기
            k = sc.nextInt(); // 합격기준
 
            // 보호필름 단면의 정보
            film = new int[d][w];
            for (int r = 0; r < d; r++) {
                for (int c = 0; c < w; c++) {
                    film[r][c] = sc.nextInt();
                }
            }
 
            ans = k; // 결과는 최대 k 이므로 정답의 초기값을 k로 설정
 
            rec(0, 0);
 
            System.out.printf("#%d %d\n", tc, ans);
 
        } // tc
 
    }
 
    // 성능검사 : 통과하면 true
    public static boolean check() {
 
        // 열 방향으로 검사
        for (int c = 0; c < w; c++) {
            boolean res = false; // 결과를 false로 초기화. 통과하면 true로 바꾸고 break
            int cnt = 1;
            for (int r = 1; r < d; r++) {
 
                if (film[r][c] == film[r - 1][c]) { // AA or BB
                    cnt++;
                } else { // 연달아있지 않으면
                    cnt = 1; // 다시 cnt 1부터 count
                }
 
                // 성능검사 통과하면(k개가 연달아있으면) true를 반환
                if (cnt >= k) {
                    res = true;
                    break;
                }
            }
            if (!res)
                return false; // 한 줄이라도 통과 못하면 false
        }
        return true;
    }
 
    public static void rec(int depth, int cnt) {
 
        // 성능검사 통과하면 return
        if (check()) {
            ans = cnt;
            return;
        }
 
        // cnt가 지금까지 찾은 정답보다 크면 더 확인 안해도됨(최소값이 답이니까)
        // 마지막 행까지 검사하면 return
        if (depth == d || cnt >= ans)
            return;
 
        // 검사하는 행의 특성을 저장(복구용)
        int[] copy = new int[w];
        for (int c = 0; c < w; c++) {
            copy[c] = film[depth][c];
        }
 
        // depth 행에 주입 안하는 경우
        rec(depth + 1, cnt);
 
        // depth행에 A 주입하는 경우
        for (int c = 0; c < w; c++) {
            film[depth][c] = 0;
        }
        rec(depth + 1, cnt + 1);
 
        // depth 행에 B 주입하는 경우
        for (int c = 0; c < w; c++) {
            film[depth][c] = 1;
        }
        rec(depth + 1, cnt + 1);
 
        // 원상 복구
        for (int c = 0; c < w; c++) {
            film[depth][c] = copy[c];
        }
 
    }
 
}
