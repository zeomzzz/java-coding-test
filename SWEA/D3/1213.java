import java.util.Arrays;
import java.util.Scanner;
 
public class Solution {
 
    public static void main(String[] args) {
         
        Scanner sc = new Scanner(System.in);
 
        for(int tc=0; tc<10; tc++){
             
            int t = sc.nextInt(); // tc 번호
             
            // 패턴을 pArr에 배열에 저장
            String p = sc.next();
            int pl = p.length();
            char[] pArr = new char[pl];
            pArr = p.toCharArray();
             
            // 문자을 arr에 배열로 저장
            String str = sc.next();
            int sl = str.length();
            char[] arr = new char[sl];
            arr = str.toCharArray();
             
            int i = 0;
            int j = 0;
            int cnt = 0;
             
            while(i<sl && j<pl) {
                if(arr[i] != pArr[j]) {
                    i -= j;
                    j = -1;
                }
                 
                i++;
                j++;
                 
                // 패턴을 마지막 요소까지 검사해서 통과하면 count
                if(j == pl) {
                    cnt++;
                    j = 0;
                }
 
            }
             
            System.out.printf("#%d %s\n", t, cnt);
             
        }// tc
         
    }//main 
         
}
