import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        TreeSet<Problem> problems = new TreeSet<>();
        Map<Integer, Integer> map = new HashMap<>(); // 문제 번호와 난이도 저

        int N = Integer.parseInt(st.nextToken()); // 문제 개수
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken()); // 문제 번호
            int L = Integer.parseInt(st.nextToken()); // 난이도

            problems.add(new Problem(L, P));
            map.put(P, L);
        }

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        
        for (int i=0; i<M; i++) {
        	st = new StringTokenizer(br.readLine());
        	String cmd = st.nextToken();
        	if (cmd.equals("recommend")) {
        		int x = Integer.parseInt(st.nextToken());
        		
        		if (x == 1) {
        			sb.append(problems.first().num);
        		} else { 
        			sb.append(problems.last().num);
        		}
        		
        		sb.append("\n");
        	} else if (cmd.equals("add")) {
        		int P = Integer.parseInt(st.nextToken());
        		int L = Integer.parseInt(st.nextToken());
        		
        		problems.add(new Problem(L, P));
        		map.put(P, L);
        	} else {
        		int P = Integer.parseInt(st.nextToken());
        		problems.remove(new Problem(map.get(P), P));
        		map.remove(P);
        	}
        }
        
        System.out.print(sb);

    }

    public static class Problem implements Comparable<Problem> {
        int level;
        int num;

        public Problem(int level, int num) {
            this.level = level;
            this.num = num;
        }

        @Override
        public int compareTo(Problem o) {
        	int tmp = o.level - this.level;
            if (tmp == 0) { tmp = o.num - this.num; }
            return tmp;
        }

    }

}
