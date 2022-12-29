import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int N;
		N = sc.nextInt();
        sc.close();
		
        for(int i=0; i < N; i++)
            System.out.print('#');
	}
}
