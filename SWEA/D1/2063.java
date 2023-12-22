import java.util.Arrays;
import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		} // N개 입력받음
		
		Arrays.sort(arr);
		
		System.out.println(arr[(N - 1) / 2]);
		
	} // scanner
}


// 풀이 2 : 선택 정렬 활용
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// N개의 수를 배열 arr에 입력 받음
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 선택 정렬 이용하여 idx (N-1)/2 수까지 정렬
		// pass : (N+1)/2번
		for(int i=0; i<(N+1)/2; i++) {
			int minIdx = i;
			for(int j=i+1; j<N; j++) {
				if(arr[minIdx] > arr[j]) minIdx = j;
			} // 최솟값 인덱스가 j
			
			// swap(arr[minIdx], arr[i])
			int tmp = arr[minIdx];
			arr[minIdx] = arr[i];
			arr[i] = tmp;
		}
		
		// 중앙값(arr[(N-1)/2]) 출력
		System.out.println(arr[(N-1)/2]);

	} // main

}

// 풀이 3 : BufferedReader + 선택정렬 (231222)
import java.util.*;
import java.io.*;

// 선택정렬로 (N+1)/2 번째로 작은 수 찾기
public class Solution {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	int[] nums = new int[N];
    	st = new StringTokenizer(br.readLine());
    	for (int i=0; i<N; i++) {
    		nums[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	// (N+1)/2 번째 작은 수를 찾아야 함
    	int cnt = (N+1)/2;
    	for (int i=0; i<cnt; i++) {
    		int min = nums[i];
    		int minIdx = i;
    		
    		for (int j=i+1; j<N; j++) {
    			if (nums[j] < min) {
    				min = nums[j];
    				minIdx = j;
    			}
    		}
    		
    		// swap : nums[i], nums[minIdx]
    		int tmp = nums[i];
    		nums[i] = nums[minIdx];
    		nums[minIdx] = tmp;
    	}
    	
    	System.out.println(nums[cnt-1]);
    	
    }
}

풀이 4 : BufferedReader + ArraysSort (231222)
import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	int[] nums = new int[N];
    	st = new StringTokenizer(br.readLine());
    	for (int i=0; i<N; i++) {
    		nums[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	Arrays.sort(nums);
    	
    	System.out.println(nums[(N+1)/2 - 1]);
    	
    }

}
