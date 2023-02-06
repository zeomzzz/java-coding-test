import java.util.Scanner;
 
public class Solution {
 
    public static void main(String[] args) {
         
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
         
        for(int t = 0; t < T; t++) {
             
            int l = sc.nextInt(); // l : 수열의 길이
             
            // 수열을 배열로 입력 받음 (arr)
            int[] arr = new int[l];
            for(int i = 0; i < l; i++) {
                arr[i] = sc.nextInt();
            }
             
            // 가능한 부분 증가 수열의 길이 입력할 배열 생성 (ascArr)
            int[] ascArr = new int[l];
            for(int i = 0; i < l; i++) {
                ascArr[i] = 1;
            }
             
            for(int i = 1; i < l; i++) {
                // arr에서 [i] 앞에 [i]에 해당하는 값보다 [j]에 해당하는 값이 더 작다면
                for(int j = i; j >= 0; j--) {
                    if(arr[j] < arr[i]) {
                        // [i]까지의 최장 부분 증가수열의 길이는 각 [j]까지의 최장부분증가수열의 길이 + 1 중 가장 큰 값
                        if(ascArr[j] + 1 > ascArr[i]) {
                            ascArr[i] = ascArr[j] + 1;
                        }
                        // [i] 앞에 더 작은 값이 없는 경우 최장부분증가수열의 길이는 1 (초기에 ascArr의 각 값을 1로 설정) 
                    }
                }
            }
             
            // 각 요소까지의 최장부분증가수열의 길이를 담은 ascArr의 값 중 가장 큰 값이 구하는 값이 됨 (maxLen)
            int maxLen = ascArr[0];
            for(int i = 1; i < l; i++) {
                if(ascArr[i] > maxLen) {
                    maxLen = ascArr[i];
                }
            }
             
            System.out.printf("#%d %d\n", t+1, maxLen);
             
        } // tc T번 반복
 
    } // main
 
}
