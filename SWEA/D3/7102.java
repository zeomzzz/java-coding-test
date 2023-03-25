import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
  
public class Solution {
    public static void main(String[] args) {
          
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
         
        for(int tc=1; tc<=t; tc++) {
            int n = sc.nextInt(); // 1세트 : 1번 ~ n번
            int m = sc.nextInt(); // 2세트 : 1번 ~ m번
             
            Queue<Integer> nq = new LinkedList<>(); // 1세트를 담을 q
            for(int i=1; i<=n; i++) {
                nq.offer(i);
            }
             
            Queue<Integer> mq = new LinkedList<>(); // 2세트를 담을 q
            for(int i=1; i<=m; i++) {
                mq.offer(i);
            }
             
            int[] sumLst = new int[n+m+1]; // 인덱스를 이용하여 배열에 카드의 합을 담음
            while(!nq.isEmpty()) {
                int nn = nq.poll();
                for(int i=0; i<m; i++) {
                    int mm = mq.poll();
                    sumLst[nn + mm]++;
                    mq.offer(mm);
                }
            }
             
            // 가장 빈도가 높은(=확률이 높은) 합을 담는 maxQ
            // 일단 합 1인 경우를 담기
            Queue<Integer> maxQ = new LinkedList<>();
            int max = sumLst[1];
            maxQ.offer(1);
             
            // 더 합이 큰 것 있으면 max 바꿔줌
            // max가 새로운 숫자이면 maxQ clear하고 다시 담기
            // 같은 숫자이면 확률이 같으므로 maxQ에 추가
            for(int i=2; i<sumLst.length; i++) {
                if(sumLst[i] > max) {
                    max = sumLst[i];
                    maxQ.clear();
                    maxQ.offer(i);
                } else if(sumLst[i] == max){
                    maxQ.offer(i);
                }
            }
             
            // 빌 때까지 poll 하면서 출력
            System.out.printf("#%d ", tc);
            while(!maxQ.isEmpty()) {
                System.out.printf("%d ", maxQ.poll());
            }
            System.out.println();
             
        } // tc
    }//main
}
