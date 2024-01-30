import java.io.*;
import java.util.*;

// 1. 완탐 접근 : C개의 집 고르고 가장 인접한 공유기 사이의 거리 구하기
// 2. 최적화
// 매개변수 탐색
public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken()); // 집의 개수
    	int C = Integer.parseInt(st.nextToken()); // 공유기의 개수
    	
    	long[] houses = new long[N];
    	for (int i=0; i<N; i++) {
    		houses[i] = Long.parseLong(br.readLine());
    	}
    	Arrays.sort(houses);
    	
    	long s = 1; // 거리의 최솟값
    	long e = houses[N-1] - houses[0]; // 거리의 최댓값
    	
    	// 이분탐색
    	long ans = -1;
    	while (s <= e) {
    		long m = (s+e)/2;
    		
    		int cnt = 1;
    		long prev = houses[0];
    		for (int i=1; i<N; i++) {
    			if (houses[i] - prev >= m) {
    				cnt++;
    				prev = houses[i];
    			}
    		}
    		
    		if (cnt >= C) { // C개 설치 가능 -> 더 멀리 둬도 되는지 확인
    			ans = m;
    			s = m+1;
    		} else {
    			e = m-1;
    		}
    	}
    	
    	System.out.print(ans);
    }
};
