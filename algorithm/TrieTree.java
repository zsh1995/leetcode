import java.util.ArrayList;
import java.util.List;

/**
 * TrieTree
 */
public class TrieTree<T> implements StringST<T> {

    // 字母表个数
    private static int R = 256;

    private static class Node<T> {
        T value;
        Node<T>[] next;

        Node() {
            next = (Node<T>[]) new Node[R];
        }
    }

    public TrieTree() {
        root = new Node<T>();
    }

    private Node<T> root;

    public void put(String key, T value) {
        put(key, "", value, root, 0);
    }

    void put(String key, String pre, T value, Node crt, int d) {

        if (d == key.length() && key.equals(pre)) {
            crt.value = value;
            return;
        }

        char next = key.charAt(d);

        if (crt.next[next] == null) {
            crt.next[next] = new Node<T>();
        }
        put(key, pre + next, value, crt.next[next], d + 1);

    }

    public T get(String key) {
        return get(key, root, 0).value;
    }

    Node<T> get(String key, Node<T> crt, int d) {
        if (crt == null)
            return null;
        if (d == key.length()) {
            return crt;
        }
        char next = key.charAt(d);
        return get(key, crt.next[next], d + 1);

    }

    public void delete(String key) {

    }

    public Iterable<String> keysWithPrefix(String prefix) {
        List<String> strlist = new ArrayList<>();
        Node<T> prefixNode = get(prefix, root, 0);
        dfsPrefix(prefix, prefixNode, strlist);
        return strlist;
    }

    void dfsPrefix(String pre, Node<T> crt, List<String> all) {

        if (crt.value != null)
            all.add(pre);

        for (int i = 0; i < R; i++) {
            if (crt.next[i] != null)
                dfsPrefix(pre + Character.valueOf((char) i), crt.next[i], all);
        }

    }

    public Iterable<String> keysThatMatch(String pattern) {
        List<String> strlist = new ArrayList<>();
        dfsMatch(pattern, "", root, strlist, 0);
        return strlist;
    }

    void dfsMatch(String pattern, String pre, Node<T> crt, List<String> all, int d) {

        if (d >= pattern.length() && crt.value != null) {
            all.add(pre);
            return;
        }

        char next = pattern.charAt(d);

        for (int i = 0; i < R; i++) {
            if(crt.next[i] == null) continue;
            if (next == '.' || next == (char) i)
                dfsMatch(pattern, pre + Character.valueOf((char) i), crt.next[i], all, d + 1);
        }

    }

    public String longestPrefixOf(String s) {
        return "";
    }

    public int size() {
        return 0;
    }

    public Iterable<String> keys() {
        return null;
    }

    public static void main(String[] args) {
        StringST<Integer> st = new TrieTree<Integer>();
        st.put("she", 1);
        st.put("shell", 1);
        st.put("shall", 1);
        st.put("zsh", 1);
        st.put("zkn", 1);
        st.put("zf", 1);
        st.put("zch", 1);
        for (String str : st.keysWithPrefix("she")) {
            System.out.println(str);
        }
        for (String str : st.keysThatMatch("z.")) {
            System.out.println(str);
        }
    }
}