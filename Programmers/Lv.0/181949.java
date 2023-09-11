import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        
        for(int i=0; i<a.length(); i++) {
            int tmp = (int) a.charAt(i);
            
            if (tmp >= (int)('a')) {
                System.out.print((char)(tmp - (int) 'a' + (int) 'A')); // 소문자 -> 대문자
            } else {
                System.out.print((char) (tmp + (int) 'a' - (int) 'A')); // 대문자 -> 소문자
            }
        }
    }
}
