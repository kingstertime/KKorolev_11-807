import java.util.Scanner;

public class homework5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0 ; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        String s = new String();
        for (int i = 0; i < n; i++) {
            s += arr[i];
        }
        System.out.println(s);
    }
}
