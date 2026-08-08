/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        //edge case if head has only one element or empty LL so return null, becase we need to remove the given n node
        if(head.next == null) return null;
        
        //fast move frist till nth+1 node to create a gap  
        for(int i = 0; i<n; i++){
            //move fast
            fast = fast.next;
        }

        //if n is equal to length of linked list that  means delete the head
        if(fast == null) return head.next;

        //take slow and fast move tother by 1 , till fast reaches last node
        ListNode slow = head;
        while(fast.next != null){
            //move both pointer
            slow = slow.next;
            fast = fast.next;
        }
        //delete the given Nth node
        slow.next = slow.next.next;

        //return the head
        return head;

    }
}