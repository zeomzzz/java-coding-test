import java.util.Scanner;

public class Main {
    public static void main(String [] args) {

        Scanner scanner = new Scanner(System.in);

        double a, b, result;

        a = scanner.nextInt();
        b = scanner.nextInt();
        result = a / b;

        System.out.println(result);

        scanner.close();
    }
}
