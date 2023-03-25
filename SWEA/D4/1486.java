import java.util.Scanner;
 
public class Solution {
     
    public static void main(String[] args) {
         
        Scanner sc = new Scanner(System.in);
         
        int t = sc.nextInt();
         
        for(int tc=1; tc<=t; tc++) {
             
            int n = sc.nextInt(); // 점원 n명
            int b = sc.nextInt(); // 탑의 높이 최저 제한 b
             
            int[] hs = new int[n]; // n명의 키 입력 (heights)
            for(int i=0; i<n; i++) {
                hs[i] = sc.nextInt();
            }
             
            int min = Integer.MAX_VALUE;
             
            // 부분집합을 구해서 높이를 구해봄
            for(int i=0; i<(1<<n); i++) { // 전체 부분집합
                 
                int sum = 0; // 새로운 부분 집합 확인할 때는 sum 0으로 초기화
                 
                for(int j=0; j<n; j++) { // 각 점원의 키를 확인
                    if((i & (1<<j)) != 0) { // 부분집합 i에 j 있으면
                        sum += hs[j]; // 합에 j번째의 키를 더해줌
                    }
                }
                 
                // 이 부분집합에 대한 sum 찾음
                // sum이 최저 제한 b 이상이고 지금까지 찾은 min보다 작으면 min 업데이트 
                if(sum >= b && min > sum) min = sum;
                 
                // 최저 제한 b인거 찾으면 더 확인 안해도 됨
                if(sum == b) {
                    min = sum;
                    break;
                }
            }
             
            System.out.printf("#%d %d\n", tc, min-b);           
             
        } // tc
         
    }
     
}
