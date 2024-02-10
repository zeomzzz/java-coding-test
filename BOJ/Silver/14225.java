import java.io.*;
import java.util.*;

// 백트래킹으로 확인
// 부분 수열의 합으로 나올 수 없는 가장 작은 자연수
// 합을 다 오름차순 TreeSet에 넣기 : 2**20
// 순회하면서 가장 작은 값 찾기
public class Main {
	
	static Set<Integer> sumSet = new TreeSet<>();
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	
    	int[] nums = new int[N];
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for (int i=0; i<N; i++) {
    		nums[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	backtracking(0, 0, 0, N, nums);
    	
    	int ans = 1;
    	for (int sum : sumSet) {
    		if (sum == ans) {
    			ans++;
    		} else {
    			break;
    		}
    	}
    	System.out.print(ans);
    }
    
    static void backtracking(int cnt, int cur, int sum, int N, int[] nums) {
    	if (cur == N) {
    		if (cnt > 0) {
    			sumSet.add(sum);
    		}
    		return;
    	}
    	
    	// 이번거 선택
    	backtracking(cnt+1, cur+1, sum+nums[cur], N, nums);
    	// 이번거 선택 안함
    	backtracking(cnt, cur+1, sum, N, nums);
    }
    
};

import java.io.*;
import java.util.*;

// 백트래킹으로 확인
// 부분 수열의 합으로 나올 수 없는 가장 작은 자연수
// 합을 다 오름차순 List에 넣기 : 2**20
// 순회하면서 가장 작은 값 찾기
public class Main {
	
	static List<Integer> sums = new LinkedList<>();
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	
    	int[] nums = new int[N];
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for (int i=0; i<N; i++) {
    		nums[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	backtracking(0, 0, 0, N, nums);
    	Collections.sort(sums);
    	
    	int min = 1;
    	for (int sum : sums) {
    		if (sum < min + 1) {
    			min = sum + 1;
    		} else {
    			break;
    		}
    	}
    	System.out.print(min);
    }
    
    static void backtracking(int cnt, int cur, int sum, int N, int[] nums) {
    	if (cur == N) {
    		if (cnt > 0) {
    			sums.add(sum);
    		}
    		return;
    	}
    	
    	// 이번거 선택
    	backtracking(cnt+1, cur+1, sum+nums[cur], N, nums);
    	// 이번거 선택 안함
    	backtracking(cnt, cur+1, sum, N, nums);
    }
    
};
