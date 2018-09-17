import java.util.Scanner;

public class homework3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        StringBuffer strResult = new StringBuffer(s);
        strResult.delete(n1,n2 + 1);
        System.out.println(strResult);
    }
}
