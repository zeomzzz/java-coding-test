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

import java.io.*;
import java.util.*;

// 1. 완탐 접근
// 7중 for문

// 2. 투포인터로 푼다면?
// 9명 중에 아닌 두 명을 찾는다

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int totalHeight = 0;
    	int[] heights = new int[9];
    	
    	for (int i=0; i<9; i++) {
    		heights[i] = Integer.parseInt(br.readLine());
    		totalHeight += heights[i];
    	}
    	
    	int target = totalHeight - 100;
    	Arrays.sort(heights);
    	int start = 0;
    	int end = 8;
    	
    	while (start < end) {
    		if (heights[start] + heights[end] == target) {
    			break;
    		} else if (heights[start] + heights[end] > target) {
    			end--; // heights[end]를 정답 범위에서 제외
    		} else {
    			start++; // heights[start]를 정답 범위에서 제외
    		}
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	for (int i=0; i<9; i++) {
    		if (i != end && i != start) {
    			sb.append(heights[i] + "\n");
    		}
    	}
    	
    	System.out.print(sb);
    }    
};

// 240423
import java.io.*;
import java.util.*;

// 일곱 난쟁이의 키의 합이 100
// 9명 중 2명의 인덱스를 찾는다

public class Main {
	
	static int ans1, ans2;
	static int[] ps;
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	ps = new int[9];
    	int sum = 0;
    	
    	for (int i=0; i<9; i++) {
    		ps[i] = Integer.parseInt(br.readLine());
    		sum += ps[i];
    	}
    	Arrays.sort(ps);
    	
    	int gap = sum - 100;
    	for (int i=0; i<9; i++) {
    		for (int j=0; j<9; j++) {
    			if (ps[i] + ps[j] == gap) {
    				ans1 = i;
    				ans2 = j;
    			}
    		}
    	}
    	
    	for (int i=0; i<9; i++) {
    		if (i == ans1 || i == ans2) continue;
    		System.out.println(ps[i]);
    	}
    	
    }
    
};

// 240818
// 총 합 찾고
// 총 합 - 100 인 조합 찾기
import java.util.*;
import java.io.*;

class Main {
	
	static int[] nums;

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
       nums = new int[9];
       int sum = 0;
       for (int i=0; i<9; i++) {
    	   nums[i] = Integer.parseInt(br.readLine());
    	   sum += nums[i];
       }
       
       Arrays.sort(nums);
       
       int target = sum - 100;
       int fakeIdx01 = -1;
       int fakeIdx02 = -1;
       outer: for (int i=0; i<9; i++) {
    	   for (int j=i+1; j<9; j++) {
    		   if (nums[i] + nums[j] == target) {
    			   fakeIdx01 = i;
    			   fakeIdx02 = j;
    			   break outer;
    		   }
    	   }
       }
       
       for (int i=0; i<9; i++) {
    	   if (i != fakeIdx01 && i != fakeIdx02) {
    		   System.out.println(nums[i]);
    	   }
       } 
    }

};

// 240827
// 투포인터
import java.util.*;
import java.io.*;

class Main {
	
	static int[] heights;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        
        heights = new int[9];
        int sum = 0;
        for (int i=0; i<9; i++) {
        	heights[i] = Integer.parseInt(br.readLine());
        	sum += heights[i];
        }
        
        Arrays.sort(heights);
        
        int target = sum - 100;
        int s = 0;
        int e = 8;
        
        while (s < e) {
        	if (heights[s] + heights[e] == target) {
        		break;
        	} else if (heights[s] + heights[e] > target) {
        		e--;
        	} else {
        		s++;
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<9; i++) {
        	if (i != s && i != e) {
        		sb.append(heights[i] + "\n");
        	}
        }
        
        System.out.print(sb);
    }
   
};
