import java.util.Scanner;

public class homework1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String arr1 = "", arr2 = "";
        for (int i = 0; i < n; i++) {
            arr1 += sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            arr2 += sc.nextInt();
        }
        System.out.println(arr1.indexOf(arr2));

    }
}