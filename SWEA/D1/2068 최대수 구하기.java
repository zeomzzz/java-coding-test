import java.util.Scanner;

class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int ans = sc.nextInt();
			
			for(int i = 1; i <= 9; i++) {
				int num = sc.nextInt();
				if(ans < num) {
					ans = num;
				}
			}
			System.out.println("#" + tc + " " + ans);
		}

	}

}


// 풀이 2 : 버블정렬 활용

import java.util.Scanner;

public class Solution {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); // tc 개수
		
		for(int t = 0; t < T; t++) {
			
			int[] arr = new int[10];
			int l = arr.length;
			
			// 각 tc 입력 받음
			for(int i = 0; i < l; i++) {
				arr[i] = sc.nextInt();
			}
			
			// 버블 정렬 1 pass 이용하여 가장 큰 수를 구함
			// 버블 정렬 1 pass -> 가장 마지막 수가 가장 큰 수
			for(int j = 0; j < l-1; j++) {
				if(arr[j] > arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
			
			System.out.printf("#%d %d\n", t+1, arr[l-1]);
			
		} // tc
		
	}
}

// 풀이 3 : BufferedReader + 버블정렬
import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int[] arr = new int[10];

        for (int tc=1; tc<=t; tc++) {
            st = new StringTokenizer(br.readLine());
            // 배열 세팅
            for (int i=0; i<10; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            // 버블정렬 1회 진행하면 맨 끝에 가장 큰 수
            for (int i=0; i<9; i++) {
                if (arr[i] > arr[i+1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;
                    tmp = arr[i];
                }
            }

            System.out.printf("#%d %d\n", tc, arr[9]);
        }
        
    }
}
