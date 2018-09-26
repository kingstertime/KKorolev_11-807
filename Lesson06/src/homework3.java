import java.util.Scanner;

public class homework3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = 0;
        int amax = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                a += 1;
            } else {
                if (a > amax) {
                    amax = a;
                }
                a = 0;
            }
        }
        amax += 1;
        System.out.println(amax);
    }
}