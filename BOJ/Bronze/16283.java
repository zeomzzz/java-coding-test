// 76ms
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


import java.io.*;
import java.util.*;

// 완탐 풀이 (116ms)
// 1,000 * 1,000 = 1,000,000 < 1억 -> 1초 안에 가능
public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int a = Integer.parseInt(st.nextToken()); // 1 ~ 1,000
    	int b = Integer.parseInt(st.nextToken()); // 1 ~ 1,000
    	int n = Integer.parseInt(st.nextToken()); // 2 ~ 1,000
    	int w = Integer.parseInt(st.nextToken()); //  2 ~ 1,000,000
    	
    	int cnt = 0;
    	int sheepCnt = 0;
    	int goatCnt = 0;
    	for (int sheep=1; sheep<=n; sheep++) {
    		for (int goat=1; goat<=n; goat++) {
    			if (sheep + goat == n && sheep * a + goat * b == w) {
    				cnt++;
    				sheepCnt = sheep;
    				goatCnt = goat;
    			}
    		}
    	}
    	
    	if (cnt == 1) {
    		System.out.printf("%d %d", sheepCnt, goatCnt);
    	} else {
    		System.out.print(-1);
    	}
    	
    }

}

// 240423
import java.io.*;
import java.util.*;

// sheep + lamb = n
// sheep * a + lamb * b == w

public class Main {
	
	static int a, b, n, w;
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	a = Integer.parseInt(st.nextToken()); // 1 ~ 1,000
    	b = Integer.parseInt(st.nextToken()); // 1 ~ 1,000
    	n = Integer.parseInt(st.nextToken()); // 2 ~ 1,000 -> 1 <= sheep, lamb <= 999
    	w = Integer.parseInt(st.nextToken()); // 2 ~ 1,000,000
    	
    	// 완탐하면
    	// 1000 * 1000 = 1,000,000 <= 100,000,000
    	int cnt = 0;
    	int sheep = 0;
    	int lamb = 0;
    	for (int s=1; s<=1000; s++) {
    		for (int l=1; l<=1000; l++) {
    			if (s + l != n) continue;
    			if (s*a + l*b != w) continue;
    			sheep = s;
    			lamb = l;
    			cnt++;
    		}
    	}
    	
    	if (cnt != 1) {
    		System.out.print(-1);
    	} else {
    		System.out.print(sheep + " " + lamb);
    	}
    	
    }
    
};

// 240815
import java.util.*;
import java.io.*;

class Main {
	
	static int a, b, n, w;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        
        int sheep = 0;
        int lamb = 0;
        
        for (int i=1; i<n; i++) {
        	if (a*i + b*(n-i) == w) {
        		if (sheep == 0 && lamb == 0) { // 아직 해가 없었으면
        			sheep = i;
        			lamb = n-i;
        		} else { // 해가 이미 있음 == 해가 2개 이상
        			sheep = lamb = 0;
        			break;
        		}
        	}
        }
        
        if (sheep == 0 && lamb == 0) {
        	System.out.print(-1);
        } else {
        	System.out.print(sheep + " " + lamb);
        }
        
    }

};
