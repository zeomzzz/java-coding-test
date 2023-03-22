import java.util.Scanner;

public class Main {

	static int cntA; // 재료 개수 cnt
	static int cntB;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		// syns에 시너지의 값 담기
		int[][] syns = new int[n][n];
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				syns[r][c] = sc.nextInt();
			}
		}

		int[] A = new int[n / 2];
		int[] B = new int[n / 2];
		int synA = 0;
		int synB = 0;

		int minGap = 20001; // 가장 큰 값 이상으로 min 설정

		// 부분집합 0 ~ 2^(n-1)까지 확인 : A
		for (int i = 0; i < (1 << n - 1); i++) {
			boolean flag = true;
			synA = 0;
			synB = 0;
			cntA = 0;
			cntB = 0;

			for (int j = 0; j < n; j++) {

				if ((i & (1 << j)) > 0) { // A에 있으면 A에 담음
					if (cntA >= n / 2) {
						flag = false;
						break;
					}
					A[cntA++] = j;
				} else { // A에 없으면 B에 있음
					if (cntB >= n / 2) {
						flag = false;
						break;
					}
					B[cntB++] = j;
				}

			}

			if (flag == false)
				continue;

			for (int j = 0; j < n / 2 - 1; j++) {
				for (int k = j + 1; k < n / 2; k++) {
					synA += syns[A[j]][A[k]];
					synA += syns[A[k]][A[j]];

					synB += syns[B[j]][B[k]];
					synB += syns[B[k]][B[j]];
				}
			}

			int gap = Math.abs(synA - synB);
			if (minGap > gap)
				minGap = gap;

		} // 부분집합 확인

		System.out.println(minGap);

	}

}
