/**
 * CompressUF
 */
public class CompressUF extends QuickUnionUF{

    public CompressUF(int N){
        super(N);
    }
    // 路径压缩
    @Override
    public int find(int index) {
        int p = parents[index];
        if(index == p) return p;
        parents[index] = find(p);
        return parents[index];
    }
    
}