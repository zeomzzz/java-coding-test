import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	
    	int[] columns = new int[1001];
    	StringTokenizer st;
    	for (int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine());
    		int L = Integer.parseInt(st.nextToken());
    		int H = Integer.parseInt(st.nextToken());
    		columns[L] = H;
    	}
    	
    	int[] roof = new int[1001];
    	roof[0] = columns[0];
    	for (int i=1; i<1001; i++) {
    		roof[i] = Math.max(roof[i-1], columns[i]);
    	}
    	
    	roof[1000] = columns[1000];
    	for (int i=999; i>=0; i--) {
    		roof[i] = Math.min(roof[i], Math.max(roof[i+1], columns[i]));
    	}
    	
    	int ans = 0;
    	for (int h : roof) {
    		ans += h;
    	}
    	
    	System.out.print(ans);
    	
    }
    
};

// 240111 : 누적합 풀이
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	int[] columns = new int[1001];
    	
    	StringTokenizer st;
    	// 기둥 높이 입력
    	for (int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine());
    		int L = Integer.parseInt(st.nextToken());
    		int H = Integer.parseInt(st.nextToken());
    		columns[L] = H;
    	}
    	
    	// i까지의 최대 높이
    	int[] prefixMax = new int[1001];
    	prefixMax[1] = columns[1];
    	for (int i=2; i<1001; i++) {
    		prefixMax[i] = Math.max(prefixMax[i-1], columns[i]);
    	}
    	
    	// i이전까지의 최대 높이
    	int[] suffixMax = new int[1001];
    	suffixMax[1000] = columns[1000];
    	for (int i=999; i>0; i--) {
    		suffixMax[i] = Math.max(suffixMax[i+1], columns[i]);
    	}
    	
    	int answer = 0;
    	for (int i=1; i<1001; i++) {
    		answer += Math.min(prefixMax[i], suffixMax[i]);
    	}
    	
    	System.out.print(answer);
    	
    }
    
};

// 240428
import java.io.*;
import java.util.*;

// 좌 -> 우 : 왼쪽과 나랑 비교해서 더 높은 것
// 우 -> 좌 : 오른쪽과 나랑 비교해서 더 높은 것

public class Main {
	
	static int[] heights, leftMax, rightMax;
	static int N, ans;
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(br.readLine());
    	heights = new int[1002];
    	leftMax = new int[1002];
    	rightMax = new int[1002];
    	
    	StringTokenizer st;
    	for (int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine());
    		heights[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
    	}
    	
    	for (int i=1; i<=1000; i++) {
    		leftMax[i] = Math.max(leftMax[i-1], heights[i]);
    	}
    	
    	for (int i=1000; i>=1; i--) {
    		rightMax[i] = Math.max(rightMax[i+1], heights[i]);
    	}
    	
    	ans = 0;
    	for (int i=1; i<=1000; i++) {
    		ans += Math.min(leftMax[i], rightMax[i]);
    	}
    	
    	System.out.print(ans);
    	
    }
    
};

// 240823
import java.util.*;
import java.io.*;

class Main {
	
	static int N;
	static int[] heights, front_max, rear_max;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        front_max = new int[1002]; // 좌->우 max
    	rear_max = new int[1002]; // 우->좌 max
    	
    	int idx = 0;
    	int h = 0;
    	for (int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine());
    		idx = Integer.parseInt(st.nextToken());
    		h = Integer.parseInt(st.nextToken());
    		
    		front_max[idx] = h;
    		rear_max[idx] = h;
    	}
    	
    	for (int i=1; i<=1000; i++) {
    		front_max[i] = Math.max(front_max[i], front_max[i-1]);
    		rear_max[1001-i] = Math.max(rear_max[1001-i], rear_max[1002-i]);
    	}
    	
    	int answer = 0;
    	for (int i=1; i<=1000; i++) {
    		answer += Math.min(front_max[i], rear_max[i]); // max 중 min
    	}
    	
    	System.out.print(answer);
    	
    }
    
};
