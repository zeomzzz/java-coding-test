import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, L, K;
	static int[] rs, cs;
	static Star[] stars;
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken()); // 구역의 가로
    	M = Integer.parseInt(st.nextToken()); // 구역의 세로
    	L = Integer.parseInt(st.nextToken()); // 트램펄린 한 변의 길이
    	K = Integer.parseInt(st.nextToken()); // 별똥별의 수
    	stars = new Star[K];
    	
    	rs = new int[K];
    	cs = new int[K];
    	
    	for (int i=0; i<K; i++) {
    		st = new StringTokenizer(br.readLine());
    		stars[i] = new Star(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    		rs[i] = stars[i].r;
    		cs[i] = stars[i].c;
    	}
    	
    	int collision = 0;
    	int tmp;
    	for (int r : rs) {
    		for (int c : cs) {
    			tmp = 0;
    			
    			for (Star star : stars) {
    				if (star.r >= r && star.r <= r+L && star.c >= c && star.c <= c+L) {
    					tmp++;
    				}
    			}
    			
    			collision = Math.max(collision, tmp);
    		}
    	}
    	
    	System.out.print(K - collision);
    }
    
    static class Star {
    	int r;
    	int c;
    	
    	Star() {}
    	
    	Star(int r, int c) {
    		this.r = r;
    		this.c = c;
    	}
    }
    
};
