// 풀이 1 : 버블정렬 이용
import java.io.*;
import java.util.*;
 
public class Solution {
 
    public static void main(String[] args) throws Exception {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        
        for (int tc=1; tc<=T; tc++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int[] arr = new int[w];
            st = new StringTokenizer(br.readLine());
            for (int i=0; i<w; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            int[] visited = new int[w];
            for (int i=0; i<w; i++) {
                for (int j=0; j<w-1-i; j++) {
                    if (arr[j] > arr[j+1]) {
                        int tmp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = tmp;
                        
                        visited[j]++;
                        tmp = visited[j];
                        visited[j] = visited[j+1];
                        visited[j+1] = tmp;
                    }
                }
            }
            
            // visited를 버블정렬 1회해서 최댓값 구하기
            for (int i=0; i<w-1; i++) {
                if (visited[i] > visited[i+1]) {
                    int tmp = visited[i];
                    visited[i] = visited[i+1];
                    visited[i+1] = tmp;
                }
            }
            
            int answer = visited[w-1];
            
            System.out.printf("#%d %d\n", tc, answer);
            
        }
         
    }
}

// 풀이 2 : 떨어지는 조건 이용
import java.io.*;
import java.util.*;
 
public class Solution {
 
    public static void main(String[] args) throws Exception {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int T = Integer.parseInt(st.nextToken());
        for (int tc=1; tc<=T; tc++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            
            int[] arr = new int[w];
            st = new StringTokenizer(br.readLine());
            for (int i=0; i<w; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            int answer = 0;
            for (int i=0; i<w-1; i++) {
                int fall = 0;
                for (int j=i+1; j<w; j++) {
                    if (arr[i] > arr[j]) fall++;
                }
                
                answer = Math.max(answer, fall);
            }
            
            System.out.printf("#%d %d\n", tc, answer);
        }
         
    }
}
