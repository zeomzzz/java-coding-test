import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	for (int tc=1; tc<=10; tc++) {
    		int dump = Integer.parseInt(br.readLine());
    		int[] boxes = new int[100];
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		for (int i=0; i<100; i++) {
    			boxes[i] = Integer.parseInt(st.nextToken());
    		}
    		
    		int minIdx = 0;
    		int min = boxes[minIdx];
    		int maxIdx = 0;
    		int max = boxes[maxIdx];
    		
    		for (int i=0; i<dump; i++) {
    			
    			min = boxes[minIdx];
    			max = boxes[maxIdx];
    			
    			for (int j=0; j<100; j++) {
    				if (boxes[j] < min) {
    					min = boxes[j];
    					minIdx = j;
    				}
    				
    				if (boxes[j] > max) {
    					max = boxes[j];
    					maxIdx = j;
    				}
    			}
    			
    			// 평탄화
    			boxes[minIdx]++;
    			boxes[maxIdx]--;
    		}
    		
    		min = boxes[minIdx];
    		max = boxes[maxIdx];
    		
    		for (int i=0; i<100; i++) {
    			if (boxes[i] < min) {
    				min = boxes[i];
    			}
    			
    			if (boxes[i] > max) {
    				max = boxes[i];
    			}
    		}
    		
    		System.out.printf("#%d %d\n", tc, (max-min));
    		
    	}
    }
}
