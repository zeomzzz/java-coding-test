import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        boolean[][] graph = new boolean[N+1][N+1];
        
        for (int i=0; i<M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	graph[a][b] = graph[b][a] = true;
        }
        
        int res = 0;
        for (int i=1; i<N; i++) {
        	for (int j=i+1; j<=N; j++) {
        		if (graph[i][j] == false) { // (i, j) 가능
        			for (int k=j+1; k<=N; k++) {
        				if (graph[i][k] == false && graph[j][k] == false) res++; // (i, k), (j, k)도 가능
        			}
        		}
        	}
        }
        
        System.out.println(res);
        
    }

}
