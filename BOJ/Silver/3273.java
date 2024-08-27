import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	// 1. 완탐 접근 -> 시간 초과
    	// 2중 for문으로 확인 : O(n^2) : 100,000 * 100,000 > 100,000,000
    	
    	// 2. 최적화할 수 있는 부분 찾기
    	// 정수 하나 당 정답이 될 수 있는 정수는 하나 -> 따라서 반복문을 끝까지 돌 필요가 없다.
    	// 방안 1. 2중 for문으로 찾되, 정답 찾으면 break -> 중복 탐색 가능성
    	// 방안 2. 정렬 후 ai를 고정 한 후 포인터 이동하여 aj 찾기 -> O(N)
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	
    	int[] nums = new int[n];
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for (int i=0; i<n; i++) {
    		nums[i] = Integer.parseInt(st.nextToken());
    	}
    	int x = Integer.parseInt(br.readLine());
    	
    	Arrays.sort(nums);
    	int cnt = 0;
    	int end = n-1;
    	int start = 0;
    	while (start < end) {
    		if (nums[start] + nums[end] == x) {
    			cnt++;
    			start++; //nums[start]는 정답 후보에서 제외
    			end--; // nums[end]는 정답 후보에서 제외
    		} else if (nums[start] + nums[end] < x) {
    			start++; // nums[start]는 정답 후보에서 제외
    		} else {
    			end--; // nums[end]는 정답 후보에서 제외
    		}
    	}
    	
    	System.out.print(cnt);
    }    
};

// 240827
import java.util.*;
import java.io.*;

class Main {
	
	static int n, x;
	static int[] nums;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
        	nums[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        
        Arrays.sort(nums);
        
        int s = 0;
        int e = n-1;
        int answer = 0;
        while (s < e) {
        	int tmpSum = nums[s] + nums[e];
        	if (tmpSum < x) {
        		s++;
        	} else if (tmpSum > x) {
        		e--;
        	} else {
        		answer++;
        		e--;
        	}
        }
        
        System.out.print(answer);
    }
   
};
