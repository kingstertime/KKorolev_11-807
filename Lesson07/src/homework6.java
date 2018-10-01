import java.util.Scanner;

public class homework6 {
    public static void decomposition(int n, int i) {
        if (n % i == 0) {
            System.out.print(i);
            decomposition(n / i, i);
        } else if (n == 0 || i >= n / 2) {
            System.out.print(n);
            return;
        } else if (n % i != 0) {
            decomposition(n, i + 1);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = 2;
        decomposition(n, i);
    }
}
