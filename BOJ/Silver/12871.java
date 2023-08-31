import java.io.*;
import java.util.StringTokenizer;

public class Main { //12871
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        int sl = s.length();

        st = new StringTokenizer(br.readLine());
        String t = st.nextToken();
        int tl = t.length();

        int n = sl * tl;

        int answer = 1;
        for (int i=0; i<n; i++) {
            if (s.charAt(i % sl) != t.charAt(i % tl)) {
                answer = 0;
                break;
            }
        }

        System.out.println(answer);

    }
}
