import java.util.Scanner;
 
public class Solution {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
         
        for(int tc=0; tc<t; tc++) {
             
            char[] arr = sc.next().toCharArray();
             
            int l = arr.length;
             
            char[] stack = new char[l];
            int pattern = 0;
             
            // arr의 맨 뒤 부터 stack에 담음
            // 마디의 길이는 1 이상이기 때문에 0번째는 우선 입력
            stack[0] = arr[l-1];
            int top = 0;
             
            outer : for(int i=1; i<l; i++) {
                // arr의 뒤에서 i번째는 stack의 i번째에 담음
                stack[i] = arr[l-1-i];
                top = i;
                 
                // stack의 0번과 stack에 마지막 담은 요소가 일치하면 0~마지막 담은 요소까지가 패턴인지 검사
                if(stack[top] == stack[0]) {
                    pattern = top;
                     
                    // arr의 요소를 stack에 계속 담으면서 패턴이 맞는지 확인
                    // 아닌 경우 break하여 다시 패턴이 될 수 있는 위치를 찾음
                    for(int k=i+1; k<l; k++) {
                        if(stack[k-1] != stack[k-1-pattern]) {
                            break;
                        }
                    break outer;
                    }
                }
            }
             
            System.out.printf("#%d %d\n", tc+1, pattern);
             
        } // tc
    }
}
