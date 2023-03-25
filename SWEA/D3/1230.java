import java.util.LinkedList;
import java.util.Scanner;
  
public class Solution {
    public static void main(String[] args) {
          
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> password = new LinkedList<>();
        int cmdCnt; // 명령어 개수
        int x; // 앞에서부터 x의 위치 다음에 
        int y; // y개의 숫자에 대해서 처리
         
         
        for(int tc=1; tc<=10; tc++) {
            int n = sc.nextInt(); // 원본 암호문의 길이 n
            password.clear(); // LinkedList에 password 입력
            for(int i=0; i<n; i++) {
                password.offer(sc.nextInt());
            }
             
            cmdCnt = sc.nextInt(); // 명령어의 개수 cmdCnt
            for(int i=0; i<cmdCnt; i++) {
                String cmd = sc.next();
                // 1. Insert
                if(cmd.equals("I")) {
                    x = sc.nextInt(); // 앞에서부터 x 위치 다음에
                    y = sc.nextInt(); // y개의 숫자를 삽입
                     
                    int start = x;
                    for(int cnt=0; cnt<y; cnt++) {
                        password.add(start, sc.nextInt());
                        start++;
                    }
                     
                // 2. Delete
                } else if(cmd.equals("D")) {
                    x = sc.nextInt(); // 앞에서부터 x 위치 다음에
                    y = sc.nextInt(); // y개의 숫자를 삭제
                     
                    for(int cnt=0; cnt<y; cnt++) {
                        password.remove(x+1);
                    }
                 
                // 3. Add
                } else if(cmd.equals("A")) {
                    y = sc.nextInt(); // y개의 숫자를 맨 뒤에 추가
                    for(int cnt=0; cnt<y; cnt++) {
                        password.addLast(sc.nextInt());
                    }
                }
                 
            } // 명령어 개수
             
            // 결과 출력 : 암호문 앞에서부터 10개
            System.out.printf("#%d ", tc);
            for(int i=0; i<10; i++) {
                System.out.printf("%d ", password.poll());
            }
            System.out.println();
 
        } // tc
         
    }//main
}
