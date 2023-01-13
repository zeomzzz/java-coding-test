import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int M = sc.nextInt();
		int alarmH, alarmM;
		
		if(M >= 45) {
			alarmH = H;
			alarmM = M - 45;
		} else {
			alarmH = H - 1;
			if(alarmH < 0) {
				alarmH = 23;
			}
			alarmM = M + 60 - 45;
		}
		
		System.out.print(alarmH);
		System.out.print(" ");
		System.out.print(alarmM);

	}
}
