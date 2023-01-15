import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[42];
		for(int i = 0; i < 42; i++) {
			arr[i] = 0;
		}
		
		for(int j = 0; j < 10; j++) {
			int n = sc.nextInt() % 42;
			arr[n]++;
		}
		
		int cnt = 0;
		for(int k = 0; k < 42; k++) {
			if(arr[k] != 0) {
				cnt++;
			}
		}
		
		System.out.println(cnt);		
		
	} // main
}
