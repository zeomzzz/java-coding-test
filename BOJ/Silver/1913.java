import java.util.Scanner;
  
public class Main {
    public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);
    	
    	int n = sc.nextInt();
    	int target = sc.nextInt(); // 위치를 찾으려는 자연수
    	
    	//n*n 짜리 2차원 배열 생성
    	int[][] arr = new int[n][n];
    	
    	int r = 0;
    	int c = 0;
    	arr[r][c] = n * n;
    	int cnt = 0;
    	
    	int[] dr = {1, 0, -1, 0};
    	int[] dc = {0, 1, 0, -1};
    	int nr;
    	int nc;
    	
    	while(true) {
    		
    		nr = r + dr[cnt%4];
    		nc = c + dc[cnt%4];
    		
    		if(0 <= nr && nr < n && 0 <= nc && nc < n && arr[nr][nc] == 0) {
    			arr[nr][nc] = arr[r][c] - 1;
    			r = nr;
    			c = nc;
    			
    			if (arr[nr][nc] == 1) break;
    			
    		} else {
    			cnt++;
    		}
    	}
    	
    	// printf 로 했을 때 메모리 초과 발생해서 StringBuilder 사용
    	StringBuilder sb = new StringBuilder();
    	
    	// 달팽이 출력
    	for(int rr=0; rr<n; rr++) {
    		sb.setLength(0);
    		for(int cc=0; cc<n; cc++) {
    			sb.append(arr[rr][cc]);
    			sb.append(' ');
    		}
    		
    		System.out.println(sb);
    	}
    	
    	// 타겟 찾기
    	outer : for(int rr=0; rr<n; rr++) {
    		for(int cc=0; cc<n; cc++) {
    			if(arr[rr][cc] == target) {
    				System.out.printf("%d %d", rr + 1, cc + 1);
    				break outer;
    			}
    		}
    	}
   
    }
}
