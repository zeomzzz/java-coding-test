import java.io.*;
import java.util.*;

public class Main {
	
	static int T, n, answer;
	static String cloth, type;
	static Map<String, Integer> clothes; 
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	T = Integer.parseInt(br.readLine());
    	clothes = new HashMap<>();
    	
    	StringTokenizer st;
    	for (int tc=0; tc<T; tc++) {
    		n = Integer.parseInt(br.readLine());
    		answer = 1;
    		clothes.clear();
    		
    		for (int i=0; i<n; i++) {
    			st = new StringTokenizer(br.readLine());
    			cloth = st.nextToken();
    			type = st.nextToken();
    			
    			clothes.put(type, clothes.getOrDefault(type, 0) + 1);
    		}
    		
    		for (Map.Entry<String, Integer> entry : clothes.entrySet()) {
    			answer *= entry.getValue() + 1;
    		}
    		
    		sb.append(answer-1);
    		sb.append("\n");
    		
    	}
    	
    	System.out.print(sb);
    	
    }
    
};
