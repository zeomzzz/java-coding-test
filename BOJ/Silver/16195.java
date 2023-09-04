import java.io.*;
import java.util.StringTokenizer;

public class Main { // 16195

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken()); // tc 개수

        long[][] dp = new long[1001][1001]; // [n][m]
        dp[1][1] = dp[2][1] = dp[2][2] = dp[3][1] = 1;
        for (int tc=0; tc<T; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // n을 만듦
            int m = Integer.parseInt(st.nextToken()); // m개 이하로

            // 1. dp[n][m]을 구한다.
            // dp[n][m] = dp[n-1][m-1] + dp[n-2][m-1] + dp[n-3][m-1]
            for (int i=3; i <= 1000; i++) {
                for (int j=2; j<=i; j++) {
                    if (i == j) { dp[i][j] = 1;
                    } else { dp[i][j] = (dp[i-1][j-1] + dp[i-2][j-1] + dp[i-3][j-1]) % 1000000009; }
                }
            }

            // 2. dp[n][1] + ... + dp[n][m]
            long ans = 0;
            for (int i=1; i<=m; i++) { ans = (ans + dp[n][i]) % 1000000009; }

            System.out.println(ans);
        }

    }

}
