import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	int H = Integer.parseInt(st.nextToken());
    	
    	int[] sumEven = new int[H+1]; // 앞, 뒤에 패딩
    	int[] sumOdd = new int[H+1]; // 앞, 뒤에 패딩
    	
    	for (int i=0; i<N; i++) {
    		int n = Integer.parseInt(br.readLine());
    		if (i%2 == 0) { // 석순
    			sumEven[1]++;
    			sumEven[1+n]--;
    		} else { // 종유석
    			sumOdd[H]++;
    			sumOdd[H-n]--;
    		}
    	}
    	
    	int[] dpEven = new int[H+2];
    	int[] dpOdd = new int[H+2];
    	for (int i=1; i<H+1; i++) {
    		dpEven[i] = dpEven[i-1] + sumEven[i];
    		dpOdd[H+1-i] = dpOdd[H+2-i] + sumOdd[H+1-i];
    	}
    	
    	int cnt = 0;
    	int min = Integer.MAX_VALUE;
    	int[] dpSum = new int[H+2];
    	for (int i=1; i<H+1; i++) {
    		dpSum[i] = dpEven[i] + dpOdd[i];
    		if (dpSum[i] < min) {
    			cnt = 1;
    			min = dpSum[i];
    		} else if (dpSum[i] == min) {
    			cnt++;
    		}
    	}
    	
    	System.out.printf("%d %d", min, cnt);
    }    
};

// 240826
import java.util.*;
import java.io.*;

class Main {
	
	static int N, H;
	static int[] blocks;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        
        blocks = new int[H+2];
        int size = 0;
        for (int i=0; i<N; i++) {
        	size = Integer.parseInt(br.readLine());
        	if (i%2 == 0) {
        		blocks[1]++;
        		blocks[size+1]--;
        	} else {
        		blocks[H+1]--;
        		blocks[H+1-size]++;
        	}
        }
        
        int min = Integer.MAX_VALUE;
        int cnt = 0;
        for (int i=1; i<=H; i++) {
        	blocks[i] += blocks[i-1];
        	if (blocks[i] < min) {
        		min = blocks[i];
        		cnt = 1;
        	} else if (blocks[i] == min) {
        		cnt++;
        	}
        }
        
        System.out.print(min + " " + cnt);
        
    }
   
};
