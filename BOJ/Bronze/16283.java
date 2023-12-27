import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int a = Integer.parseInt(st.nextToken()); // 1 ~ 1,000
    	int b = Integer.parseInt(st.nextToken()); // 1 ~ 1,000
    	int n = Integer.parseInt(st.nextToken()); // 2 ~ 1,000
    	int w = Integer.parseInt(st.nextToken()); //  2 ~ 1,000,000
    	
    	boolean flag = false;
    	String answer = "";
    	for (int sheep=1; sheep<n; sheep++) {
    		int goat = n-sheep;
    		
    		if (sheep * a + goat * b == w) {
    			if (!flag) {
    				answer += Integer.toString(sheep) + " " + Integer.toString(goat);
        			flag = true;
    			} else {
    				flag = false;
    				break;
    			}
    		}
    	}
    	
    	if (!flag) {
    		System.out.print(-1);
    	} else {
    		System.out.print(answer);
    	}
    	
    }

}
