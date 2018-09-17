import java.util.Scanner;

public class homework2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int imax = arr[0];
        for (int i = 1; i < n; i++) {
            if (Math.abs(arr[i]) > Math.abs(imax)) {
                imax = arr[i];
            }
        }
        System.out.println("Maximum index is: " + imax);
    }
}
