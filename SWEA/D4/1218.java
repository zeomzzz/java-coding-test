import java.util.Scanner;
import java.util.Stack;
 
public class Solution {
    public static void main(String[] args) {
         
        Scanner sc = new Scanner(System.in);
 
        for(int tc=0; tc<10; tc++) { // tc 10개
             
            char[] open = {'(', '[', '{', '<'};
            char[] close = {')', ']', '}', '>'};
            Stack<Character> stack = new Stack<>();
             
            int l = sc.nextInt();
            char[] arr = sc.next().toCharArray();
             
            boolean isStr = true; // 유효한 문자열인가?
             
            outer: for(int i=0; i<l; i++) {
                 
                for(int idx=0; idx<4; idx++) {
                     
                    // arr[i]가 여는 괄호 중 하나이면 stack에 추가
                    if(arr[i] == open[idx]) {
                        stack.push(arr[i]);
                        break;
                    // arr[i]가 닫는 괄호 중 하나인 경우
                    } else if(arr[i] == close[idx]) {
                        // 마지막으로 스택에 추가한 여는 괄호가
                        // 닫는 괄호와 쌍인 여는 괄호이면 pop
                        if(stack.peek() == open[idx]) {
                            stack.pop();
                            break;
                        // 쌍이 맞지 않으면 false
                        } else {
                            isStr = false;
                            break outer;
                        }
                    }
                }
            }
             
            // stack에 남은 괄호가 있으면 false
            if(!stack.isEmpty()) {
                isStr = false;
            }
             
            if(isStr) {
                System.out.printf("#%d %d\n", tc+1, 1);
            } else {
                System.out.printf("#%d %d\n", tc+1, 0);
            }
 
        } //tc
         
    }//main    
 
}
