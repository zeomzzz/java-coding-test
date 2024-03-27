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

// 240327
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, start, link, answer, n;
	static int[][] stats;
	static int[] starts, links;
	static boolean[] visited;
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	stats = new int[N+1][N+1];
    	StringTokenizer st;
    	
    	for (int r=1; r<N+1; r++) {
    		st = new StringTokenizer(br.readLine());
    		for (int c=1; c<N+1; c++) stats[r][c] = Integer.parseInt(st.nextToken());
    	}
    	
    	answer = Integer.MAX_VALUE;
    	n = (int) N/2;
    	starts = new int[n];
    	links = new int[n];
    	visited = new boolean[N+1];
    	visited[1] = true;
    	
    	recur(1, 2);
    	
    	System.out.print(answer);
    }
    
    static void recur(int cur, int start) {
    	
    	if (cur == n) {
//    		System.out.println(Arrays.toString(visited));
    		divide();
    		calStart();
    		calLink();
    		updateAns();
    		return;
    	}
    	
    	for (int i=start; i<N+1; i++) {
    		visited[i] = true;
    		recur(cur+1, i+1);
    		visited[i] = false;
    	}
    	
    }
    
    static void divide() {
    	int startIdx = 0;
    	int linkIdx = 0;
    	
    	for (int i=1; i<N+1; i++) {
    		if (visited[i]) {
    			starts[startIdx++] = i;
    		} else {
    			links[linkIdx++] = i;
    		}
    	}
    }
    
    static void calStart() {
    	start = 0;
    	
    	for (int i=0; i<n; i++) {
    		for (int j=i+1; j<n; j++) {
    			start += stats[starts[i]][starts[j]];
    			start += stats[starts[j]][starts[i]];
    		}
    	}
    }
    
    static void calLink() {
    	link = 0;
    	
    	for (int i=0; i<n; i++) {
    		for (int j=i+1; j<n; j++) {
    			link += stats[links[i]][links[j]];
    			link += stats[links[j]][links[i]];
    		}
    	}
    }
    
    static void updateAns() {
    	answer = Math.min(answer, Math.abs(start-link));
    }
    
};
