import java.util.Scanner;

/*
аннотация, как заполняется:
последовательность: заполнение контура ==> заполнение вправо внутри контура ==> заполнение вниз внутри контура ==> заполнение влево внутри контура ==> заполнение вверху внутри контура
делаем обход по всем осям, получая спирально заполнение.
 */

public class homework3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int matrix[][] = new int[m][n];
        // Заполнение контура
        int s = 1;
        for (int i = 0; i < n; i++) {
            matrix[0][i] = s;
            s++;
        }
        for (int j = 1; j < m; j++) {
            matrix[j][n-1] = s;
            s++;
        }
        for (int i = n - 2; i >= 0; i--) {
            matrix[m - 1][i] = s;
            s++;
        }
        for (int j = m - 2; j > 0; j--) {
            matrix[j][0] = s;
            s++;
        }
        int c = 1;
        int d = 1;
        while (s < m * n) {

            //1
            while (matrix[c][d + 1] ==0) {
                matrix[c][d] = s;
                s++;
                d++;
            }

            //2
            while (matrix[c + 1][d] == 0) {
                matrix[c][d] = s;
                s++;
                c++;
            }

            //3
            while  (matrix[c][d - 1] == 0) {
                matrix[c][d] = s;
                s++;
                d--;
            }

            //4
            while (matrix[c - 1][d] == 0) {
                matrix[c][d] = s;
                s++;
                c--;
            }
        }
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                if (matrix[j][i] == 0) {
                    matrix[j][i] = s;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}