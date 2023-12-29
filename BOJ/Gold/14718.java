import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	// 1억 = 100,000,000 = Math.pow(10, 8);
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int K = Integer.parseInt(st.nextToken());
    	
    	int[][] soldiers = new int[N][3];
    	int[] powers = new int[N];
    	int[] speeds = new int[N];
    	int[] intels = new int[N];
    	for (int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine());
    		soldiers[i][0] = Integer.parseInt(st.nextToken());
    		soldiers[i][1] = Integer.parseInt(st.nextToken());
    		soldiers[i][2] = Integer.parseInt(st.nextToken());
    		powers[i] = soldiers[i][0];
    		speeds[i] = soldiers[i][1];
    		intels[i] = soldiers[i][2];
    	}
    	
    	Arrays.sort(powers);
    	Arrays.sort(speeds);
    	Arrays.sort(intels);
    	
    	int ans = Integer.MAX_VALUE;
    	for (int power : powers) {
    		if (power <= ans) {
    			for (int speed : speeds) {
    				if (power+speed <= ans) {
    					outer: for (int intel : intels) {
    						if (power+speed+intel <= ans) {
    							int cnt = 0;
    							for (int[] soldier : soldiers) {
    								if (power >= soldier[0] && speed >= soldier[1] && intel >= soldier[2]) {
    									cnt++;
    									if (cnt == K) {
    										ans = Math.min(ans, power+speed+intel);
    										break outer;
    									}
    								}
    							}
    						}
    					}
    				}
    			}
    		}
    	}
    	
    	System.out.print(ans);
    }
    
};
