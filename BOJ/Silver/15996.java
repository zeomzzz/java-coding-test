import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	long N = Long.parseLong(st.nextToken());
    	int A = Integer.parseInt(st.nextToken());
    	
    	long k = 0;
    	long cnt = N;
    	while (cnt / A != 0) {
    		cnt = cnt / A;
    		k += cnt;
    	}
    	
    	System.out.println(k);
    }
    
};
