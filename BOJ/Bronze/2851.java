import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int sum = 0;
    	int ans = 0;
    	int gap = Integer.MAX_VALUE;
    	
    	for (int i=0; i<10; i++) {
    		sum += Integer.parseInt(br.readLine());
    		if (Math.abs(sum-100) <= gap) {
    			gap = Math.abs(sum-100);
    			ans = sum;
    		}
    	}
    	
    	System.out.println(ans);
    	
    }

}
