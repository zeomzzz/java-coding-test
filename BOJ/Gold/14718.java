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

// 240428
import java.io.*;
import java.util.*;

// 1억 = 100,000,000
// 스탯 분배 방법
// - 썡 완탐 : 1000000 ^ 3 -> 썡 완탐하면 안됨
// - 적의 능력치만 리스트에 넣고 탐색 : 100 * 100 * 100

public class Main {
	
	static int N, K;
	static int[] powers, speeds, intellis;
	static Soldier[] soldiers;
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	K = Integer.parseInt(st.nextToken());
    	powers = new int[N];
    	speeds = new int[N];
    	intellis = new int[N];
    	soldiers = new Soldier[N];
    	
    	for (int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine());
    		soldiers[i] = new Soldier(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    		powers[i] = soldiers[i].power;
    		speeds[i] = soldiers[i].speed;
    		intellis[i] = soldiers[i].intelli;
    	}
    	
    	int answer = Integer.MAX_VALUE;
    	int cnt;
    	for (int power : powers) {
    		for (int speed : speeds) {
    			for (int intelli : intellis) {
    				if (power + speed + intelli >= answer) continue;
    				
    				cnt = 0;
    				for (Soldier soldier : soldiers) {
    					if (power < soldier.power) continue;
    					if (speed < soldier.speed) continue;
    					if (intelli < soldier.intelli) continue;
    					cnt++;
    				}
    				if (cnt >= K) answer = power + speed + intelli;
    			}
    		}
    	}
    	
    	System.out.print(answer);
    	
    }
    
    static class Soldier {
    	int power;
    	int speed;
    	int intelli;
    	
    	Soldier() {}
    	
    	Soldier(int power, int speed, int intelli) {
    		this.power = power;
    		this.speed = speed;
    		this.intelli = intelli;
    	}
    }
    
};
