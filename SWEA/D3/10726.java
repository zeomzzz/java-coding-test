import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int tc = sc.nextInt();
 
        for (int t = 1; t <= tc; t++) {
 
            int n = sc.nextInt(); // 마지막 비트 n개
            int m = sc.nextInt(); // 이진수로 바꿀 수 m
            boolean flag = true;
 
            for (int i = 0; i < n; i++) {
                if(m % 2 == 0) { // 끝이 0 이면 종료
                    flag = false;
                    break;
                } else { // 1이면(== 0이 아니면) 하나 밀고 반복문 진행 계속
                    m = m >> 1;
                }
                 
            }
 
            if (flag == true) {
                System.out.println("#" + t + " ON");
            } else {
                System.out.println("#" + t + " OFF");
            }
 
        } // tc
 
    }
}


// 비트마스킹 풀이
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt(); // TC 수
		
		for(int tc=1; tc<=TC; tc++) {
			
			int N = sc.nextInt(); // 마지막 N비트
			int M = sc.nextInt(); // M의 이진수 표현
			
			// 마지막 M개 가져오기
			int chk = (1 << N) - 1;
			if((chk & M) == chk) {
				System.out.printf("#%d ON\n", tc);
			} else {
				System.out.printf("#%d OFF\n", tc);
			}
			
		} // tc
		
	}

}
