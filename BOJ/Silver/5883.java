import java.io.*;
import java.util.*;

public class Main {
	
	static int N, ans;
	static int[] persons;
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(br.readLine());
    	persons = new int[N];
    	for (int i=0; i<N; i++) {
    		persons[i] = Integer.parseInt(br.readLine());
    	}
    	
    	Stack<Integer> stack = new Stack<>();
    	for (int i=0; i<N; i++) { //  i번째 빼고
    		stack.clear();
    		for (int j=0; j<N; j++) {
    			if (persons[i] == persons[j]) continue;
    			if (stack.empty()) {
    				stack.push(persons[j]);
    			} else if (stack.peek() == persons[j]) {
    				stack.push(persons[j]);
    			} else {
    				stack.clear();
    				stack.push(persons[j]);
    			}
    			ans = Math.max(ans, stack.size());
    		}
    	}
    	
    	System.out.print(ans);
    	
    }
    
};

// 240819
import java.io.*;

class Main {
	
	static int N;
	static boolean[] visited;
	static int[] nums;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
    	
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        int l = 0;
        for (int i=0; i<N; i++) {
        	nums[i] = Integer.parseInt(br.readLine());
        	l = Math.max(l, nums[i]);
        }
        
        visited = new boolean[l+1];
        
        int answer = -1;
        for (int i=0; i<N; i++) { // idx i를 빼는 상황 => 1000
        	int target = nums[i];
        	int tmpCnt = 0;
        	int prevIdx = -1;
        	
        	if (visited[target]) {
        		continue;
        	}
        	visited[target] = true;
        	
        	for (int j=0; j<N; j++) { // => 1000 => 1,000,000
        		if (nums[j] == target) continue;
        		
        		if (prevIdx == -1) {
        			tmpCnt = 1;
        		} else {
        			if (nums[prevIdx] == nums[j]) {
        				tmpCnt++;
        			} else {
        				tmpCnt = 1;
        			}
        			answer = Math.max(answer, tmpCnt);
        		}
        		
        		prevIdx = j;
        	}
        }
        
        System.out.print(answer);
        
    }
    
};


