import java.io.*;
import java.util.*;

// 500 * 500 < 1억 -> 완탐 가능
public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	
    	int cnt = 0;
    	for (int B=1; B<=500; B++) {
    		for (int A=1; A<=500; A++) {
    			if (B <= A && A*A - B*B == N) {
    				cnt++;
    			}
    		}
    	}
    	
    	System.out.println(cnt);
    	
    }

}
