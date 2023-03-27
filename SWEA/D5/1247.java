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
