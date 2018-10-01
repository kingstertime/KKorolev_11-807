import java.util.Scanner;

public class homework7 {
    public static String Palindrome(char[] s) {
        String palindrom = "NO";
        if (s.length % 2 == 0) {
            for (int i = 0; i < s.length / 2 - 1; i++) {
                if (s[i] != s[s.length - i - 1]) {
                    return "NO";
                } else {
                    palindrom = "YES";
                }
            }
        } else {
            for (int i = 0; i < (s.length - 1) / 2 - 1; i++) {
                if (s[i] != s[s.length - i - 1]) {
                    return "NO";
                } else {
                    palindrom = "YES";
                }
            }
        }
        return palindrom;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] a = s.toCharArray();
        System.out.println(Palindrome(a));
    }
}