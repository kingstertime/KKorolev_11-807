import java.util.Scanner;

public class homework1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if ((n & (n - 1)) == 0 && (n > 0)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}

/*
Можно сделать через вызов функции:
public class homework1 {
    public static int exponent(double n) // ввод функции.
        if (n == 1) {
            return 1;
        } else {
            if (n > 1 && n < 2) {
                return 0;
            } else {
                return exponent(n / 2);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // выполнение тела алгоритма.
        double n = sc.nextInt();
        if (exponent(n) == 1) { // вызов функции
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
 */