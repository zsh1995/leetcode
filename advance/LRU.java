/**
 * LRU
 */
public class LRU {

    static class Node {
        Node pre;
        Node next;
        int key;
        int val;
        Node(int key, int v){
            this.key = key;
            val = v;
        }
        Node(){
            
        }
    }
    
    Node head = new Node();
    
    Node tail = new Node();
    
    Map<Integer, Node> map;
    
    int N;
    
    int count;
    

    public LRUCache(int capacity) {
        N = capacity;
        count = 0;
        map = new HashMap<>(N * 2);
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            return heat(map.get(key)).val;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        // 如果已满
        if(count >= N) {
            // 新数据
            if(!map.containsKey(key)) {
                // 删除最老数据
                map.remove(head.next.key);
                head.next = head.next.next;
                head.next.pre = head;
                // 插入新数据
                map.put(key, appendTail(new Node(key, value)));
            } else {
                // 更新数据
                heat(map.get(key)).val = value;
            }
        } else {
            if(map.containsKey(key)) {
                heat(map.get(key)).val = value;
            } else {
                map.put(key, appendTail(new Node(key, value)));
                count++;
            }
        }
    }
    
    private Node heat(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        appendTail(node);
        return node;
    }
    
    private Node appendTail(Node node){        
        node.next = tail;
        Node tmp = tail.pre;
        tmp.next = node;
        node.pre = tmp;
        tail.pre = node;
        return node;
    }
    
}