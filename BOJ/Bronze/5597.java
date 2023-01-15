import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[31];
		for(int i = 0; i < 28; i++) {
			int n = sc.nextInt();
			arr[n] = 1;
		}
		
		for(int j = 1; j < 31; j++) {
			if(arr[j] != 1) {
				System.out.println(j);
			}
		}
		
	} // main
}
