import java.util.*;
import java.io.*;

class Main {
	
	static int N, M;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        LinkedList<Integer> q = new LinkedList<>();
        for (int i=1; i<=N; i++) {
        	q.add(i);
        }

        st = new StringTokenizer(br.readLine());
        int cnt = 0;
        for (int i=0; i<M; i++) {
        	int target = Integer.parseInt(st.nextToken());
        	
        	while (true) {
        		if (q.get(0) == target) {
        			q.remove(0);
        			break;
        		}
        		
        		// 0 1 2 3 4
        		if (q.indexOf(target) <= q.size() / 2) { // 중간에 있을 때 왼쪽으로 가야 더 짧음
        			while (q.get(0) != target) {
        				// popLeft
        				q.addLast(q.removeFirst());
        				cnt++;
        			}
        		} else {
        			while (q.get(0) != target) {
        				// popRight
        				q.addFirst(q.removeLast());
        				cnt++;
        			}
        		}
        	}
        }
        
        System.out.print(cnt);
        
    }
    
};
