import java.util.Scanner;

public class homework2 {
    public static int nsum(int n) {
        if (n < 10) {
            return n;
        } else {
            int n10 = n / 10;
            n = n % 10 + nsum(n10);
            return n;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        n = nsum(n);
        System.out.println(n);
    }
}
