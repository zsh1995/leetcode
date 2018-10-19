/**
 * ReverseList2
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class ReverseList2 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode fhead = new ListNode(-1);
        fhead.next = head;
        ListNode pre = fhead, crt = head, next = head.next;
        int cnt = 1;
        while(cnt != m){
            cnt++;
            pre = pre.next;
            crt = crt.next;
        }
        ListNode start = pre;
        next = crt.next;
        crt.next = null;
        while(cnt <= n){
            ListNode tmp = next.next;
            next.next = crt;
            crt = next;
            next = tmp;
            crt++;
        }
        start.next.next = next;
        start.next = crt;
        return fhead.next;
    }

}