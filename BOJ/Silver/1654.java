import java.io.*;
import java.util.*;

// 최대 랜선 길이를 구하여라
// 1. 완탐 접근
// 최대값부터 -1하면서 찾기 -> (2^31 - 1) * K

// 2. 최적화
// 이분탐색으로 찾기
public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int K = Integer.parseInt(st.nextToken()); // 가지고 있는 랜선의 개수
    	int N = Integer.parseInt(st.nextToken()); // 필요한 랜선의 개수
    	
    	long[] lans = new long[K];
    	long s = 1;
    	long e = -1;
    	for (int i=0; i<K; i++) {
    		lans[i] = Long.parseLong(br.readLine());
    		e = Math.max(e, lans[i]);
    	}
    	
    	long ans = 0;
    	while (s <= e) {
    		long m = (s + e) / 2;
    		long cnt = 0;
    		for (long lan : lans) {
    			cnt += lan / m;
    		}
    		
    		if (cnt >= N) { // 필요한 만큼 가능 -> 더 길게도 되는지 확인
    			ans = m;
    			s = m+1;
    		} else { // 필요한 만큼 안됨 -> 더 짧게 만들어보기
    			e = m-1;
    		}
    	}
    	
    	System.out.print(ans);
    }
};
