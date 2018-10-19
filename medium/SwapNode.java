/**
 * SwapNode
 */
public class SwapNode {

    public static ListNode swapPairs(ListNode head) {
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode pioneer = fakeHead;
        ListNode first = head;
        ListNode second = head.next;
        while(second != null){
            pioneer.next = second;
            ListNode temp = second.next;
            second.next = first;
            pioneer = first;
            first = temp;
            pioneer.next = first;
            if(first == null) break;
            second = first.next;
        }
        return fakeHead.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);node.next=node1;
        ListNode node2 = new ListNode(3);node1.next = node2;
        ListNode node3 = new ListNode(4);node2.next = node3;
        System.out.println(node);
        
        System.out.println(swapPairs(node).toString());
    }

}

class ListNode {
    int val;
    ListNode next;

    @Override
    public String toString() {
        if(next != null)
            return val+","+next.toString();
        else 
            return val+"";
    }

    ListNode(int x) {
        val = x;
    }
}