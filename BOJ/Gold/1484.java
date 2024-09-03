import java.io.*;
import java.util.*;

// 원래 몸무게 A, 현재 몸무게 B
// G = B^2 - A^2 = (B + A) * (B - A)

// 1. 완탐 접근
// A에 1부터 넣어보면서 제곱수인 B 찾기

// 2. 최적화
// 1부터 다 넣어보는 것부터,, 오바다
// G의 약수 찾고 A, B가 되는지 보기
// G = x * y (x<y)이면 x = B-A, y = B+A -> B = (x+y)/2

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	int G = Integer.parseInt(br.readLine());
    	
    	for (int x=(int)Math.pow(G, 0.5); x>0; x--) {
    		if (G%x == 0 && x*x != G) {
    			int y = G/x;
    			if ((x+y)%2 == 0) {
    				sb.append((x+y)/2 + "\n");
    			}
    		}
    	}
    	if (sb.length() == 0) {
    		System.out.print(-1);
    	} else {
    		System.out.print(sb);
    	}
    }    
};


// 240903
/*
 * 원래 몸무게 : A, 현재 몸무게 : B 이면
 * G = B^2 - A^2
 * G = (B+A)(B-A)
 * G의 약수 중 찾기
 */
import java.util.*;
import java.io.*;

class Main {
	
	static long G;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        G = Long.parseLong(st.nextToken());
        List<Long> lst = new LinkedList<>();
        for (long i = 1; i < Math.pow(G, 0.5); i++) {
        	if (G % i == 0) {
        		long j = G / i;
        		
        		if ((i + j) % 2 == 0) {
        			lst.add((i+j)/2);
        		}
        	}
        }
        
        Collections.sort(lst);
        if (lst.size() == 0) {
        	System.out.print(-1);
        } else {
        	StringBuilder sb = new StringBuilder();
        	for (long l : lst) {
        		sb.append(l + "\n");
        	}
        	System.out.print(sb);
        }
        
    }
   
};
