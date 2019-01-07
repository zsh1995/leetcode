import java.text.MessageFormat;
import java.util.Scanner;

/**
 * UFTester
 */
public class UFTester {

    public static void main(String[] args) throws Exception{
        Class<?> ufc = Class.forName(args[0], true, ClassLoader.getSystemClassLoader());
        // read from the file
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int W = sc.nextInt();
        sc.nextLine();
        UnionFind uf = (UnionFind)ufc.getDeclaredConstructor(Integer.TYPE).newInstance(N);
        long start = System.nanoTime();
        for(int i = 0;i < M;i++) {
            String[] ps = sc.nextLine().split("\\s");
            int p1 = Integer.valueOf(ps[0]);
            int p2 = Integer.valueOf(ps[1]);
            uf.union(p1, p2);
        }
        for(int i = 0;i < W;i++) {
            String[] ps = sc.nextLine().split("\\s");
            int p1 = Integer.valueOf(ps[0]);
            int p2 = Integer.valueOf(ps[1]);
            boolean result = Boolean.valueOf(ps[2]);
            if((uf.find(p1) == uf.find(p2)) != result ) {
                System.out.println(MessageFormat.format("erro:p1 = {0},p2 = {1}, result = {2} ",
                 p1, p2, result));
            } 
        }  
        // ---
        long elapsed = System.nanoTime() - start;
        sc.close();
        System.out.println("used " + elapsed + "ns");

    }
}