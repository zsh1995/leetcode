/**
 * RemoveDupFromList
 */

 
 
 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
 
public class RemoveDupFromList {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode fh = new ListNode(-1);
        ListNode f = fh;
        ListNode p = head;
        fh.next = p;
        while(p != null && p.next != null){
            if( p.val == p.next.val){
                ListNode n = p.next;
                while(n != null && n.val == p.val ){
                    n = n.next;
                }
                f.next = n;
                p = n;
            } else {
                f = p;
                p = p.next;
            }
        }
        return fh.next;
    }
    
}