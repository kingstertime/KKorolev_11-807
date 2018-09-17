import java.util.Scanner;

public class homework1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int hs = 0;
        double middleh = 0;
        int countunder = 0;

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            hs += arr[i];
        }
        middleh = hs / n;
        for (int i = 0; i < n; i++) {
            if (hs < arr[i]) {
                countunder++;
            }
        }
        System.out.println("Middle height is: " + hs);
        System.out.println("Number students above average middle height: " + countunder);
    }
}
