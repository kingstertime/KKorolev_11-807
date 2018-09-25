import java.util.Scanner;

public class homework4 {
    static boolean identicalel (int[] a) {
        boolean identical = false;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[i] == a[j] & i != j) {
                    identical = true;
                }
            }
        }
        return identical;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(identicalel(arr));
    }
}
