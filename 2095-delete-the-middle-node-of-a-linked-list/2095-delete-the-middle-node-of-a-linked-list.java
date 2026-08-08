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
    public ListNode deleteMiddle(ListNode head) {
        //edge case
        if(head.next == null) return null;

        //take poiinters
        ListNode fast = head;
        ListNode slow = head;

        //move only fast frist , skiping slow, after move together
        fast = fast.next.next;

        //move together slow and fast
        //even length of LL and odd length of LL
        while(fast != null && fast.next != null){
            //move tother
            slow = slow.next; //move by 1 stpes
            fast = fast.next.next; //move by 2 stpes
        }
        //now we defnitily sat that we slow pont to privious node of middle
        //delete/change the linkes
        slow.next = slow.next.next;

        //return the current head of linked list
        return head;
    }
}