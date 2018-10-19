/**
 * IslandNum
 */
public class IslandNum {

    boolean[][] marked;
    int M, N;

    /**
     * dfs解法
     */
    public int numIslands(char[][] grid) {
        if(grid.length == 0) return 0;
        int count = 0;
        M = grid.length;
        N = grid[0].length;
        marked = new boolean[M][N];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!marked[i][j] && grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    void dfs(char[][] grid, int i, int j) {
        marked[i][j] = true;
        if (isLeagal(i - 1, j) && grid[i - 1][j] == '1') {
            dfs(grid, i - 1, j);
        }
        if (isLeagal(i + 1, j) && grid[i + 1][j] == '1') {
            dfs(grid, i + 1, j);
        }
        if (isLeagal(i, j + 1) && grid[i][j + 1] == '1') {
            dfs(grid, i, j + 1);
        }
        if (isLeagal(i, j - 1) && grid[i][j - 1] == '1') {
            dfs(grid, i, j - 1);
        }
    }

    boolean isLeagal(int i, int j) {
        return i >= 0 && i < M && j >= 0 && j < N && !marked[i][j];
    }
}
