import java.util.Scanner;
  
public class Solution {
    public static void main(String[] args) {
          
        Scanner sc = new Scanner(System.in);
         
        int t = sc.nextInt();
         
        for(int tc=1; tc<=t; tc++) {
             
            int n = sc.nextInt();
            int[] bus = new int[5001]; // 버스 정류장 번호 1 ~ 5000
             
            int a;
            int b;
            for(int i=0; i<n; i++) {
                a = sc.nextInt(); // a 이상 b 이하만 다님
                b = sc.nextInt();
                 
                for(int j=a; j<=b; j++) { // a 이상 b 이상 정류장에 지나는 버스 노선 개수 ++
                    bus[j]++;
                }
            }
             
            int p = sc.nextInt(); // p개의 버스 정류장에 대한 결과 찾기
            System.out.printf("#%d ", tc);
            for(int i=0; i<p; i++) {
                System.out.printf("%d ", bus[sc.nextInt()]);
            }
             
            System.out.println();
             
        } // tc
         
    }//main
 
}
