import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	
    	int a = 0;
    	int c = 0;
    	
    	for (int i=1; i<=N; i++) {
    		a += i;
    		c += i * i * i;
    	}
    	
    	System.out.println(a);
    	System.out.println(a * a);
    	System.out.println(c);
    }

}
