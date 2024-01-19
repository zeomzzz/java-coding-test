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
