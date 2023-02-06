import java.util.Scanner;
 
public class Solution {
 
    public static void main(String[] args) {
         
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
         
        for(int t = 0; t < T; t++) {
             
            // 원래 상태를 입력받아 배열에 저장 (originArr)
            String originStr = sc.next();
            int l = originStr.length();
            char[] originArr = new char[l];
            originArr = originStr.toCharArray();
             
            // 초기화 상태를 배열로 저장 (initArr)
            char[] initArr = new char[l];
            for(int i = 0; i < l; i++) {
                initArr[i] = '0';
            }
             
             
            // 앞 인덱스부터 서로 비교하여 다른 경우 초기화 상태의 해당 인덱스~맨 뒤까지 바꿔줌 & cnt++
            int cnt = 0;
             
            for(int i = 0; i < l; i++) {
                if(initArr[i] != originArr[i]) {
                    if(originArr[i] == '1') {
                        for(int j = i; j < l; j++) {
                            initArr[j] = '1';
                        }
                         
                        cnt++;
                         
                    } else { // originArr[i] == '0'
                        for(int j = i; j < l; j++) {
                            initArr[j] = '0';
                        }
                         
                        cnt++;
                         
                    }
                }
            }
             
            System.out.printf("#%d %d\n", t+1, cnt);
             
        } // tc T번 반복
 
    } // main
 
}
