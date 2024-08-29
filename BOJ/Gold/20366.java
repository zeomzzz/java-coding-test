import java.util.*;
import java.io.*;

// 엘자 것 두 개 선택 : 600 * 600 = 360,000
// 안나 : 투포인터

class Main {
	
	static int N;
	static int[] snows;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        snows = new int[N];
        for (int i=0; i<N; i++) {
        	snows[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(snows);
        
        int min = Integer.MAX_VALUE;
        outer: for (int i=0; i<N; i++) {
        	for (int j=i+1; j<N; j++) {
        		int s = 0;
        		int e = N-1;
        		int ellja = snows[i] + snows[j];
        		int anna = 0;
        		
        		while (s < e) {
        			
        			while (true) {
        				if (s != i && s != j) {
        					break;
        				}
        				s++;
        			}
        			
        			while (true) {
        				if (e != i && e != j) {
        					break;
        				}
        				e--;
        			}
        			
        			if (s >= e) break;
        			
        			anna = snows[s] + snows[e];
        			if (ellja == anna) {
        				min = 0;
        				break outer;
        			} else {
        				if (anna > ellja) {
        					e--;
        				} else {
        					s++;
        				}
        			}
        			
        			min = Math.min(Math.abs(ellja - anna), min);
        			
        		}
        	}
        }
        
        System.out.print(min);
        
    }
   
};
