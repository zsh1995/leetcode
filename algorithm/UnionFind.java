/**
 * UnionFind 
 * 并查集算法接口
 */
public interface UnionFind {
    
    int find(int index);

    int union(int node1, int node2);
    
}