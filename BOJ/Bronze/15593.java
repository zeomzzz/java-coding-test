import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	int[][] cows = new int[N][2];
    	
    	StringTokenizer st;
    	// 입력
    	for (int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine());
    		cows[i][0] = Integer.parseInt(st.nextToken());
    		cows[i][1] = Integer.parseInt(st.nextToken());
    	}
    	
    	int ans = 0;
    	// 제외할 소 선택
    	for (int i=0; i<N; i++) {
    		int[] visited = new int[1002];
    		for (int j=0; j<N; j++) {
    			if (i != j) {
    				for (int idx=cows[j][0]; idx<cows[j][1]; idx++) {
    					visited[idx] = 1;
    				}
    			}
    		}
    		
    		int cnt = 0;
    		for (int j=0; j<=1001; j++) {
    			cnt += visited[j];
    		}
    		
    		ans = Math.max(ans, cnt);
    	}
    	
    	System.out.print(ans);
    	
    }

};

// 240426
import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	N = Integer.parseInt(br.readLine());
    	Lifeguard[] lifeguards = new Lifeguard[N];
    	int[] visited = new int[1001];
    	
//    	StringTokenizer st = new StringTokenizer(br.readLine());
    	StringTokenizer st;
    	for (int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine());
    		lifeguards[i] = new Lifeguard(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    		
    		for (int j=lifeguards[i].start; j<lifeguards[i].end; j++) {
    			visited[j]++;
    		}
    	}
    	
    	// 하나 씩 제외해보기
    	int start;
    	int end;
    	int ans = 0;
    	for (int i=0; i<N; i++) {
    		start = lifeguards[i].start;
    		end = lifeguards[i].end;
    		
    		int tmp = 0;
    		for (int j=0; j<1001; j++) {
    			if (j >= start && j < end) {
    				if (visited[j] > 1) tmp++;
    			} else {
    				if (visited[j] > 0) tmp++;
    			}
    		}
    		
    		ans = Math.max(ans, tmp);
    		
    	}
    	
    	System.out.print(ans);
    	
    }
    
    static class Lifeguard {
    	int start;
    	int end;
    	
    	public Lifeguard(int start, int end) {
    		this.start = start;
    		this.end = end;
    	}
    }
    
};
