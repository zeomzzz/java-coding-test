import java.util.*;
import java.io.*;

class Main {
	
	static int N, M;
	static long[] A, B, subtractSum;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        A = new long[N+1];
        B = new long[N+1];
        subtractSum = new long[N+1];
        Set<Long> subtractSet = new HashSet<>();
        Map<Long, Long> map = new HashMap<>();
        
        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) {
        	A[i] = Long.parseLong(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) {
        	B[i] = Long.parseLong(st.nextToken());
        	subtractSum[i] = A[i] - B[i] + subtractSum[i-1];
        }
        
        long subtract = 0;
        for (int i=0; i<=N; i++) {
        	subtract = subtractSum[i];
        	map.put(subtract, map.getOrDefault(subtract, 0L) + 1);
        	subtractSet.add(subtract);
        }
        
        long answer = 0;
        for (long tmp : subtractSet) {
        	answer += map.getOrDefault(tmp, 0L) * (map.getOrDefault(tmp, 1L) - 1) / 2;
        }
        
        System.out.print(answer);
    }
    
};
