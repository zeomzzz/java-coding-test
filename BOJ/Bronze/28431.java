import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	List<String> lst = new LinkedList<>();
    	
    	for (int i=0; i<5; i++) {
    		String n = br.readLine();
    		if (lst.contains(n) == false) {
    			lst.add(n);
    		} else {
    			lst.remove(n);
    		}
    	}
    	System.out.print(lst.get(0));
    }    
};
