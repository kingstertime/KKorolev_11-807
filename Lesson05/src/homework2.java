import java.util.Scanner;

public class homework2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int lenght = s.length();
        char[] a = s.toCharArray();
        for (int i = 0; i < lenght; i++) {
            int n = a[i];
            if (n >= 48 && n <= 57) {
                a[i] = '*';
            }
        }
        s = new String(a);
        System.out.print(s);
    }
}
