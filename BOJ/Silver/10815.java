import java.io.*;
import java.util.*;

// 1. 완탐 접근
// 맨 앞부터 검색 -> 최악 : N * M

// 2. 최적화
// 검색하는 속도를 줄이자
// cards를 정렬하고 각각 이분탐색

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	int N = Integer.parseInt(br.readLine());
    	int[] cards = new int[N];
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for (int i=0; i<N; i++) {
    		cards[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	Arrays.sort(cards);
    	
    	int M = Integer.parseInt(br.readLine());
    	st = new StringTokenizer(br.readLine());
    	for (int i=0; i<M; i++) {
    		int target = Integer.parseInt(st.nextToken());
    		int s = 0;
    		int e = N-1;
    		boolean isFound = false;
    		
    		while (s <= e) {
    			int m = (s+e)/2;
    			int cardAtM = cards[m];
    			if (cardAtM == target) {
    				sb.append(1 + " ");
    				isFound = true;
    				break;
    			} else if (cardAtM < target) {
    				s = m + 1;
    			} else { // cardAtM > target
    				e = m - 1;
    			}
    		}
    		
    		if (!isFound) {
    			sb.append(0 + " ");
    		}
    	}
    	System.out.print(sb);
    }    
};
