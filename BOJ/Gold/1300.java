// 참고한 글 : https://st-lab.tistory.com/281

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        
        // B[k] = x일 때 x를 이분탐색으로 찾는다
        long start = 1;
        long end = k;
        
        while (start < end) {
        	
        	long mid = (start + end) / 2;
        	
        	// 일단 x보다 작거나 같은 값의 개수를 찾는다
        	long cnt = 0;
        	for (int i=1; i<=N; i++) { cnt += Math.min((mid / i), N); }
        	
        	if (k <= cnt) { end = mid;
        	} else { start = mid + 1; }
        	
        }
        
        System.out.println(start);
        
    }

}
