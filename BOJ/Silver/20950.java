import java.io.*;
import java.util.*;

public class Main {
	
	static int N, answer;
	static Color gom;
	static Color[] colors;
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	colors = new Color[N];
    	for (int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine());
    		colors[i] = new Color();
    		colors[i].red = Integer.parseInt(st.nextToken());
    		colors[i].green = Integer.parseInt(st.nextToken());
    		colors[i].blue = Integer.parseInt(st.nextToken());
    	}
    	
    	gom = new Color();
    	st = new StringTokenizer(br.readLine());
    	gom.red = Integer.parseInt(st.nextToken());
    	gom.green = Integer.parseInt(st.nextToken());
    	gom.blue = Integer.parseInt(st.nextToken());
    	
    	answer = Integer.MAX_VALUE;
    	recur(0, 0, 0, 0, 0);
    	
    	System.out.print(answer);
    }
    
    public static void recur(int cur, int red, int green, int blue, int cnt) {
    	
    	if (cur == N || cnt == 7) {
    		
    		if (cnt > 1) {
    			Color tmpColor = new Color(red/cnt, green/cnt, blue/cnt);
        		
        		compareColor(gom, tmpColor);
    		}
    		
    		return;
    	}
    	
    	// 이번 것 선택
    	recur(cur+1, red+colors[cur].red, green+colors[cur].green, blue+colors[cur].blue, cnt+1);
    	// 이번 것 선택 X
    	recur(cur+1, red, green, blue, cnt);
    }
    
    public static void compareColor(Color gom, Color tmpColor) {
    	answer = Math.min(answer, Math.abs(gom.red-tmpColor.red)+Math.abs(gom.green-tmpColor.green)+Math.abs(gom.blue-tmpColor.blue));
    }
    
    static class Color {
    	int red, green, blue;
    	
    	Color() {}
    	
    	Color(int red, int green, int blue) {
    		this.red = red;
    		this.green = green;
    		this.blue = blue;
    	}
    }
    
};
