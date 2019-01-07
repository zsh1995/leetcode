import java.util.Arrays;


/**
 * QuickUnionUF
 */
public class QuickUnionUF implements UnionFind{

    int[] parents;

    // 每个节点下的子元素个数
    int[] powers;

    int N;

    int size;

    public QuickUnionUF(int N) {
        this.N = N;
        parents = new int[N + 1];
        powers = new int[N + 1];
        Arrays.fill(powers, 1);
        for(int i = 0; i < N;i++) {
            parents[i] = i;
        }
    }

    public int find(int index) {
        int p = parents[index];
        if(index == p) return p;
        return find(p);
    }



    public int union(int node1, int node2) {
        int p1 = find(node1);
        int p2 = find(node2);
        int power1 = powers[p1];
        int power2 = powers[p2];
        int root = power1 > power2 ? p1 : p2;
        powers[root] = power1 + power2;
        parents[p1] = root;
        parents[p2] = root;
        size--;
        return root;
    }
    
}