import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
  
public class Solution {
    public static void main(String[] args) {
          
        Scanner sc = new Scanner(System.in);
         
        for(int tc=1; tc<=10; tc++) { // tc 10개
            int l = sc.nextInt();
            char[] arr = sc.next().toCharArray();
              
            Stack<Character> stack = new Stack<>();
            char[] cal = new char[l];
            int idx = 0; // cal의 인덱스
             
            // 배열 cal에 후위 표기법으로 담기
            for(char x : arr) {
                if(x >= '0' && x <= '9') { // 피연산자이면 배열에 추가
                    cal[idx++] = x;
                     
                } else if (x == '(') { // 왼쪽 괄호는 stack에 push
                    stack.push(x);
                } else if (x == ')') { // 오른쪽 괄호이면 왼쪽 괄호 나올때 까지 pop해서 배열에
                    while(stack.peek() != '(') {
                        cal[idx++] = stack.pop();
                    }
                    stack.pop(); // while문 끝날 때 == 왼쪽괄호이므로 pop
                                     
                } else if (x == '*' || x == '/') { // * 또는 / 이면
                    // top에 * 또는 / 있으면 top을 pop해서 배열에 넣고 현재 토큰을 stack에 push
                    if(!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')) {
                        cal[idx++] = stack.pop();
                        stack.push(x);
                    } else { // 그렇지 않으면 현재 토큰을 push
                        stack.push(x);
                    }
                     
                } else { // + 또는 -이면
                    // 다른 연산자 있으면 pop 해서 배열에 넣고 현재 토큰 push
                    while(!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/' || stack.peek() == '+' || stack.peek() == '-')) {
                        cal[idx++] = stack.pop();
                    }
                    stack.push(x); // 그렇지 않으면 stack에 push
                }
            }
             
            // stack 빌 떼까지 pop해서 배열에 넣기
            while(!stack.isEmpty()) {
                cal[idx++] = stack.pop();
            }
             
            // 후위 표기법 끝!
            // 계산 시작
             
            // 스택 초기화
            Stack<Integer> intStack = new Stack<>();
            int a = 0;
            int b = 0;
            int tmp = 0; // 중간 연산 결과 담기 위한 tmp
             
            for(char x : cal) {
                if(x == ' ') break; // 배열 빈 곳 만나면 종료
                 
                if(x >= '0' && x <= '9') { // 피연산자 만나면 stack에 push
                    intStack.push((int) x - '0');
                         
                } else { // 연산자인 경우 stack에서 피연산자 두 개 꺼나서 계산하고 push
                    if(x == '*') {
                        a = intStack.pop();
                        b = intStack.pop();
                        tmp = b * a;
                        intStack.push(tmp);
                    } else if(x == '/') {
                        a = intStack.pop();
                        b = intStack.pop();
                        tmp = b / a;
                        intStack.push(tmp);
                    } else if(x == '+') {
                        a = intStack.pop();
                        b = intStack.pop();
                        tmp = b + a;
                        intStack.push(tmp);
                    } else if(x == '-') {
                        a = intStack.pop();
                        b = intStack.pop();
                        tmp = b - a;
                        intStack.push(tmp);
                    }
                }
            }
             
            int ans = intStack.pop();
             
            System.out.printf("#%d %s\n", tc, ans);
             
        } // tc
         
    }//main
  
}
