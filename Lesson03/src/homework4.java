import java.util.Scanner;

public class homework4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int m = n / 2; // делим массив на 2 части, как бы разбивая его по условию.
        int l = 0; // будем нашим счетчиком.
        for (int i = 1; i < m; i++) {
            if (arr[i] >= arr[i-1]) {
                l += 1;
            } else {
                l -= 1;
            }

        }
        for (int i = m + 2; i < n; i++) {
            if(arr[i-1] >= arr[i]) {
                l += 1;
            } else {
                l -= 1;
            }
        }
        if (l <= 1) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }
}
