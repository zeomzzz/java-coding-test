import java.io.*;
import java.util.*;

// 1. 완탐 접근
// 맨 앞부터 끝까지 count : 500,000 * 500,000 -> 250,000,000,000 > 100,000,000

// 2. 최적화
// 2-1. 최적화 1
// 정렬해서 count

// 2-2. 최적화 2
// 정렬하고 이분탐색으로 시작점, 끝점 찾기

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
    		
    		// 시작점 찾기
    		int start = 0;
    		int end = N-1;
    		int first = -1;
    		while (start <= end) {
    			int mid = (start+end)/2;
    			int midCard = cards[mid];
    			
    			if (midCard == target) { // 같으면 일단 저장하고 왼쪽에 있는지 더 찾기
    				first = mid;
    				end = mid-1;
    			} else if (midCard < target) {
    				start = mid+1;
    			} else {
    				end = mid-1;
    			}
    		}
    		
    		if (first == -1) { // 없음!!
    			sb.append(0 + " ");
    			continue;
    		}
    		
    		// 끝점 찾기
    		start = first+1;
    		end = N-1;
    		int last = first;
    		
    		while (start <= end) {
    			int mid = (start + end)/ 2;
    			int midCard = cards[mid];
    			
    			if (midCard == target) {
    				last = mid;
    				start = mid + 1;
    			} else if (midCard < target) {
    				start = mid + 1;
    			} else {
    				end = mid - 1;
    			}
    		}
    		sb.append(last - first + 1 + " ");
    	}
    	System.out.print(sb);
    }    
};
