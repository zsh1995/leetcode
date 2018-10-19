import java.util.Arrays;

/**
 * MaxHeap
 */
public class MaxHeap<T extends Comparable> {

    protected Comparable[] heapArray = new Comparable[100];

    protected int N = 0;

    private boolean less(int c1, int c2) {
        return heapArray[c1].compareTo(heapArray[c2]) < 0;
    }

    private void exch(int i, int j) {
        Comparable t = heapArray[i];
        heapArray[i] = heapArray[j];
        heapArray[j] = t;
    }

    private void swim(int k) {
        while (k > 1) {
            int father = k / 2;
            if (less(k, father)) {
                break;
            }
            exch(k, father);
            k = father;
        }

    }

    private void sink(int k) {
        while (2 * k < N) {
            int next = 2 * k;
            if (less(next, next + 1))
                next = next + 1;
            if (!less(k, next))
                break;
            exch(k, next);
            k = next;
        }
    }

    public void insert(T item) {
        N++;
        heapArray[N] = item;
        swim(N);
        
    }

    public T top() {
        return (T) heapArray[1];
    }
    public T deleteTop(){
        T result = (T) heapArray[1];
        exch(1, N--);
        sink(1);
        System.out.println(result);
        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(heapArray);
    }

    public static void main(String[] args) {
        MaxHeap<Integer> heap = new MaxHeap<>();
        heap.insert(15);
        heap.insert(13);
        heap.insert(16);
        heap.insert(12);
        heap.insert(11);
        heap.insert(10);
        heap.insert(17);
        heap.deleteTop();
        heap.deleteTop();
        heap.deleteTop();
    }

}