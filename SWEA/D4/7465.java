import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	
	static int[] p;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int tc=1; tc<=t; tc++) {
			
			int n = sc.nextInt(); // 마을에 사는 사람 수
			int m = sc.nextInt(); // 사람의 관계 수(간선 수)
			int[][] edges = new int[m][2];
			for(int i=0; i<m; i++) {
				edges[i][0] = sc.nextInt();
				edges[i][1] = sc.nextInt();
			}
			
			// 1. make-set
			p = new int[n+1]; // 1번 ~ n번
			for(int i=1; i<n+1; i++) {
				p[i] = i;
			}
			
			// 2. 간선들을 다 union
			for(int i=0; i<m; i++) {
				int x = edges[i][0];
				int y = edges[i][1];
				
				union(x, y);
			}
			
			// 3. p를 모두 대표자 가리키도록
			for(int i=1; i<n+1; i++) {
				p[i] = findset(i);
			}
			p[0] = p[1]; // 0번은 1번이랑 같은거로 업데이트
			
			// 4. HashSet으로 중복제거
			HashSet<Integer> hs = new HashSet<>();
			for(int r : p) {
				hs.add(r);
			}
			
			System.out.printf("#%d %d\n", tc, hs.size());
			
		} // tc

	}

	private static void union(int x, int y) {
		p[findset(y)] = findset(x);
	}

	private static int findset(int x) {
		if(x != p[x]) p[x] = findset(p[x]);
		return p[x];
	}

}
