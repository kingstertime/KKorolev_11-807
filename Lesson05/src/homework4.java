import java.util.Scanner;

public class homework4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println("Enter symbol-key:");
        String k = sc.next();
        if (k.equals("u") || k.equals("U")) {
            s = s.toUpperCase(); // locale locale type
        }
        if (k.equals("l") || k.equals("L")) {
            s = s.toLowerCase(); // locale locale type
        }
        System.out.println(s);
    }
}
