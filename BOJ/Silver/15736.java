import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	long N = Long.parseLong(br.readLine());
    	
    	// 홀수 번 뒤집으면 위가 백
    	// 짝수 번 뒤집으면 위가 청
    	// -> 1~N 중 약수가 홀수 개인 수가 몇 개인지
    	// -> 1~N 중 제곱수가 몇 개인지
    	System.out.print((int) Math.pow(N, 0.5));
    }
    
};
