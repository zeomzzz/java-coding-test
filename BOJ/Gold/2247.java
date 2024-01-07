import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	
    	int answer = 0;
    	for (int i=2; i<n; i++) {
    		answer += (n/i - 1) * i;
    		answer %= 1000000;
    	}
    	
    	System.out.println(answer);
    }
    
};
