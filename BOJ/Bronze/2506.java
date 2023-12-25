import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int total = 0;
    	int score = 0;
    	
    	for (int i=0; i<N; i++) {
    		if (Integer.parseInt(st.nextToken()) == 1) {
    			total += ++score;
    		} else {
    			score = 0;
    		}
    	}
        
    	System.out.println(total);
    }

}
