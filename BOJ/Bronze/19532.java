import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int a = Integer.parseInt(st.nextToken());
    	int b = Integer.parseInt(st.nextToken());
    	int c = Integer.parseInt(st.nextToken());
    	int d = Integer.parseInt(st.nextToken());
    	int e = Integer.parseInt(st.nextToken());
    	int f = Integer.parseInt(st.nextToken());
    	
    	// x, y를 완탐 (2,000 * 2,000 < 1억)
    	outer: for (int x=-999; x<=999; x++) {
    		for (int y=-999; y<=999; y++) {
    			if (a*x + b*y == c && d*x + e*y == f) {
    				System.out.printf("%d %d", x, y);
    				break outer;
    			}
    		}
    	}
    	
    }

};

// 240425
import java.io.*;
import java.util.*;

// 100 * 100 * 100 = 1,000,000 < 100,000,000

public class Main {
	
	static int a, b, c, d, e, f;
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	a = Integer.parseInt(st.nextToken());
    	b = Integer.parseInt(st.nextToken());
    	c = Integer.parseInt(st.nextToken());
    	d = Integer.parseInt(st.nextToken());
    	e = Integer.parseInt(st.nextToken());
    	f = Integer.parseInt(st.nextToken());
    	
    	int x = 0;
    	int y = 0;
    	
    	for (int i=-999; i<=999; i++) {
    		for (int j=-999; j<=999; j++) {
    			if (a*i + b*j != c) continue;
    			if (d*i + e*j != f) continue;
    			x = i;
    			y = j;
    		}
    	}
    	
    	System.out.print(x + " " + y);
    	
    }
    
};
