import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) {
         
        Scanner sc = new Scanner(System.in);
         
        int t = sc.nextInt();
         
        for(int tc=1; tc<=t; tc++) {
             
            int n = sc.nextInt(); // 수열의 원소 n개의 자연수
            int k = sc.nextInt(); // 부분 수열의 합이 k인 경우
            int[] A = new int[n];
            for(int i=0; i<n; i++) { // 자연수 수열 A
                A[i] = sc.nextInt();
            }
             
            int sum = 0; // 합을 구하기 위한 sum
            int cnt = 0; // 경우의 수를 count
             
            // 부분 집합을 구하는데,
            // 합도 같이 구함
            // n 넘어가면 종료
            for(int i=0; i<(1<<n); i++) { // 부분집합 2^n개
                 
                sum = 0; // 확인하는 부분집합 바뀔 때 sum 초기화
                 
                for(int j=0; j<n; j++) { // n개 요소에 대해서 확인
                    if((i & (1<<j)) > 0) { // 부분집합 i에 j번째 요소가 있는지 확인
                        sum += A[j]; // 있으면 더해준다
                    }
                     
                    if(sum > k) break; // k보다 크면 종료 (더 확인할 필요 X)
                }
                 
                if(sum == k) cnt++; // 하나의 부분집합 i에 대한 확인 끝났을 때, sum == k 이면 cnt++
                 
            }
             
            System.out.printf("#%d %d\n", tc, cnt);
             
        } // tc
         
    }
}
