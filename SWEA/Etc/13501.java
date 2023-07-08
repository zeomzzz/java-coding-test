import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			
			int N = sc.nextInt(); // 수열의 길이 N
			int M = sc.nextInt(); // 추가 횟수 M
			int L = sc.nextInt(); // 출력할 인덱스 번호 L
			
			LinkedList<Integer> lst = new LinkedList<>();
			
			for(int n=0; n<N; n++) { lst.add(sc.nextInt()); }
			
			for(int m=0; m<M; m++) {
				
				String cmd = sc.next();
				
				if (cmd.equals("I")) {
					lst.add(sc.nextInt(), sc.nextInt());
				} else if (cmd.equals("D")) {
					lst.remove(sc.nextInt());
				} else if (cmd.equals("C")) {
					int idx = sc.nextInt();
					lst.remove(idx);
					lst.add(idx, sc.nextInt());
				}
				
			}
			
			int ans = 0;
			if (lst.size() <= L) {
				ans = -1;
			} else {
				ans = lst.get(L);
			}
			
			System.out.printf("#%d %d\n", tc, ans);
			
		} // tc
		
	}

}
