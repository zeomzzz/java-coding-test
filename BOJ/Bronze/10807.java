import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] NumLst = new int[N];
		int cnt = 0;
		
		for(int i = 0; i < N; i++) {
			NumLst[i] = sc.nextInt();
		}
		
		int v = sc.nextInt();
		
		for(int j = 0; j < N; j++) {
			if(v == NumLst[j]) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
	}

}
