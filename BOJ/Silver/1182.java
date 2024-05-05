import java.io.*;
import java.util.*;

// 백트래킹으로 확인
public class Main {
	
	static int answer = 0;
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken()); // 정수의 개수
    	long S = Long.parseLong(st.nextToken()); // 합
    	
    	st = new StringTokenizer(br.readLine());
    	long[] nums = new long[N];
    	for (int i=0; i<N; i++) {
    		nums[i] = Long.parseLong(st.nextToken());
    	}
    	Arrays.sort(nums);
    	backtracking(0, 0, 0, S, N, nums);
    	
    	System.out.print(answer);
    	
    }
    
    static void backtracking(int cur, int start, long sum, long target, int N, long[] nums) {
    	
    	if (cur != 0 && sum == target) {
    		answer++;
    	}
    	
    	for (int i=start; i<N; i++) {
    		backtracking(cur+1, i+1, sum+nums[i], target, N, nums);
    	}
    }
    
};

// static에 answer 올리기 않는 방법
import java.io.*;
import java.util.*;

// 백트래킹으로 확인
public class Main {
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken()); // 정수의 개수
    	long S = Long.parseLong(st.nextToken()); // 합
    	
    	st = new StringTokenizer(br.readLine());
    	long[] nums = new long[N];
    	for (int i=0; i<N; i++) {
    		nums[i] = Long.parseLong(st.nextToken());
    	}
    	
    	int answer = 0;
    	answer += backtracking(0, 0, 0, S, N, nums);
    	
    	System.out.print(answer);
    	
    }
    
    static int backtracking(int cur, int start, long sum, long target, int N, long[] nums) {
    	
    	int answer = 0;
    	
    	if (cur != 0 && sum == target) {
    		answer++;
    	}
    	
    	for (int i=start; i<N; i++) {
    		answer += backtracking(cur+1, i+1, sum+nums[i], target, N, nums);
    	}
    	
    	return answer;
    }
    
};

// 다른 방식의 백트래킹
import java.io.*;
import java.util.*;

// 백트래킹으로 확인
public class Main {
	
	static int cnt = 0;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken()); // 정수 N개
    	long S = Long.parseLong(st.nextToken()); // 합 S
    	
    	long[] nums = new long[N];
    	st = new StringTokenizer(br.readLine());
    	for (int i=0; i<N; i++) {
    		nums[i] = Long.parseLong(st.nextToken());
    	}
    	
    	backtracking(0, 0, 0, S, N, nums);
    	
    	System.out.print(cnt);
    }
    
    static void backtracking(int cur, int start, long sum, long target, int N, long[] nums) {
    	
    	if (start == N) {
    		if (cur != 0 && sum == target) {
    			cnt++;
    		}
    		return;
    	}
    	
    	// 이번거 선택
    	backtracking(cur+1, start+1, sum+nums[start], target, N, nums);
    	// 선택 안함
    	backtracking(cur, start+1, sum, target, N, nums);
    }
    
};

// 240505
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, S, sum, answer;
	static int[] nums;
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	S = Integer.parseInt(st.nextToken());
    	
    	nums = new int[N];
    	
    	st = new StringTokenizer(br.readLine());
    	for (int i=0; i<N; i++) {
    		nums[i] = Integer.parseInt(st.nextToken());
    	}
    	Arrays.sort(nums);
    	
    	sum = 0;
    	answer = 0;
    	
    	recur(0);
    	
    	System.out.print(answer);
    }
    
    public static void recur(int start) {
    	
    	if (start == N) return;
    	
    	for (int i=start; i<N; i++) {
    		sum += nums[i];
    		if (sum == S) answer++;
    		
    		recur(i+1);
    		sum -= nums[i];
    	}
    	
    }
    
};
