import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int X = sc.nextInt();
		int Y = sc.nextInt();
		int ans;
		
		if(X > 0) {
			ans = 1;
			if(Y < 0) {
				ans = 4;
			}
		} else {
			ans = 2;
			if(Y < 0) {
				ans = 3;
			}
		}
		
		System.out.println(ans);

	}
}
