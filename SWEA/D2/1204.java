import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int T = Integer.parseInt(st.nextToken());
    	for (int t=1; t<=T; t++) {
    		st = new StringTokenizer(br.readLine());
    		int tc = Integer.parseInt(st.nextToken());
    		
    		int[] scores = new int[101];
    		st = new StringTokenizer(br.readLine());
    		for (int i=0; i<1000; i++) {
    			int score = Integer.parseInt(st.nextToken());
    			scores[score]++;
    		}
    		
    		// 최빈값 찾기
    		int mode = 0;
    		int modeCnt = scores[0];
    		for (int i=1; i<=100; i++) {
    			if (scores[i] >= modeCnt) {
    				mode = i;
    				modeCnt = scores[i];
    			}
    		}
    		
    		System.out.printf("#%d %d\n", tc, mode);
    	}
    	
    }

}
