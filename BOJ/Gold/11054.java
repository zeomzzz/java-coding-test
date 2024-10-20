import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[] A;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
        	A[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] preDp = new int[N];
        Arrays.fill(preDp, 1);
        for (int i=0; i<N; i++) {
        	for (int j=0; j<i; j++) {
        		if (A[j] < A[i]) {
        			preDp[i] = Math.max(preDp[i], preDp[j] + 1);
        		}
        	}
        }
        
        int[] sufDp = new int[N];
        Arrays.fill(sufDp, 1);
        for (int i=N-1; i>=0; i--) {
        	for (int j=N-1; j>i; j--) {
        		if (A[j] < A[i]) {
        			sufDp[i] = Math.max(sufDp[i], sufDp[j] + 1);
        		}
        	}
        }
        
        int max = 0;
        for (int i=0; i<N; i++) {
        	max = Math.max(max, preDp[i] + sufDp[i] - 1);
        }
        
        System.out.print(max);
    }
}
