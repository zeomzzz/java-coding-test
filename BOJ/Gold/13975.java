import java.util.PriorityQueue;
import java.util.Scanner;


public class Main { //13975
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc=0; tc<T; tc++) {

            int K = sc.nextInt(); // 소설 장의 수

            // pq에 넣기. 오름차순으로
            PriorityQueue<Long> pq = new PriorityQueue<>();
            for (int i=0; i<K; i++) { pq.add(sc.nextLong()); }

            long answer = 0;
            while (pq.size() != 1) {

                long a = pq.poll();
                long b = pq.poll();

                answer += a + b;
                pq.add(a + b);
            }

            System.out.println(answer);

        } // tc
    }
}
