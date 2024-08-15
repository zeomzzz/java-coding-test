// 완전탐색 풀이
// B의 범위가 -1000 ~ 1000이고 근은 항상 정수이므로 근의 범위는 -1000 ~ 1000
// -> 근의 범위를 모두 탐색
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int A = Integer.parseInt(st.nextToken());
    	int B = Integer.parseInt(st.nextToken());
    	
    	boolean flag = false;
    	for (int i = -1000; i<=1000; i++) {
    		if (i*i + 2*A*i + B == 0) {
    			if (flag) System.out.print(" ");
    			System.out.print(i);
    			flag = true;
    		}
    	}
    	
    }

}

// 240421
import java.io.*;
import java.util.*;

public class Main {
	
	static int A, B, a, b;
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	A = Integer.parseInt(st.nextToken());
    	B = Integer.parseInt(st.nextToken());
    	
    	outer : for (int i=-1000; i<=1000; i++) {
    		for (int j=i; j<=1000; j++) {
    			if (i+j == -2 * A && i*j == B) {
    				a = i;
    				b = j;
    				break outer;
    			}
    		}
    	}
    	
    	if (a == b) System.out.print(a);
    	else System.out.print(a + " " + b);
    	
    }
    
};

// 240423
import java.io.*;
import java.util.*;

public class Main {
	
	static int A, B;
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	A = Integer.parseInt(st.nextToken());
    	B = Integer.parseInt(st.nextToken());
    	
    	for (int i=-1000; i<=1000; i++) {
    		if (i*i + 2*A*i + B == 0) {
    			System.out.print(i + " ");
    		}
    	}
    	
    }
    
};

// 240811
// 1. 완탐 : 2000 * 2000

import java.util.*;
import java.io.*;

class Main {
	static int A;
	static int B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        
        // x2 + 2Ax + B = 0;
        int x1 = Integer.MIN_VALUE;
        int x2 = Integer.MIN_VALUE;
        
        outer: for (int i=-1000; i<=1000; i++) {
        	if (checkIsRoot(i)) {
        		x1 = i;
        		for (int j=i+1; j<=1000; j++) {
        			if (checkIsRoot(j)) {
        				x2 = j;
        				break outer;
        			}
        		}
        		x2 = i;
        		break outer;
        	}
        }
        
        if (x1 == x2) {
        	System.out.print(x1);
        } else {
        	System.out.print(x1 + " " + x2);
        }
        
    }
    
    public static boolean checkIsRoot(int x) {
    	if (x * x + 2 * A * x + B == 0) {
    		return true;
    	}
    	return false;
    }

};

// 240815
import java.util.*;
import java.io.*;

class Main {
	
	static int A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        
        // x^2 + 2Ax + B = 0
       for (int i=-1000; i<=1000; i++) {
    	   if (i*i + 2*A*i + B == 0) {
    		   System.out.print(i + " ");
    	   }
       }
        
    }

};
