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
			
			// 버블 정렬 내림차순 1 pass 이용하여 가장 작은 수를 찾아 0으로 바꿈(제외하기 위해)
			// 버블 정렬 내림차순 1 pass -> 가장 마지막 수가 가장 작은 수
			for(int j = 0; j < l-1; j++) {
				if(arr[j] < arr[j+1]) {
					int tmp1 = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp1;
				}
			}
			
			arr[l-1] = 0;
			
			// 버블 정렬 오름차순 1 pass 이용하여 가장 큰 수 찾아 0으로 바꿈 (제외하기 위해)
			// 버블 정렬 오름차순 1 pass -> 가장 마지막 수가 가장 큰 수
			for(int k = 0; k < l-1; k++) {
				if(arr[k] > arr[k+1]) {
					int tmp2 = arr[k];
					arr[k] = arr[k+1];
					arr[k+1] = tmp2;
				}
			}
			
			arr[l-1] = 0;
			
			
			// arr에 남은 수 이용하여 평균을 구함
			double sum = 0;
			
			for(int a : arr) {
				sum += a;
			}
			
			int avg = (int) (sum / (l-2) + 0.5); // int로 변환하면 소수점 버림됨 -> 0.5 더해줌
			
			System.out.printf("#%d %d\n", t+1, avg);
			
		} // tc
		
	}
}

// 풀이 2 : BufferedReader + 버블정렬 (231220)
import java.util.*;
import java.io.*;

// 1. 배열 만들면서 전체 합 구함
// 2. 버블정렬 1회 : 최댓값 구하기
// 3. 버블정렬 역순 1회 : 최소값 구하기
// 4. 합에서 최대, 최소 빼고 /8

class Solution {
	public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int[] arr = new int[10];
        for (int tc=1; tc<=T; tc++) {
            st = new StringTokenizer(br.readLine());
            int sum = 0; // 전체 합
            for (int i=0; i<10; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                sum += arr[i];
            }

            // 버블정렬 1회 : 최댓값
            for (int i=0; i<9; i++) {
                if (arr[i] > arr[i+1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;
                }
            }
            int max = arr[9];

            // 버블정렬 1회 : 최솟값
            for (int i=0; i<9; i++) {
                if (arr[i] < arr[i+1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;
                }
            }
            int min = arr[9];

            // 평균 구하기
            sum -= (max + min);
            int answer = (int) Math.round(sum/(double)8);

            System.out.printf("#%d %d\n", tc, answer);
        }
        
    }
}
