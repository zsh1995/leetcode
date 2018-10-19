
/**
 * TrieTree
 */
public interface StringST<T> {

    void put(String key, T value);

    T get(String key);

    void delete(String key);


    Iterable<String> keysWithPrefix(String prefix);

    Iterable<String> keysThatMatch(String pattern);

    String longestPrefixOf(String s);

    int size();

    Iterable<String> keys();

    default boolean contains(String key) {
        return get(key) != null;
    }

    default boolean isEmpty() {
        return size() != 0;
    }

}