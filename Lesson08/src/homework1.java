import java.util.Scanner;

public class homework1 {
    public static void main(String[] args) {
        //int[][] matrix = {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}};
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        boolean isMagic = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int diagonalSum = 0;
        for (int i = 0; i < n; i++) {
            diagonalSum += matrix[i][i];
        }
        int collateralDiagonalSum = 0;
        for (int i = 0; i < n; i++) {
            collateralDiagonalSum += matrix[i][n - i - 1];
        }
        if (diagonalSum != collateralDiagonalSum) {
            isMagic = false;
        }
        int rowSum = 0;
        for (int i = 0; i < matrix.length; i++) {
            rowSum = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                rowSum += matrix[i][j];
            }
            if (rowSum != diagonalSum) {
                isMagic = false;
            }
        }
        if (collateralDiagonalSum != diagonalSum) {
            System.out.println("NO");
        } else{
            System.out.println("YES");
        }
    }
}