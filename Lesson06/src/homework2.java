import java.util.Scanner;

public class homework2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] arr = str.toCharArray();
        String s = "";
        int space = 0;
        for (int i = 0; i < arr.length; i++) {
            if (space == 1) {
                s += arr[i];
            }
            if (space == 0 && Character.isLetter(arr[i])) {
                s += arr[i];
                space = 1;
            }
        }
        System.out.println(s);
    }
}
