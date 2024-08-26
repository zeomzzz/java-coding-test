import java.util.*;
import java.io.*;

class Main {
	
	static int N, M;
	static int[] heights, commands;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        heights = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) {
        	heights[i] = Integer.parseInt(st.nextToken());
        }
        
        commands = new int[N+2];
        int a = 0;
        int b = 0;
        int k = 0;
        for (int i=0; i<M; i++) {
        	st = new StringTokenizer(br.readLine());
        	a = Integer.parseInt(st.nextToken());
        	b = Integer.parseInt(st.nextToken());
        	k = Integer.parseInt(st.nextToken());
        	
        	commands[a] += k;
        	commands[b+1] -= k;
        }
        
        
        
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=N; i++) {
        	commands[i] += commands[i-1];
        	heights[i] += commands[i];
        	sb.append(heights[i] + " ");
        }
        
        System.out.print(sb);
    }
   
};
