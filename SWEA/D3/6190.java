import java.util.Arrays;
import java.util.Scanner;
  
public class Solution {
    public static void main(String[] args) {
          
        Scanner sc = new Scanner(System.in);
         
        int t = sc.nextInt();
         
        for(int tc=1; tc<=t; tc++) {
            int ans = 0;
             
            int n = sc.nextInt();
            int[] nArr = new int[n];
            for(int i=0; i<n; i++) { // n개의 정수
                nArr[i] = sc.nextInt();             
            }
             
            if(n == 1) {
                ans = nArr[0];
            } else {
                 
                int l = n * (n-1) / 2;
                int[] xArr = new int[n * (n-1) / 2]; // 곱한 값 리스트
                 
                int idx=0;
                for(int i=0; i<n; i++) { // xArr에 오름차순으로 들어감
                    for(int j=i+1; j<n; j++) {
                        xArr[idx++] = nArr[i] * nArr[j];
                    }
                }
                 
                Arrays.sort(xArr);
                 
                // 맨 마지막부터 단조 증가하는 수인지 검사
                boolean isTrue;
                for(int i=l-1; i>=0; i--) {
                     
                    isTrue = true;
                     
                    String strNum = Integer.toString(xArr[i]); // 문자열로 바꿔주고
                    int lNum = strNum.length(); // 길이 찾아서
 
                    for(int j=1; j<lNum; j++) { // 앞부터 첫번째 두번째 비교, 두번째 세번째 비교 ...
                        if(strNum.charAt(j-1) > strNum.charAt(j)) {
                            isTrue = false; // 조건 만족 안하면 false로 바꾸고 break
                            break;
                        }
                    }
                     
                    if(isTrue) { // false 한 번도 안 걸린 경우만 답이 될 수 있음
                        ans = xArr[i];
                         
                        break;
                    } else {
                        ans = -1;
                    }
                     
                }
                 
            }
             
            System.out.printf("#%d %d\n", tc, ans);
 
        } // tc
         
    }//main
 
}
