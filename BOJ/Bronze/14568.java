import java.io.*;

// N <= 100 이므로 100*100*100 < 1억 -> 1초에 가능
public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	
    	int cnt = 0;
    	
    	for (int i=0; i<=N; i++) { // 택희
    		for (int j=0; j<=N; j++) { // 영훈
    			for (int k=0; k<=N; k++) { // 남규
    				if (i+j+k == N && k-j >= 2 && i*j*k != 0 && i%2 == 0) {
    					cnt++;
    				}
    			}
    		}
    	}
    	
    	System.out.println(cnt);
    	
    }

}
