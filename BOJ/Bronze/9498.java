import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int score = sc.nextInt();
		
		String ans = "F";
		if(score >= 90) {
			ans = "A";
		} else if(score >= 80) {
			ans = "B";
		} else if(score >= 70) {
			ans = "C";
		} else if(score >= 60) {
			ans = "D";
		}
		
		System.out.println(ans);

	}
}
