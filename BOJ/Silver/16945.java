import java.io.*;
import java.util.*;

// 1. 모든 가능한 매직 스퀘어를 만들고
// 2. 비용을 구한다.

public class Main {
	
	static int[][] square, magicSquare;
	static boolean[] visited;
	static int answer;
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	square = new int[3][3];
    	magicSquare = new int[3][3];
    	
    	StringTokenizer st;
    	for (int r=0; r<3; r++) {
    		st = new StringTokenizer(br.readLine());
    		for (int c=0; c<3; c++) {
    			square[r][c] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	visited = new boolean[10];
    	answer = Integer.MAX_VALUE;
    	
    	recur(0, 0, 1);
    	
    	System.out.print(answer);
    	
    }
    
    public static void recur(int r, int c, int cur) {
    	
    	if (r == 3) {
    		r = 0;
    		c += 1;
    		
    		if (c == 3) {
    			// 매직 스퀘어인지 확인
    			if (isMagicSquare()) {
    				// 비용 구하기
    				calPrice();
    			}
    			return;
    		}
    	}
    	
    	if (cur == 10) return;
    	
    	// cur을 고르기
    	if (!visited[cur]) {
    		magicSquare[r][c] = cur;
        	visited[cur] = true;
        	recur(r+1, c, 1);
        	visited[cur] = false;
    	}
    	
    	// cur을 안고르기
    	recur(r, c, cur+1);
    }
    
    public static boolean isMagicSquare() {
    	
    	int target = (1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9) / 3;
    	
    	for (int r=0; r<3; r++) {
    		int sum = 0;
    		for (int c=0; c<3; c++) {
    			sum += magicSquare[r][c];
    		}
    		if (sum != target) return false;
    	}
    	
    	for (int c=0; c<3; c++) {
    		int sum = 0;
    		for (int r=0; r<3; r++) {
    			sum += magicSquare[r][c];
    		}
    		if (sum != target) return false;
    	}
    	
    	int sum = 0;
    	for (int r=0; r<3; r++) {
    		sum += magicSquare[r][r];
    	}
    	if (sum != target) return false;
    	
    	if (magicSquare[0][2] + magicSquare[1][1] + magicSquare[2][0] != target) return false;
    	
    	return true;
    }
    
    public static void calPrice() {
    	int result = 0;
    	
    	for (int r=0; r<3; r++) {
    		for (int c=0; c<3; c++) {
    			result += Math.abs(square[r][c] - magicSquare[r][c]);
    		}
    	}
    	
    	answer = Math.min(answer, result);
    }
    
};
