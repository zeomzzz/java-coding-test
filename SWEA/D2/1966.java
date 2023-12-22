import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int T = Integer.parseInt(br.readLine());
    	for (int tc=1; tc<=T; tc++) {
    		int N = Integer.parseInt(br.readLine());
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		PriorityQueue<Integer> pq = new PriorityQueue<>();
    		
    		for (int i=0; i<N; i++) {
    			pq.offer(Integer.parseInt(st.nextToken()));
    		}
    		
    		StringBuilder sb = new StringBuilder();
    		sb.append("#");
    		sb.append(Integer.toString(tc));
    		for (int i=0; i<N; i++) {
    			sb.append(" ");
    			sb.append(Integer.toString(pq.poll()));
    		}
    		
    		System.out.println(sb);
    	}
    }

}
