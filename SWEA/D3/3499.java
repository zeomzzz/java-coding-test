import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) {
         
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for(int tc=1; tc<=t; tc++) {
        	
        	int n = sc.nextInt();
        	
        	// Queue q1에 처음 부터 절반, q2에 나머지 카드 입력 받음
        	Queue<String> q1 = new LinkedList<>();
        	Queue<String> q2 = new LinkedList<>();
        	for(int i=0; i<n-n/2; i++) { // 홀수인 경우 q1에 한 장 더
        		q1.offer(sc.next());
        	}
        	for(int i=0; i<n/2; i++) {
        		q2.offer(sc.next());
        	}
        	
        	System.out.printf("#%d ", tc);
        	
        	// 각 Queue가 비어있지 않은 경우 출력
        	for(int i=0; i<n/2+1; i++) {
        		if(!q1.isEmpty()) {
        			System.out.printf("%s ", q1.poll());
        		}
        		if(!q2.isEmpty()) {
        			System.out.printf("%s ", q2.poll());
        		}
        	}
        	
        	System.out.println();
        	
        } // tc
        
    }//main
 
}
