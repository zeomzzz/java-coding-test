import java.io.*;
import java.util.*;

// 1. 완탐 접근
// - 두 개 크기 합한 크기의 배열 만들고
// - A 뒤에 B를 붙이기 : 1,000,000
// - 정렬 : 최악 1,000,000 * 1,000,000

// 2. 최적화
// - 정렬에서 시간을 줄여야 한다.
// - 배열을 처음부터 정렬해서 주기 때문에 이를 활용하자

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	
    	int[] A = new int[N];
    	int[] B = new int[M];
    	
    	st = new StringTokenizer(br.readLine());
    	for (int i=0; i<N; i++) {
    		A[i] = Integer.parseInt(st.nextToken());
    	}
    	st = new StringTokenizer(br.readLine());
    	for (int i=0; i<M; i++) {
    		B[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	int idxA = 0;
    	int idxB = 0;
    	while (idxA < N || idxB < M) {
    		if (idxA < N && idxB < M) {
    			if (A[idxA] < B[idxB]) {
    				sb.append(A[idxA] + " ");
    				idxA++; // 정답에서 제외
    			} else {
    				sb.append(B[idxB] + " ");
    				idxB++; // 정답에서 제외
    			}
    		} else if (idxA >= N && idxB < M) {
    			sb.append(B[idxB] + " ");
    			idxB++;
    		} else if (idxA < N && idxB >= M) {
    			sb.append(A[idxA] + " ");
    			idxA++;
    		}
    		
    	}
    	System.out.print(sb);
    }    
};
