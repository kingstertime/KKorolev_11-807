import java.util.Scanner;

public class homework4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int[][] matrix = new int[n][a];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int z = 0;
        int y;
        int x;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < a; j++) {
                x = 2;
                y = 0;
                while (n != x) {
                    if (matrix[i][j] > matrix[0 + y][j] & matrix[i][j] < matrix[i][0 + y]) {
                        z = matrix[i][j];
                    } else {
                        a = 0;
                    }
                    y++;
                    x++;
                }
                System.out.println(z);
            }
        }
    }
}