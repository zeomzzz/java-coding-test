import java.util.*;
import java.io.*;

class Main {
	
	static int N, K;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        List<Integer> lst = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        
        for (int i=1; i<=N; i++) {
        	lst.add(i);
        }
        
        int idx = K-1;
        sb.append("<");
        while (lst.size() != 0) {
        	if (lst.size() != 1) {
        		sb.append(lst.remove(idx) + ", ");
        		idx = (idx + K-1) % lst.size();
        	} else {
        		sb.append(lst.remove(idx) + ">");
        	}
        }
        
        System.out.print(sb);
    }
    
};
