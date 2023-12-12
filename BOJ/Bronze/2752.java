import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
        
    	int[] arr = new int[3];
    	arr[0] = Integer.parseInt(st.nextToken());
    	arr[1] = Integer.parseInt(st.nextToken());
    	arr[2] = Integer.parseInt(st.nextToken());
    	
    	Arrays.sort(arr);
        
        System.out.print(arr[0]);
        System.out.print(" ");
        System.out.print(arr[1]);
        System.out.print(" ");
        System.out.print(arr[2]);
        
    }

}
