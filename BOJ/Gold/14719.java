import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	// i번째 빗물 높이 : i 이전 최대 높이와 i 이후 최대 높이의 min 값
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int H = Integer.parseInt(st.nextToken()); // 세로
    	int W = Integer.parseInt(st.nextToken()); // 가로
    	
    	int[] blocks = new int[W];
    	st = new StringTokenizer(br.readLine());
    	for (int i=0; i<W; i++) {
    		blocks[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	int[] leftBlocks = new int[W];
    	int[] rightBlocks = new int[W];
    	for (int i=1; i<W-1; i++) {
    		leftBlocks[i] = Math.max(leftBlocks[i-1], blocks[i-1]);
    		rightBlocks[W-i-1] = Math.max(rightBlocks[W-i], blocks[W-i]);
    	}
    	
    	int answer = 0;
    	for (int i=1; i<W-1; i++) { // 현재 높이가 더 낮을 때만
    		int h = Math.min(leftBlocks[i], rightBlocks[i]);
    		if (h > blocks[i]) {
    			answer += h - blocks[i];
    		}
    	}
    	
    	System.out.print(answer);
    }    
};

// 240826
// 1억 = 100,000,000
import java.util.*;
import java.io.*;

class Main {
	
	static int H, W;
	static int[] blocks, prefixMax, suffixMax;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        
        blocks = new int[W+2];
        prefixMax = new int[W+2];
        suffixMax = new int[W+2];
        
        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=W; i++) {
        	blocks[i] = Integer.parseInt(st.nextToken());
        	prefixMax[i] = Math.max(prefixMax[i-1], blocks[i]);
        	suffixMax[i] = blocks[i];
        }
        
        for (int i=W; i>=0; i--) {
        	suffixMax[i] = Math.max(suffixMax[i+1], suffixMax[i]);
        }
        
        int answer = 0;
        for (int i=1; i<=W; i++) {
        	answer += Math.min(prefixMax[i], suffixMax[i]) - blocks[i];
        }
        
        System.out.print(answer);
        
    }
   
};
