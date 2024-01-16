import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	// 나머지를 기준으로 map에 갯수를 저장
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	StringBuilder sb = new StringBuilder();
    	int T = Integer.parseInt(br.readLine());
    	
    	for (int tc=0; tc<T; tc++) {
    		st = new StringTokenizer(br.readLine());
    		long d = Long.parseLong(st.nextToken());
    		int n = Integer.parseInt(st.nextToken()); // 수열의 크기
    		int cnt = 0; // 개수
    		
    		st = new StringTokenizer(br.readLine());
    		long prev = 0;
    		Map<Long, Long> cntMap = new HashMap<>();
    		cntMap.put(0L, 1L);
    		for (int i=0; i<n; i++) {
    			long cur = prev + Long.parseLong(st.nextToken());
    			cnt += cntMap.getOrDefault(cur%d, 0L);
    			cntMap.put(cur%d, cntMap.getOrDefault(cur%d, 0L)+1);
    			prev = cur;
    		}
    		
    		sb.append(cnt + "\n");
    	}
    	
    	System.out.print(sb);
    }    
};
