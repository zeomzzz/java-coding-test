import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] scores = new int[N];
		
		for(int i = 0; i < N; i++) {
			scores[i] = sc.nextInt();
		}
		
		Arrays.sort(scores);
		
		int M = scores[N - 1];
		
		double scoreSum = 0;
		for(int j: scores) {
			scoreSum += (double) j / M * 100;
		}
		
		double avg = scoreSum / N;
		
		System.out.printf("%f\n", avg);

	}

}
