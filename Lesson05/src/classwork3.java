import java.util.Scanner;

public class classwork3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = "yes";
        double a = 0;
        double c = 0;
        while (1 == 1) {
            a = c;
            if (s.equals("yes")) {
                a = sc.nextDouble();
            }

            c = 0;
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
            System.out.println("Reset the result?");
            String yn = sc.next();
            if (yn.equals("yes")) {
                s = "yes";

            }
            if (yn.equals("no")) {
                s = "no";
            }
        }
    }
}