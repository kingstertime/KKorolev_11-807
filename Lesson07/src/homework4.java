import java.util.Scanner;

public class homework4 {
    public static String splittingup(int n) {
        if (n < 10) {
            return n + ""; // либо делать через sout(n) + return "" { возвращаем пустую строчку }
        } else {
            return splittingup(n / 10) + " " + n % 10;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(splittingup(n));
    }
}
