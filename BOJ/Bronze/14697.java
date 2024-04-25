import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int A = Integer.parseInt(st.nextToken());
    	int B = Integer.parseInt(st.nextToken());
    	int C = Integer.parseInt(st.nextToken());
    	int N = Integer.parseInt(st.nextToken()); // 0 ~ 300
    	
    	boolean flag = false;
    	outer: for (int a=0; a<=N; a++) {
    		for (int b=0; b<=N; b++) {
    			for (int c=0; c<=N; c++) {
    				if (A*a + B*b + C*c == N) {
    					flag = true;
    					break outer;
    				}
    			}
    		}
    	}
    	
    	if (flag) {
    		System.out.print(1);
    	} else {
    		System.out.print(0);
    	}
    	
    }

};

// 240425
import java.io.*;
import java.util.*;

// 50 * 50 * 50 < 100,000,000

public class Main {
	
	static int A, B, C, N;
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	A = Integer.parseInt(st.nextToken());
    	B = Integer.parseInt(st.nextToken());
    	C = Integer.parseInt(st.nextToken());
    	N = Integer.parseInt(st.nextToken());
    	
    	boolean flag = false;
    	for (int a=0; a<=50; a++) {
    		for (int b=0; b<=50; b++) {
    			for (int c=0; c<=50; c++) {
    				if (a*A + b*B + c*C == N) flag = true; 
    			}
    		}
    	}
    	
    	if (flag) System.out.print(1);
    	else System.out.print(0);
    	
    }
    
};
