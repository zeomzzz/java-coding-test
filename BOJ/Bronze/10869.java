import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int add_result = a + b;
        int subtract_result = a - b;
        int multiply_result = a * b;
        int divide_result = a / b;
        int remainder_result = a % b;

        System.out.println(add_result);
        System.out.println(subtract_result);
        System.out.println(multiply_result);
        System.out.println(divide_result);
        System.out.println(remainder_result);

        scanner.close();
    }
}
