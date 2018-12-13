import java.util.Scanner;

public class homework2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int matrix[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int RowSum = 0;
        int RowMax = -32768;
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (RowSum > RowMax) {
                RowMax = RowSum;
                RowSum = 0;
                k = i - 1;
            }
            for (int j = 0; j < m; j++) {
                RowSum += matrix[i][j];
            }
        }
        int ColumnSum = 0;
        int ColumnMax = -32768;
        int b = 0;
        for (int j = 0; j < m; j++) {
            if (ColumnSum > ColumnMax) {
                ColumnMax = ColumnSum;
                ColumnSum = 0;
                b = j;
            }
            for (int i = 0; i < n; i++) {
                ColumnSum += matrix[i][j];
            }
        }
        for (int j = 0; j < m; j++) {
            System.out.println(matrix[k][j]);
        }
        for (int i = 0; i < n; i++) {
            System.out.println(matrix[i][b]);
        }
    }
}