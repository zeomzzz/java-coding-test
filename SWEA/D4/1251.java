import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

	static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int tc = 1; tc <= t; tc++) {

			int n = sc.nextInt(); // 섬의 개수 n
			int[][] pos = new int[n][2];
			// x좌표 입력
			for (int r = 0; r < n; r++) {
				pos[r][0] = sc.nextInt();
			}
			// y좌표 입력
			for (int r = 0; r < n; r++) {
				pos[r][1] = sc.nextInt();
			}
			
			double e = sc.nextDouble();

			int idx = 0;
			double[][] edges = new double[n * (n - 1) / 2][3];
			for (int i = 0; i < n - 1; i++) {
				for (int j = i + 1; j < n; j++) {
					edges[idx][0] = i;
					edges[idx][1] = j;
					edges[idx][2] = Math.pow(pos[i][0] - pos[j][0], 2) + Math.pow(pos[i][1] - pos[j][1], 2);
					idx++;
				}
			}

			// 가중치에 따라 정렬
			Arrays.sort(edges, new Comparator<double[]>() {
				@Override
				public int compare(double[] o1, double[] o2) {
					return Double.compare(o1[2], o2[2]);
				}
			});

			// make set
			p = new int[n];
			for (int i = 0; i < n; i++) {
				p[i] = i;
			}

			// 같은 집합 아니면 합치기
			int pick = 0;
			double min = 0;
			idx = 0;
			while (pick < n - 1) {
				int px = findset((int) edges[idx][0]);
				int py = findset((int) edges[idx][1]);
				
				if(px != py) {
					p[py] = px; // union
					pick++;
					min += edges[idx][2];
				}
				
				idx++;
				
			}
			
			System.out.printf("#%d %d\n", tc, Math.round(e * min));

		} // tc

	}

	private static int findset(int x) {
		if (p[x] != x) p[x] = findset(p[x]);
		return p[x];
	}

}
