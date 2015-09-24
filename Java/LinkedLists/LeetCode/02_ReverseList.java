/*  DESCRIPTION:  Reverse a singly linked list.
*/

public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null; ListNode next = null;
        ListNode current = head;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }
}
