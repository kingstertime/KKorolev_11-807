import java.util.Scanner;

public class classwork2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (1 == 1) {
            double c = 0;
            double a = sc.nextDouble();
            String op = sc.next();
            double b = sc.nextDouble();
            if (op.equals("+")) {
                c = a + b;
            }
            if (op.equals("-")) {
                c = a - b;
            }
            if (op.equals("*")) {
                c = a * b;
            }
            if (op.equals("/")) {
                c = a / b;
            }
            System.out.println(c);
        }
    }
}