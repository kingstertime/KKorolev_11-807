import java.util.Scanner;

public class homework3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int local = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 1; i < (n - 1); i++) {
            if ((arr[i] > arr[i+1]) || arr[i] > arr[i-1]) {
                local++;
            }
        }
        System.out.println(local);
    }
}
