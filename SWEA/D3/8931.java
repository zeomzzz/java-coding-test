import java.util.Scanner;
import java.util.Stack;
 
public class Solution {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
         
        for(int tc=0; tc<t; tc++) {
             
            int k = sc.nextInt();
             
            Stack<Integer> stack = new Stack<>();
             
            // 0이 아니면 stack에 담고 0이면 pop
            for(int n=0; n<k; n++) {
                int num = sc.nextInt();
                if(num != 0) {
                    stack.push(num);
                } else {
                    stack.pop();
                }
            }
             
            // stack이 빌 때 까지 sum에 stack의 요소를 더하고 pop
            int sum = 0;
            while(!stack.empty()) {
                sum += stack.pop();
            }
             
            System.out.printf("#%d %d\n", tc+1, sum);
             
        } // tc
    }
}
