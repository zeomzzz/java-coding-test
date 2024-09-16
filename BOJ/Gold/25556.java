import java.util.*;
import java.io.*;

class Main {
	
	static int N;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack3 = new Stack<>();
        Stack<Integer> stack4 = new Stack<>();
        
        N = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int tmp = 0;
        boolean flag = true;
        for (int i=0; i<N; i++) {
        	tmp = Integer.parseInt(st.nextToken());
        	
        	if (stack1.empty() || stack1.peek() < tmp) {
        		stack1.push(tmp);
        	} else if (stack2.empty() || stack2.peek() < tmp) {
        		stack2.push(tmp);
        	} else if (stack3.empty() || stack3.peek() < tmp) {
        		stack3.push(tmp);
        	} else if (stack4.empty() || stack4.peek() < tmp) {
        		stack4.push(tmp);
        	} else {
        		System.out.print("NO");
        		flag = false;
        		break;
        	}
        }
        
        if (flag) {
        	System.out.print("YES");
        }
        
    }
    
};
