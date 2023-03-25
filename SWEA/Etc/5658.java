import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) {
         
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt(); // tc 개수
         
        for(int t=1; t<=tc; t++) {
             
            int n = sc.nextInt(); // 숫자의 개수 n (4의 배수)
            int k = sc.nextInt(); // 숫자의 개수 k
            char[] arr = sc.next().toCharArray(); // n개의 숫자 배열에 입력 받음
             
            Deque<Character> charLst = new LinkedList<>();
            for(int i=0; i<n; i++) {
                charLst.add(arr[i]);
            }
             
            int[] numLst = new int[n]; // 숫자를 담을 ArrayList
             
            // 맨 뒤 pop해서 맨 앞에 추가. 이거를 n/4 - 1번하기
            int idx = 0;
            int num = 0;
            for(int l=0; l<n/4; l++) {
                 
                String strNum = "";
                for(int i=0; i<n; i++) {
                     
                    if(i != 0 && i % (n / 4) == 0) {
                        num = toNum(strNum);
                        numLst[idx++] = num;
                        strNum = "";
                    }
                     
                    char c = charLst.removeFirst(); // charLst 맨 앞에거
                    strNum += c; // strNum에 추가하고
                    charLst.addLast(c); // 다시 뒤로 보내
                     
                }
                 
                num = toNum(strNum);
                numLst[idx++] = num;
                 
                charLst.addFirst(charLst.removeLast());
 
            }
             
            Arrays.sort(numLst);
 
            // 중복체크
            for(int i=n-1; i>=1; i--) {
                if(numLst[i] == numLst[i - 1]) {
                    numLst[i] = 0;
                }
            }
             
            Arrays.sort(numLst);
             
            System.out.printf("#%d %d\n", t, numLst[n - k]);
             
        } // tc
 
    } // main
     
    // 16진수를 10진수로 바꿔주기
    static int toNum(String strNum) {
        int num = 0; // 바꾼 결과(10진수)가 num
        int l = strNum.length(); // 16진수의 길이가 0
         
        for(int i=0; i<l; i++) {
            char tmp = strNum.charAt(i);
            if ((int)tmp <= (int)'9') {
                num += ((int)tmp - (int)'1' + 1) * Math.pow(16, l-i-1); // int로 바꾸고 16^(l-i-1) 곱해줌
            } else { // A : 10, B : 11, C : 12, D : 13, E : 14, F : 15
                num += ((int)tmp - (int)'A' + 10) * Math.pow(16, l-i-1);
            }
        }
         
        return num;
         
    }
 
}
