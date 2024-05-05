import java.io.*;
import java.util.*;

public class Main {
	
	static int N, answer;
	static long L, R, X;
	static long[] levels;
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	L = Long.parseLong(st.nextToken());
    	R = Long.parseLong(st.nextToken());
    	X = Long.parseLong(st.nextToken());
    	
    	levels = new long[N];
    	st = new StringTokenizer(br.readLine());
    	for (int i=0; i<N; i++) {
    		levels[i] = Long.parseLong(st.nextToken());
    	}
    	Arrays.sort(levels);
    	
    	answer = 0;
    	for (int easy=0; easy<N; easy++) {
    		recur(easy, easy+1, levels[easy]);
    	}
    	
    	System.out.print(answer);
    }
    
    public static void recur(int easy, int cur, long sum) {
    	
    	if (cur == N) {
    		return;
    	}
    	
    	// cur번째 선택
    	recur(easy, cur+1, sum+levels[cur]);
    	if (sum+levels[cur]>=L && sum+levels[cur]<=R && levels[cur]-levels[easy]>=X) {
    		answer++;
    	}
    	
    	// cur번째 선택 X
    	recur(easy, cur+1, sum);
    	
    }
    
};
