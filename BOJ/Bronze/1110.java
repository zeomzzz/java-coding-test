import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int newN = N;
		int cnt = 0;
		
		while(true) {
			newN = newN % 10 * 10 + (newN / 10 + newN % 10) % 10;
			cnt++;
			
			if(newN == N) {
				break;
			}
		}
		
		System.out.println(cnt);
		
	}		
}
