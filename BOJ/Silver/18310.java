import java.io.*;
import java.util.*;

public class Main {
	
	static int N, ans, sum;
	static int[] houses;
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	N = Integer.parseInt(br.readLine());
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	houses = new int[N];
    	for (int i=0; i<N; i++) {
    		houses[i] = Integer.parseInt(st.nextToken());
    	}
    	Arrays.sort(houses);
    	
    	System.out.print((houses[(int)(N-1)/2]));
    	
    }
    
};
