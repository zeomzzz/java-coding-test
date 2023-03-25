import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
  
public class Solution {
    public static void main(String[] args) {
          
        Scanner sc = new Scanner(System.in);
         
        for(int tc=1; tc<=10; tc++) {
             
            if(!sc.hasNext()) break;
            int t = sc.nextInt();
             
            // password에 8개의 수 입력 받음
            Queue<Integer> password = new LinkedList<>();
            for(int i=0; i<8; i++) {
                password.offer(sc.nextInt());
            }
             
            int n = 1;
             
            while(true) {
                if(password.peek() - n <= 0) { // 감소해서 0 보다 작거나 같으면 -> 0으로 바꾸고 -> 뒤로 보내고 종료!
                    password.poll();
                    password.offer(0);
                    break;
                } else { // n 감소 시켜서 뒤로 이동
                    password.offer(password.poll() - n);
                    if(n==5) n = 0; // 한 사이클이 1 ~ 5 감소
                    n++;                    
                }
            }
             
            System.out.printf("#%d ", t);
            while(!password.isEmpty()) {
                System.out.printf("%d ", password.poll());
            }
            System.out.println();
             
        } // tc
    }//main
}
