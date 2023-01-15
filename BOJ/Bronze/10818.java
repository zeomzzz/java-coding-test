import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] NumLst = new int[N];
		
		for(int i = 0; i < N; i++) {
			NumLst[i] = sc.nextInt();
		}
		
		Arrays.sort(NumLst);
		
		System.out.println(NumLst[0] +  " " + NumLst[N - 1]);
		
	} // main
}
