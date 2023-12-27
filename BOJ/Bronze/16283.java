// 76ms
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int a = Integer.parseInt(st.nextToken()); // 1 ~ 1,000
    	int b = Integer.parseInt(st.nextToken()); // 1 ~ 1,000
    	int n = Integer.parseInt(st.nextToken()); // 2 ~ 1,000
    	int w = Integer.parseInt(st.nextToken()); //  2 ~ 1,000,000
    	
    	boolean flag = false;
    	String answer = "";
    	for (int sheep=1; sheep<n; sheep++) {
    		int goat = n-sheep;
    		
    		if (sheep * a + goat * b == w) {
    			if (!flag) {
    				answer += Integer.toString(sheep) + " " + Integer.toString(goat);
        			flag = true;
    			} else {
    				flag = false;
    				break;
    			}
    		}
    	}
    	
    	if (!flag) {
    		System.out.print(-1);
    	} else {
    		System.out.print(answer);
    	}
    	
    }

}


import java.io.*;
import java.util.*;

// 완탐 풀이 (116ms)
// 1,000 * 1,000 = 1,000,000 < 1억 -> 1초 안에 가능
public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int a = Integer.parseInt(st.nextToken()); // 1 ~ 1,000
    	int b = Integer.parseInt(st.nextToken()); // 1 ~ 1,000
    	int n = Integer.parseInt(st.nextToken()); // 2 ~ 1,000
    	int w = Integer.parseInt(st.nextToken()); //  2 ~ 1,000,000
    	
    	int cnt = 0;
    	int sheepCnt = 0;
    	int goatCnt = 0;
    	for (int sheep=1; sheep<=n; sheep++) {
    		for (int goat=1; goat<=n; goat++) {
    			if (sheep + goat == n && sheep * a + goat * b == w) {
    				cnt++;
    				sheepCnt = sheep;
    				goatCnt = goat;
    			}
    		}
    	}
    	
    	if (cnt == 1) {
    		System.out.printf("%d %d", sheepCnt, goatCnt);
    	} else {
    		System.out.print(-1);
    	}
    	
    }

}
