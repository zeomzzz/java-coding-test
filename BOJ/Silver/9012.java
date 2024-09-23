import java.io.*;
import java.util.*;

public class Main {
	
	static int T;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        T = Integer.parseInt(st.nextToken());
        String tc = "";
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for (int i=0; i<T; i++) {
        	st = new StringTokenizer(br.readLine());
        	tc = st.nextToken();
        	flag = true;
        	
        	// 길이가 홀수면 괄호 문자열 불가능
        	if (tc.length() % 2 != 0) {
        		flag = false;
        	}
        	
        	// Stack에 ( 넣고 pop
        	if (flag) {
        		Stack<Character> stack = new Stack<>();
            	for (char c : tc.toCharArray()) {
            		if (c == '(') {
            			stack.push(c);
            		} else {
            			if (!stack.empty()) {
            				stack.pop();
            			} else {
            				flag = false;
            				break;
            			}
            		}
            	}
            	
            	if (!stack.empty()) {
            		flag = false;
            	}
        	}
        	
        	if (flag) {
        		sb.append("YES\n");
        	} else {
        		sb.append("NO\n");
        	}
        }
        
        System.out.print(sb.toString());
    }
    
}
