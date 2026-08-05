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
    public ListNode middleNode(ListNode head) {
        //edge cases : if llis empty or ll has only one ele
        if(head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode faste = head;
        while(faste != null && faste.next != null){
            slow = slow.next;
            faste = faste.next.next;
        }
        return slow;
        
    }
}