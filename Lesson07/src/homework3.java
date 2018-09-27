import java.util.Scanner;

public class homework3 {
    public static int reverse(int n) {
        if (n < 10) {
            return n;
        } else {
            System.out.print(n % 10 + " "); // либо же сделать System.out.println(n % 10), тогда будет выводиться построчно.
            return reverse(n / 10);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        n = reverse(n);
        System.out.print(n); // если убрать, в конечном итоге не выводит последнее число(для заданной последовательности оно будет 1ым)
    }
}
