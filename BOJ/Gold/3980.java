import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int max;
	static int[][] players;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int C = Integer.parseInt(st.nextToken()); // tc 수
		for(int tc=0; tc<C; tc++) {
			
			players = new int[11][11];
			for (int r=0; r<11; r++) {
				StringTokenizer tmp = new StringTokenizer(br.readLine());
				for (int c=0; c<11; c++) {
					players[r][c] = Integer.parseInt(tmp.nextToken());
				}
			}
			
			int[] tactics = new int[11]; // idx : 포지션, r : 능력치
			
			max = 0;
			backtracking(0, 0, tactics);
			
			System.out.println(max);
			
		} // tc
		
	}
	
	public static void backtracking(int depth, int sum, int[] tactics) {
		
		// base case
		if (depth == 11) {
			if (sum > max) {
				max = sum;
			}
			return;
		}
		
		// recursive
		for (int pos=0; pos<11; pos++) {
			if(players[depth][pos] != 0 && tactics[pos] == 0) { // depth번째 선수의 pos 능력치가 0이 아니고 아직 전술상 pos에 배치한 선수가 없으면  
				sum += players[depth][pos]; // 능력치 합에 추가
				tactics[pos] = players[depth][pos]; // 전술에 추가
				
				backtracking(depth+1, sum, tactics); // backtacking 고고
				
				sum -= players[depth][pos]; // 원복
				tactics[pos] = 0;
			}
		}
		
	}

}
