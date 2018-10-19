/**
 * InsertSortList
 */
public class InsertSortList {

    public ListNode insertionSortList(ListNode head) {
        ListNode fhead= new ListNode(Integer.MIN_VALUE);
        fhead.next = head;
        ListNode end = head;
        while(end.next != null){
            ListNode tmp = end.next;
            ListNode nextNext = tmp.next;
            end.next = null;
            for(ListNode crt = fhead; crt != null;crt = crt.next){
                if(crt.val <= tmp.val && (crt.next == null || crt.next.val >= tmp.val) ) {
                    ListNode next = crt.next;
                    crt.next = tmp;tmp.next = next;
                    break;
                }
            }
            end.next = nextNext;
        }
        return fhead.next;
    }
    
}