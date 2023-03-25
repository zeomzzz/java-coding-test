import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) {
         
        Scanner sc = new Scanner(System.in);
         
        for(int tc=1; tc<=10; tc++) {
            int t = sc.nextInt();
             
            int n = sc.nextInt();
            int m = sc.nextInt();
             
            System.out.printf("#%d %d\n", t, pow(n, m));
             
        } // tc 10개
         
    }
 
    public static int pow(int n, int m) {
 
        if (m == 1)
            return n;
        else {
            return pow(n, m - 1) * n;
        }
 
    }
}
