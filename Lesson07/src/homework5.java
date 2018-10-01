import java.util.Scanner;

public class homework5 {
    public static String simplicity(int n, int i) {
        if (n < 2) {
            return "NO";
        } else if (n == 2) {
            return "YES";
        } else if (n % i == 0) {
            return "NO";
        } else if (i < n / 2) {
            return simplicity(n, i + 1);
        } else {
            return "YES";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = 2;
        System.out.println(simplicity(n, i));

    }
}