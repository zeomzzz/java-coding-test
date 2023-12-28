import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	
    	// 100 ~ 999 중 답이 될 수 없는 것들을 제거
    	int[] visited = new int[1000];
    	
    	StringTokenizer st;
    	for (int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine());
    		int num = Integer.parseInt(st.nextToken());
    		int strike = Integer.parseInt(st.nextToken());
    		int ball = Integer.parseInt(st.nextToken());
    		int[] mhs = new int[3];
    		mhs[0] = num / 100;
    		mhs[1] = (num / 10) % 10;
    		mhs[2] = num % 10;
    		
    		for (int j=100; j<1000; j++) {
    			int strikeCnt = 0;
    			int ballCnt = 0;
    			
    			int[] yss = new int[3];
    			yss[0] = j / 100;
        		yss[1] = (j / 10) % 10;
        		yss[2] = j % 10;
        		
        		if (yss[0] == yss[1] || yss[1] == yss[2] || yss[2] == yss[0]) {
        			visited[j] = -1;
        		}
        		if (yss[0] == 0 || yss[1] == 0 || yss[2] == 0) {
        			visited[j] = -1;
        		}
        		
        		for (int m=0; m<3; m++) {
        			for (int y=0; y<3; y++) {
        				if (mhs[m] == yss[y]) {
        					if (m == y) {
        						strikeCnt++;
        					} else {
        						ballCnt++;
        					}
        				}
        			}
        		}
        		
        		if (strikeCnt != strike || ballCnt != ball) {
        			visited[j] = -1;
        		}
    		}
    		
    	}
    	
    	int ans = 0;
    	for (int i=100; i<1000; i++) {
    		if (visited[i] == 0) {
    			ans++;
    		}
    	}
    	
    	System.out.print(ans);
    	
    }
};
