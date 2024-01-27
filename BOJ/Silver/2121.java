import java.io.*;
import java.util.*;

// 1. 완탐 접근
// 점 4개 뽑아서 조건에 맞는지 확인 : 500000C4

// 2. 최적화
// 점 하나 고르고 조건에 맞는 점들이 있는지 확인
public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int A = Integer.parseInt(st.nextToken());
    	int B = Integer.parseInt(st.nextToken());
     	
    	int[][] dots = new int[N][2];
    	for (int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine());
    		int x = Integer.parseInt(st.nextToken());
    		int y = Integer.parseInt(st.nextToken());
    		
    		dots[i][0] = x;
    		dots[i][1] = y;
    	}
    	
    	Arrays.sort(dots, (o1, o2) -> {
    		if (o1[0] == o2[0]) {
    			return o1[1] - o2[1];
    		}
    		return o1[0] - o2[0];
    	});
    	
    	int cnt = 0;
    	for (int i=0; i<N-3; i++) {
    		int ax = dots[i][0];
    		int ay = dots[i][1];
    		
    		int bx = ax + A;
    		int by = ay;
    		int cx = ax + A;
    		int cy = ay + B;
    		int dx = ax;
    		int dy = ay + B;
    		
    		if (findDot(bx, by, dots) && findDot(cx, cy, dots) && findDot(dx, dy, dots)) {
    			cnt++;
    		}
    	}
    	
    	System.out.print(cnt);
    }
    
    static boolean findDot(int x, int y, int[][] dots) {
		
		int s = 0;
		int e = dots.length-1;
		
		while (s <= e) {
			int m = (s + e)/2;
			
			if (dots[m][0] == x && dots[m][1] == y) {
				return true;
			} else if (dots[m][0] < x || (dots[m][0] == x && dots[m][1] < y)) {
				s = m + 1;
			} else {
				e = m - 1;
			}
		}
		
		return false;
	}
};
