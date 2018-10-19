import java.io.FileInputStream;
import java.util.*;


/**
 * MSF
 */
public class MSF {

    int R = 256;

    public void sort(String[] strings) {
        sort(strings, 0, strings.length, 0);
    }

    private int charAt(String str, int site) {
        return site >= str.length() ? -1 : str.charAt(site);
    }

    private void sort(String[] strings, int lo, int hi, int d) {
        if (lo >= hi)
            return;

        int count[] = new int[R + 2];
        String aux[] = new String[R+2];

        // 统计频率
        for (int i = lo; i < hi; i++) {
            count[charAt(strings[i], d) + 2]++;
        }

        // 建立索引
        for (int i = 0; i < R + 1; i++) {
            count[i + 1] += count[i];
        }

        // 从索引拷贝
        for (int i = lo; i < hi; i++) {
            int crt = charAt(strings[i], d);
            aux[count[crt + 1]++] = strings[i];
        }

        // 回写
        for (int i = lo; i < hi; i++) {
            strings[i] = aux[i - lo];
        }

        // 递归下一位置
        for (int r = 0; r < count.length - 2;r++) {
            sort(strings, lo + count[r], lo + count[r + 1], d + 1);
        }
    }

    public static void main(String[] args) throws Exception{
        Scanner fileReader = new Scanner(new FileInputStream(args[0]));
        List<String> list = new ArrayList<>();
        while (fileReader.hasNext()) {
            list.add(fileReader.next());
        }
        String[] str = (String[]) list.toArray(new String[list.size()]);
        MSF msf = new MSF();
        msf.sort(str);
        print(str);
    }

    static void print(String[] str){
        for(String tmp : str) {
            System.out.println(tmp);
        }
    }

}