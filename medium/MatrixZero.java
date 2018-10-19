/**
 * MatrixZero
 */
public class MatrixZero {

    public void setZeroes(int[][] matrix) {
        int m = -1, n = -1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (m == -1) {
                        m = i;
                        n = j;
                    } else {
                        matrix[m][j] = 0;
                        matrix[i][n] = 0;
                    }
                }
            }
        }
        if (m == -1)
            return;
        for (int i = 0; i < matrix.length; i++) {
            if (i != m && matrix[i][n] == 0) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[m][j] == 0) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for(int j = 0;j < matrix[0].length;j++){
            matrix[m][j] = 0;
        }

    }

    public static void main(String[] args) {

    }

}