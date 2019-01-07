import java.util.Arrays;

/**
 * FastFindUnionFind
 */
public class FastFindUnionFind implements UnionFind{
    
    int[] parents;

    int N;

    public FastFindUnionFind(int N) {
        this.N = N;
        parents = new int[N];
        for(int i = 0; i < N;i++) {
            parents[i] = i;
        }
    }

    public int find(int index) {
        return parents[index];
    }

    public int union(int node1, int node2) {
        int p1 = find(node1);
        int p2 = find(node2);
        if(p1 == p2) return p1;
        // parents = Arrays.stream(parents)
        //             .filter((id) -> find(id) == p2)
        //             .map((val) -> p1).toArray();
        for(int i = 0;i < parents.length;i++) {
            if(find(i) == p2) {
                parents[i] = p1;
            }
        }
        return p1;
    }

    
}