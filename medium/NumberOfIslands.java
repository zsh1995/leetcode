/**
 * NumberOfIslands
 */
public class NumberOfIslands {

    int id[];
    int childs[];
    char[][] grid;
    int count = 0;
    int M;
    int N;

    public int numIslands(char[][] grid) {
        M = grid.length;
        if (M == 0)
            return 0;
        N = grid[0].length;
        this.grid = grid;
        id = new int[M * N];
        childs = new int[M * N];
        for (int i = 0; i < M * N; i++) {
            if (grid[i / N][i % M] == '1') {
                id[i] = i;
                childs[i] = 1;
                count++;
            } else {
                id[i] = -1;
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == '0')
                    continue;
                if (isLeagal(i - 1, j)) {
                    union((i - 1) * N + j, i * N + j);
                }
                if (isLeagal(i, j - 1)) {
                    union(i * N + (j - 1), i * N + j);
                }
            }
        }
        return count;
    }

    int find(int node) {
        while (node != id[node]) {
            node = id[node];
        }
        return node;
    }

    void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if (pId == qId)
            return;
        if (childs[pId] < childs[qId]) {
            id[pId] = qId;
            childs[qId] += childs[pId];
        } else {
            id[qId] = pId;
            childs[pId] += childs[qId];
        }
        count--;
    }

    boolean isLeagal(int i, int j) {
        return i >= 0 && i < M && j >= 0 && j < N && grid[i][j] == '1';
    }

}