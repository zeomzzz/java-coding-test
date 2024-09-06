import java.io.*;
import java.util.*;

// 1. 완탐 접근
// 최대 높이부터 다 잘라봄 : 1,000,000, * 2,000,000,000

// 2. 최적화
// 이분탐색으로 높이 찾기

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken()); // 필요한 나무
    	
    	long[] trees = new long[N];
    	st = new StringTokenizer(br.readLine());
    	
    	long s = 0;
    	long e = 0;
    	for (int i=0; i<N; i++) {
    		trees[i] = Long.parseLong(st.nextToken());
    		e = Math.max(trees[i], e);
    	}
    	
    	long H = -1;
    	while (s<=e) {
    		long m = (s+e)/2;
    		long sum = 0;
    		for (int i=0; i<N; i++) {
    			if (trees[i] >= m) { // 나무가 자르려는 높이보다 크면
    				sum += trees[i] - m;
    			}
    		}
    		
    		if (sum >= M) { // 필요한 만큼 가넝
    			H = Math.max(H, m);
    			s = m + 1; // 혹시 더 높일 수 있는지 확인
    		} else {
    			e = m - 1;
    		}
    	}
    	
    	System.out.print(H);
    	
    }
    
};

// 240906
/*
 * 
 * 
 */
import java.util.*;
import java.io.*;

class Main {
	
	static int N;
	static long M;
	static long[] trees;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());
        
        long start = 0;
        long end = 0;
        
        trees = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
        	trees[i] = Long.parseLong(st.nextToken());
        	end = Math.max(end, trees[i]);
        }
        
        long mid = 0;
        long max = 0;
        while (start <= end) {
        	mid = (start + end) / 2;
        	
        	long sum = 0;
        	for (long tree : trees) {
        		if (tree > mid) {
        			sum += tree - mid;
        		}
        	}
        	
        	if (sum >= M) { //  더 높여도 됨
        		start = mid + 1;
        		max = Math.max(max, mid);
        	} else { // 더 낮춰야 함
        		end = mid - 1;
        	}
        	
        }
        
        System.out.print(max);
        
    }
   
};
