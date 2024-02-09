import java.io.*;
import java.util.*;

// 백트래킹으로 확인
// 3번부터는 정답 고를 때 앞 번호랑 같은지 확인
// 정답 고르면서 점수도 측정
public class Main {
	
	static int cnt = 0;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int[] answers = new int[10];
    	for (int i=0; i<10; i++) {
    		answers[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	int[] selected = new int[10];
    	
    	backtracking(0, 0, selected, answers);
    	
    	System.out.print(cnt);
    }
    
    static void backtracking(int cur, int score, int[] selected, int[] answers) {
    	
    	if (cur >= 6 && score <= cur-6) { // 나머지 다 맞아도 5점은 못 받는 경우 제외
    		return;
    	}
    	
    	if (cur == 10) {
    		if (score >= 5) {
    			cnt++;
    		}
    		return;
    	}
    	
    	for (int i=1; i<=5; i++) {
    		if (cur >= 2) {
    			if (selected[cur-2] == selected[cur-1] && selected[cur-1] == i) continue;
    		}
    		
    		selected[cur] = i;
    		if (answers[cur] == i) { // 정답일 때
    			backtracking(cur+1, score+1, selected, answers);
    		} else { // 오답일 때
    			backtracking(cur+1, score, selected, answers);
    		}
    	}
    }
    
};
