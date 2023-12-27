// 7중 for문 풀이 (80ms)
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int[] hs = new int[9];
    	for (int i=0; i<9; i++) {
    		hs[i] = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
    	}
    	
    	Arrays.sort(hs);
    	
    	// 7중 for문
    	outer: for (int a=0; a<3; a++) {
    		for (int b=a+1; b<4; b++) {
    			for (int c=b+1; c<5; c++) {
    				for (int d=c+1; d<6; d++) {
    					for (int e=d+1; e<7; e++) {
    						for (int f=e+1; f<8; f++) {
    							for (int g=f+1; g<9; g++) {
    								if (hs[a]+hs[b]+hs[c]+hs[d]+hs[e]+hs[f]+hs[g] == 100) {
    									System.out.printf("%d\n%d\n%d\n%d\n%d\n%d\n%d", hs[a], hs[b], hs[c], hs[d], hs[e], hs[f], hs[g]);
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

}

// 2중 for문 풀이 : 제외할 난쟁이를 찾기 (76ms)
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int[] hs = new int[9];
    	int sum = 0;
    	for (int i=0; i<9; i++) {
    		hs[i] = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
    		sum += hs[i];
    	}
    	
    	Arrays.sort(hs);
    	
    	boolean flag = true;
    	
    	// 제외할 두 난쟁이를 찾기
    	outer: for (int i=0; i<8; i++) {
    		for (int j=i+1; j<9; j++) {
    			if (sum - (hs[i] + hs[j]) == 100) {
    				for (int idx=0; idx<9; idx++) {
    					if (idx!=i && idx!=j) {
    						System.out.println(hs[idx]);
        					flag = true;
    					}
    				}
    				if (flag) {
    					break outer;
    				}
    			}
    		}
    	}
    	
    }

}
