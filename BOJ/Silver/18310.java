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

// 240811
import java.util.*;
import java.io.*;

class Main {
	
	static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        int[] houses = new int[N];
        st = new StringTokenizer(br.readLine());
        
        for (int i=0; i<N; i++) {
        	houses[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(houses);
        
        int answer = N % 2 == 0 ? houses[N/2 -1] : houses[N/2];
        
        System.out.print(answer);
    }

};

