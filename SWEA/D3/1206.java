import java.io.*;
import java.util.*;
 
public class Solution {
 
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int tc=1; tc<=10; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] heights = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i=0; i<N; i++) {
                heights[i] = Integer.parseInt(st.nextToken());
            }
            
            int answer = 0;
            for (int i=2; i<N-2; i++) {
                int max = Math.max(heights[i-2], Math.max(heights[i-1], Math.max(heights[i+1], heights[i+2])));
                if (heights[i] > max) {
                    answer += heights[i] - max;
                }
            }
            
            System.out.printf("#%d %d\n", tc, answer);
        }
        
    }
}
