import java.util.Scanner;
import java.util.Stack;
 
public class Solution {
    public static void main(String[] args) {
         
        Scanner sc = new Scanner(System.in);
         
        int t = sc.nextInt(); // tc 수
        for(int tc=0; tc<t; tc++) {
             
            Stack<Character> stack = new Stack<>();
            char[] arr = sc.next().toCharArray();
            int l = arr.length;
            int cnt = 0; // 스택 내 '(' 개수
            int sum = 0; // 잘려진 조각의 개수
             
            // 여는 괄호 stack에 push
            for(int i=0; i<l; i++) {
                if(arr[i] == '(') {
                    stack.push('(');
                    cnt++;
                } else {
                    // 닫는 괄호일 때 직전이 여는 괄호 -> 레이저
                    // stack pop 하고 stack에 남은 여는 괄호 개수가 잘려진 조각의 개수
                    if(arr[i-1] == '(') {
                        stack.pop();
                        cnt--;
                        sum += cnt;
                    // 직전이 닫는 괄호 -> 쇠막대기의 끝
                    // 조각 +1
                    } else {
                        stack.pop();
                        cnt--;
                        sum++;
                    }
                }
            }
             
            System.out.printf("#%d %d\n", tc+1, sum);
             
        } //tc
         
    }//main    
 
}
