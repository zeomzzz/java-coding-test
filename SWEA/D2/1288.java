import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); // tc 수
		
		for(int tc=0; tc<T; tc++) {
			
			int N = sc.nextInt();
			int ans = N;
			
			int cnt = 1 << 10;
			
			while(true) {
				
				String tmp = Integer.toString(ans);
				for(int i=0; i<tmp.length(); i++) {
					cnt = cnt | (1 << (tmp.charAt(i) - '0'));
				}
				
				if(cnt == ((1 << 11) - 1)) {
					System.out.printf("#%d %d\n", tc+1, ans);
					break;
				} else {
					ans += N;
				}
				
			} // while
			
		} // tc
		
	}

}
