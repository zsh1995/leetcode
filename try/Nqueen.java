import java.util.*;

/**
 * Nqueen
 */
public class Nqueen {

    int N;
    public List<List<String>> solveNQueens(int n) {
        N = n;
        int nums = core();
        System.out.println(nums);
        return holder;
    }

    int[][] status = new int[N][N];
    List<List<String>> holder = new ArrayList<>();
    public int place(int n, int[] siteArray) {       
        int count = 0;
        if (n >= N){
            List<String> list = new ArrayList<>();
            for(int cnt = 0;cnt < N;cnt++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0;j < N;j++){
                    if(j == siteArray[cnt])
                        sb.append("Q");
                    else
                        sb.append(".");
                }
                list.add(sb.toString());
            }
            holder.add(list);
            return 1;
        }
        outter: for (int i = 0; i < N; i++) {
            // 向上不存在
            for (int cnt = n - 1; cnt >= 0; cnt--)
                if (siteArray[cnt] == i)
                    continue outter;
            // 对角线不能存在
            for (int x = n - 1; x >= 0; x--) {
                if (x - n == siteArray[x] - i)
                    continue outter;
            }
            for (int x = n - 1; x >= 0; x--) {
                if (x - n == i - siteArray[x])
                    continue outter;
            }
            siteArray[n] = i;
            count +=place(n + 1, siteArray);
            siteArray[n] = -1;
        }
        return count;
        
    }

    public int core() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int[] siteArray = new int[N];
            Arrays.fill(siteArray, -1);
            siteArray[0] = i;
            cnt+=place(1, siteArray);
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(new Nqueen().solveNQueens(Integer.parseInt(args[0])));
    }

}