import java.io.*;
import java.util.*;

// 1. 완탐 접근
// - 3개 뽑기 : 1000C3 을 다 하기

// 2. 최적화
// 1) 두 개 고르고
// 2) 중간값이 있는지 이분탐색

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	int T = Integer.parseInt(br.readLine());
    	
    	StringTokenizer st;
    	for (int tc=0; tc<T; tc++) {
    		int N = Integer.parseInt(br.readLine());
    		st = new StringTokenizer(br.readLine());
    		int[] nums = new int[N];
    		for (int i=0; i<N; i++) {
    			nums[i] = Integer.parseInt(st.nextToken());
    		}
    		
    		Arrays.sort(nums);
    		int cnt = 0;
    		for (int a=0; a<N-2; a++) {
    			for (int c=a+2; c<N; c++) {
    				int s = a+1;
    				int e = c-1;
    				if ((nums[a] + nums[c])%2 != 0) continue;
    				int target = (nums[a] + nums[c])/2;
    				
    				while (s<=e) {
    					int m = (s+e)/2;
    					if (target == nums[m]) {
    						cnt++;
    						break;
    					} else if (target > nums[m]) {
    						s = m+1;
    					} else {
    						e = m-1;
    					}
    				}
    			}
    		}
    		
    		sb.append(cnt + "\n");
    		
    	} // tc
    	
    	System.out.println(sb);
    }
};
