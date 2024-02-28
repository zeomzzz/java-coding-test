import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int d, s;
	static int[][] A;
	static boolean[][] cloudExists;
	static List<Cloud> clouds;
	static int[] dr = {0, 0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dc = {0, -1, -1, 0, 1, 1, 1, 0, -1};
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	A = new int[N][N];
    	for (int r=0; r<N; r++) {
    		st = new StringTokenizer(br.readLine());
    		for (int c=0; c<N; c++) A[r][c] = Integer.parseInt(st.nextToken());
    	}
    	
    	clouds = new LinkedList<>();
    	
    	// 비바라기 시전
    	rainMagic();
    	
    	for (int t=0; t<M; t++) {
    		st = new StringTokenizer(br.readLine());
    		d = Integer.parseInt(st.nextToken());
    		s = Integer.parseInt(st.nextToken());
    		
    		move(d, s);
    		rain();
    		waterCopy();
    		makeCloud();
    	}
    	
    	int answer = 0;
    	for (int r=0; r<N; r++) {
    		for (int c=0; c<N; c++) {
    			answer += A[r][c];
    		}
    	}
    	
    	System.out.print(answer);
    	
    }
    
    static void rainMagic() {
    	clouds.add(new Cloud(N-1, 0));
    	clouds.add(new Cloud(N-1, 1));
    	clouds.add(new Cloud(N-2, 0));
    	clouds.add(new Cloud(N-2, 1));
    }
    
    static void move(int d, int s) {
    	for (int i=0; i<clouds.size(); i++) {
    		int tmpR = clouds.get(i).r;
    		int tmpC = clouds.get(i).c;
    		for (int j=0; j<s; j++) {
    			tmpR = (tmpR + dr[d] + N) % N;
        		tmpC = (tmpC + dc[d] + N) % N;
    		}
    		clouds.get(i).r = tmpR;
    		clouds.get(i).c = tmpC;
    	}
    }
    
    static void rain() {
    	for (Cloud cloud : clouds) {
    		A[cloud.r][cloud.c] += 1;
    	}
    }
   
    
    static void waterCopy() {
    	for (Cloud cloud : clouds) {
    		int cnt = 0;
    		int r = cloud.r;
    		int c = cloud.c;
    		if (r-1 >= 0) {
    			if (c-1 >= 0 && A[r-1][c-1] > 0) cnt++;
    			if (c+1 < N && A[r-1][c+1] > 0) cnt++;
    		}
    		if (r+1 < N) {
    			if (c-1 >= 0 && A[r+1][c-1] > 0) cnt++;
    			if (c+1 < N && A[r+1][c+1] > 0) cnt++;
    		}
    		A[r][c] += cnt;
    	}
    }
    
    static void makeCloud() {
    	cloudExists = new boolean[N][N];
    	for (Cloud cloud : clouds) cloudExists[cloud.r][cloud.c] = true;
    	
    	clouds.clear();
    	
    	for (int r=0; r<N; r++) {
    		for (int c=0; c<N; c++) {
    			if (A[r][c] >= 2 && !cloudExists[r][c]) {
    				clouds.add(new Cloud(r, c));
    				A[r][c] -= 2;
    			}
    		}
    	}
    }
    
};

class Cloud {
	int r, c;
	
	Cloud(int r, int c) {
		this.r = r;
		this.c = c;
	}
};
