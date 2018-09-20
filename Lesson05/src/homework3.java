import java.util.Scanner;

public class homework3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] a = s.toCharArray();
        int lenght = a.length;
        int n = 0;
        for (int i = 0; i < lenght; i++) {
            n = n * 10 + a[i]-48;
        }
        System.out.print(n);
    }
}
