import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	static int[][] board;
	static int max;
	static ArrayList<Wormhole> wormHoles;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt(); // tc개수
		
		for(int tc=1; tc<=t; tc++) {
			
			int n = sc.nextInt(); // 게임판의 크기 n*n
			board = new int[n+2][n+2]; // 게임판 입력 받기
			wormHoles = new ArrayList<>(); // 웜홀 리스트
			for(int r=1; r<n+1; r++) {
				for(int c=1; c<n+1; c++) {
					board[r][c] = sc.nextInt();
					
					if(board[r][c]>=6 && board[r][c]<=10) { // 웜홀이면 웜홀 리스트에 추가
						wormHoles.add(new Wormhole(r, c, board[r][c]));
					}
				}
			}
			
			// 게임판 테두리는 5번으로 채우기
			for(int i=0; i<n+2; i++) board[0][i] = board[i][0] = board[n+1][i] = board[i][n+1] = 5;
			
			max = 0;
			for(int r=1; r<n+1; r++) {
				for(int c=1; c<n+1; c++) {
					if (board[r][c] == 0) {
						for(int d=0; d<4; d++) {
							pinball(r, c, d);
						}
					}
				}
			}
			
			System.out.printf("#%d %d\n", tc, max);
			
		} // tc 10개
	}
	
	// 핀볼겜 ㄱ
	private static void pinball(int r, int c, int d) { // 출발 좌표 r, c , 방향 d
		int score = 0; // 점수 합 score
		
		int[] dr = {-1, 1, 0, 0}; // 상, 하, 좌, 우
		int[] dc = {0, 0, -1, 1};
		
		int cr = r;
		int cc = c;
		
		while(true) {
			
			int nr = cr + dr[d]; // 다음 좌표 정해주고
			int nc = cc + dc[d];
			
			if(nr == r && nc == c) {
				max = Math.max(max,  score);
				break;
			}
			
			if(board[nr][nc] == 0) { // 다음 칸도 빈 칸이면 이동
				cr = nr;
				cc = nc;
			} else {
				// 1~5 사이에 부딪히면 이동하기는 하는디 점수 & 방향 바꿈
				if(board[nr][nc] >= 1 && board[nr][nc] <= 5) {
					cr = nr;
					cc = nc;
					score++;
					
					if(board[nr][nc] == 1) {
						int[] dist = {1, 3, 0, 2};
						d = dist[d];
					} else if(board[nr][nc] == 2) {
						int[] dist = {3, 0, 1, 2};
						d = dist[d];
					} else if(board[nr][nc] == 3) {
						int[] dist = {2, 0, 3, 1};
						d = dist[d];
					} else if(board[nr][nc] == 4) {
						int[] dist = {1, 2, 3, 0};
						d = dist[d];
					} else {
						int[] dist = {1, 0, 3, 2};
						d = dist[d];
					}
				} else if(board[nr][nc] == -1) { // 블랙홀 만나면 끝
					max = Math.max(max, score);
					break;
				} else { // 웜홀 : 웜홀리스트에서 같은 번호 웜홀 찾는데 좌표가 같으면 안돼 !
					for(Wormhole wh : wormHoles) {
						if(wh.num == board[nr][nc] && (wh.r != nr || wh.c != nc)) {
							cr = wh.r;
							cc = wh.c;
						}
					}
				}
			}
		} // while
		
	} // 핀볼겜 끝

	static class Wormhole {
		int r, c, num;
		
		Wormhole(int r, int c, int num) {
			this.r = r;
			this.c = c;
			this.num = num;
		}
		
	}
	
}
