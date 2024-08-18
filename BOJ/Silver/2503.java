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

// 240428
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, ans;
	static boolean[] isProper;
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    	StringTokenizer st = new StringTokenizer(br.readLine());
    	StringTokenizer st;
    	
    	N = Integer.parseInt(br.readLine());
    	
    	// 111 ~ 999 에서 불가능한 것을 지우기
    	isProper = new boolean[1000];
    	Arrays.fill(isProper, true);
    	
    	// 서로 다른 숫자 세 개로 구성되지 않은 숫자 + 0이 포함되는 숫자 제거
    	for (int i=111; i<=999; i++) {
    		String str = Integer.toString(i);
    		char c0 = str.charAt(0);
    		char c1 = str.charAt(1);
    		char c2 = str.charAt(2);
    		
    		if (c0 != '0' && c1 != '0' && c2 != '0' && c0 != c1 && c1 != c2 && c2 != c0) {
    			continue;
    		}
    		isProper[i] = false;
    	}
    	
    	int trial, strikeCnt, ballCnt;
    	for (int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine());
    		trial = Integer.parseInt(st.nextToken());
    		strikeCnt = Integer.parseInt(st.nextToken());
    		ballCnt = Integer.parseInt(st.nextToken());
    		
    		for (int j=111; j<=999; j++) {
    			if (strikeCnt == getStrikeCnt(trial, j) && ballCnt == getBallCnt(trial, j)) {
    				continue;
    			}
    			isProper[j] = false;
    		}
    	}
    	
    	ans = 0;
    	for (int i=111; i<=999; i++) {
    		if(isProper[i]) ans++;
    	}
    	
    	System.out.print(ans);
    }
    
    static int getStrikeCnt(int trial, int ans) {
    	int result = 0;
    	String trialStr = Integer.toString(trial);
    	String ansStr = Integer.toString(ans);
    	
    	for (int i=0; i<3; i++) {
    		if (trialStr.charAt(i) == ansStr.charAt(i)) result++;
    	}
    	
    	return result;
    }
    
    static int getBallCnt(int trial, int ans) {
    	int result = 0;
    	String trialStr = Integer.toString(trial);
    	String ansStr = Integer.toString(ans);
    	
    	for (int i=0; i<3; i++) {
    		for (int j=0; j<3; j++) {
    			if (trialStr.charAt(i) == ansStr.charAt(j) && i!=j) result++;
    		}
    	}
    	
    	return result;
    }
    
};

// 240818
// 정답 아닌 것 다 true로 바꾸기
// 최대 1,000 * 100
import java.util.*;
import java.io.*;

class Main {
	
	static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    	
        N = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        int guess = 0;
        int strike = 0;
        int ball = 0;
        
        for (int i=1; i<10; i++) {
        	for (int j=1; j<10; j++) {
        		for (int k=1; k<10; k++) {
        			if (i != j && j != k && i != k) {
        				q.offer(i*100 + j*10 + k);
        			}
        		}
        	}
        }
        
        int target = 0;
        int l = 0;
        for (int tc=0; tc<N; tc++) {
        	st = new StringTokenizer(br.readLine());
        	guess = Integer.parseInt(st.nextToken());
        	strike = Integer.parseInt(st.nextToken());
        	ball = Integer.parseInt(st.nextToken());
        	
        	l = q.size();
        	for (int i=0; i<l; i++) {
        		if (q.size() == 0) break;
        		
        		target = q.poll();
        		if (checkIsPossible(target, guess, strike, ball)) {
        			q.offer(target);
        		}
        	}
        }
        
        System.out.print(q.size());
        
    }
    
    static boolean checkIsPossible(int n1, int n2, int strike, int ball) {
    	
    	String s1 = Integer.toString(n1);
    	String s2 = Integer.toString(n2);
    	int tmpStrike = 0;
    	int tmpBall = 0;
    	
    	for (int i=0; i<3; i++) {
    		for (int j=0; j<3; j++) {
    			if (s1.charAt(i) == s2.charAt(j)) {
    				if (i == j) {
    					tmpStrike++;
    				} else {
    					tmpBall++;
    				}
    			}
    		}
    	}
    	
    	if (strike == tmpStrike && ball == tmpBall) {
    		return true;
    	}
    	return false;
    } 

};
