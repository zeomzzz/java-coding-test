import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	int n = Integer.parseInt(br.readLine());
    	
    	for (int tc=0; tc<n; tc++) {
    		int k = Integer.parseInt(br.readLine());
    		for (int i=0; i<k; i++) {
    			sb.append("=");
    		}
    		if (tc != n-1) sb.append("\n");
    	}
    	System.out.print(sb);
    }    
};
