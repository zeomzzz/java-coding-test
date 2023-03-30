// 풀이 1 : 순열
import java.util.Scanner;
 
public class Solution {
 
    static int n, d, min;
    static int[][] clients;
    static int[] idxs;
     
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
 
        int t = sc.nextInt();
         
        for(int tc=1; tc<=t; tc++) {
             
            n = sc.nextInt(); // n : 고객의 수
             
            clients = new int[n+2][2];
            clients[0][0] = sc.nextInt();
            clients[0][1] = sc.nextInt(); // 0번째에 회사
            clients[n+1][0] = sc.nextInt();
            clients[n+1][1] = sc.nextInt(); // n+1번째에 집
            for(int i=1; i<n+1; i++) { // 1~n번째에 고객 
                clients[i][0] = sc.nextInt();
                clients[i][1] = sc.nextInt();
            }
             
            min = Integer.MAX_VALUE; // 거리 최소값 min
             
            idxs = new int[n+2]; // 0 ~ n+1
            for(int i=0; i<n+2; i++) {
                idxs[i] = i; // 이 중 인덱스 1 ~ n만 가지고 순열
            }
             
            perm(1);
             
            System.out.printf("#%d %d\n", tc, min);
             
        } // tc
 
    }
     
    public static void perm(int idx) {
        if(idx == n+1) {
            d = 0;
            for(int i=0; i<n+1; i++) {
                distance(idxs[i], idxs[i+1]);
                if(d>=min) return; // d가 min보다 작지 않으면 더 계산 안해봐도 됨
            }
             
            min = Math.min(min, d);
             
            return;
        }
         
        for(int i=idx; i<n+1; i++) {
            swap(i, idx);
            perm(idx+1);
            swap(i, idx);
        }
    }
     
    public static void distance(int a, int b) {
        d += Math.abs(clients[a][0] - clients[b][0]) + Math.abs(clients[a][1] - clients[b][1]);
    }
     
    public static void swap(int a, int b) {
        int tmp = idxs[a];
        idxs[a] = idxs[b];
        idxs[b] = tmp;
    }
 
}


/////////
// 풀이 2. 이너클래스 + 백트레킹
import java.util.Scanner;
 
public class Solution {
    static int n, d, min;
    static boolean[] visited;
    static Pos prepos, curpos;
    static Pos[] poses;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
 
            // 입력 받기
            n = sc.nextInt(); // 고객 좌표 n개
            poses = new Pos[n + 2];
            poses[0] = new Pos(sc.nextInt(), sc.nextInt()); // 회사
            poses[n + 1] = new Pos(sc.nextInt(), sc.nextInt()); // 집
            for (int i = 1; i < n + 1; i++) { // 고객 n명
                poses[i] = new Pos(sc.nextInt(), sc.nextInt());
            }
 
            // 풀이 시작
            visited = new boolean[n + 2];
            prepos = poses[0];
            min = Integer.MAX_VALUE;
 
            visit(0, 0, 0);
 
            System.out.printf("#%d %d\n", tc, min);
 
        } // tc
    }
 
    public static void visit(int num, int d, int cur) { // num : 반복 횟수, d : 거리, cur : 현재 인덱스
 
        // base
        if (d >= min) return;
 
        if (num == n) {
            d += distance(poses[cur], poses[n + 1]);
            min = Math.min(min, d);
            return;
        }
 
        // recursive
        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                visited[i] = true;
                visit(num + 1, d + distance(poses[cur], poses[i]), i);
                visited[i] = false; // 원복
            }
 
        }
 
    }
 
    public static int distance(Pos p1, Pos p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }
 
    public static class Pos {
        int x, y;
 
        // 생성자
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
 
}
