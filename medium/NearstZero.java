import java.awt.List;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * NearstZero
 */
public class NearstZero {

    int[][] matrix;
    int[][] status;
    int M;
    int N;
    int[] divX = { -1, 0, 1, 0 };
    int[] divY = { 0, -1, -0, 1 };

    public int[][] updateMatrix(int[][] matrix) {
        M = matrix.length;
        N = matrix[0].length;

        this.matrix = matrix;
        status = new int[M][N];
        boolean[][] marked = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                status[i][j] = Integer.MAX_VALUE;
            }
        }

        List<Integer> crtList = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 0) {
                    crtList.add(N * i + j);
                    status[i][j] = 0;
                }
            }
        }
        int count = 1;
        while (crtList.size() > 0) {
            List<Integer> tmp = new ArrayList<>();
            for (int site : crtList) {
                int m = site / N;
                int n = site % N;
                for(int cnt = 0;cnt < 4;cnt++){
                    int ii = m + divY[cnt];
                    int jj = n + divX[cnt];
                    if(ii < 0 || jj < 0 || ii >= M || jj >= N || matrix[ii][jj] == 0||marked[ii][jj]) continue;
                    status[ii][jj] = count;
                    tmp.add(ii * N + jj);
                    marked[ii][jj] = true;
                }
            }
            count++;
            crtList = tmp;
        }
        return status;
    }

}