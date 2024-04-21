import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static long x, y, sum;
	static long[] xs, ys;
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	xs = new long[N];
    	ys = new long[N];
    	
    	for (int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine());
    		xs[i] = Long.parseLong(st.nextToken());
    		ys[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	Arrays.sort(xs);
    	Arrays.sort(ys);
    	
    	int m = (int)((N-1)/2);
    	x = xs[m];
    	y = ys[m];
    	
    	for (long tmp : xs) sum += Math.abs(x - tmp);
    	for (long tmp : ys) sum += Math.abs(y - tmp);
    	
    	System.out.print(sum);
    	
    }
    
};
