import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int X = sc.nextInt();
		
		int[] NumLst = new int[N];
		for(int i = 0; i < N; i++) {
			NumLst[i] = sc.nextInt();
		}
		
		for(int n : NumLst) {
			if(n < X) {
				System.out.print(n + " ");
			}
		}
		
	}
}
