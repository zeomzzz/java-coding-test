import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int tc = sc.nextInt();
 
        for (int t = 1; t <= tc; t++) {
 
            int n = sc.nextInt(); // 마지막 비트 n개
            int m = sc.nextInt(); // 이진수로 바꿀 수 m
            boolean flag = true;
 
            for (int i = 0; i < n; i++) {
                if(m % 2 == 0) { // 끝이 0 이면 종료
                    flag = false;
                    break;
                } else { // 1이면(== 0이 아니면) 하나 밀고 반복문 진행 계속
                    m = m >> 1;
                }
                 
            }
 
            if (flag == true) {
                System.out.println("#" + t + " ON");
            } else {
                System.out.println("#" + t + " OFF");
            }
 
        } // tc
 
    }
}
