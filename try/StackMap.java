import java.util.*;

/**
 * StackMap 遍历输出所有可能出栈序列
 */
public class StackMap {
    static List<List<Integer>> all = new ArrayList<>();
    static Stack<Integer> stack = new Stack<>();

    /**
     * input:数组 output:List<List<Integer>>
     */
    static List<List<Integer>> stackmap(int[] seq) {
        iterator(seq, 0, new ArrayList<>());
        return all;
    }

    static void iterator(int[] seq, int pointer, List<Integer> result) {
        if (pointer == seq.length && stack.isEmpty()) {
            all.add(new ArrayList<>(result));
            return;
        }
        if (!stack.isEmpty()) {
            // 出栈
            int pop = stack.pop();
            result.add(pop);
            iterator(seq, pointer, result);
            // 恢复
            result.remove(Integer.valueOf(pop));
            stack.push(pop);
        }
        if (pointer < seq.length) {
            // 入栈
            stack.push(seq[pointer]);
            iterator(seq, pointer + 1, result);
            // 恢复
            stack.pop();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] array;
        int n;
        n = in.nextInt();
        array = new int[n];
        for(int cnt = 0;cnt < n;cnt++){
            array[cnt] = in.nextInt();
        }
        System.out.println(stackmap(array));
    }

}