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
