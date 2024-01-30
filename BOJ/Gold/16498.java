import java.io.*;
import java.util.*;

// 1. 완탐
// 가능한 모든 조합을 테스트 : 1000 * 1000 * 1000

// 2. 최적화
// "가장 작은 벌점을 구하기"
// 0에 가깝게 만들어야 함
// 나누어서 접근 : a, b에서 최소인거 찾고
// 이때 c 추가해서 최소인 것 찾기
public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int A = Integer.parseInt(st.nextToken()); // A 카드 수
    	int B = Integer.parseInt(st.nextToken()); // B 카드 수
    	int C = Integer.parseInt(st.nextToken()); // C 카드 수
    	
    	int[] aCards = new int[A];
    	int[] bCards = new int[B];
    	int[] cCards = new int[C];
    	
    	st = new StringTokenizer(br.readLine());
    	for (int i=0; i<A; i++) {
    		aCards[i] = Integer.parseInt(st.nextToken());
    	}
    	st = new StringTokenizer(br.readLine());
    	for (int i=0; i<B; i++) {
    		bCards[i] = Integer.parseInt(st.nextToken());
    	}
    	st = new StringTokenizer(br.readLine());
    	for (int i=0; i<C; i++) {
    		cCards[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	Arrays.sort(aCards);
    	Arrays.sort(bCards);
    	Arrays.sort(cCards);
    	int ans = Integer.MAX_VALUE; 
    	
    	// a, b를 정하기
    	for (int a : aCards) {
    		
    		// B 카드 선택
    		int b = search(a, bCards);
    		// C 카드 선택
    		int ac = search(a, cCards);
    		int bc = search(b, cCards);
    		
    		// 벌점 구하기
    		int penalty1 = calPenalty(a, b, ac);
    		int penalty2 = calPenalty(a, b, bc);
    		
    		ans = Math.min(ans, Math.min(penalty1, penalty2));
    	}
    	
    	System.out.print(ans);
    }
    
    static int search(int target, int[] cards) {
    	int s = 0;
    	int e = cards.length - 1;
    	
    	int res = Integer.MAX_VALUE;
    	while (s <= e) {
    		int m = (s+e)/2;
    		int tmpCard = cards[m];
    		
    		if (tmpCard == target) {
    			res = tmpCard;
    			break;
    		} else if (tmpCard > target) {
    			e = m-1;
    		} else {
    			s = m+1;
    		}
    		
    		if (Math.abs(Math.max(target, tmpCard) - Math.min(target, tmpCard)) < Math.abs(Math.max(target, res) - Math.min(target, res))) {
    			res = tmpCard;
    		}
    	}
    	
    	return res;
    }
    
    static int calPenalty(int a, int b, int c) {
    	return Math.abs(Math.max(Math.max(a, b), c) - Math.min(Math.min(a, b), c));
    }
    
};
