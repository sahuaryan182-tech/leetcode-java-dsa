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
    private ListNode reverseLinkedList(ListNode head){
        ListNode temp = head;
        ListNode privious = null;
        while(temp != null){
            ListNode front = temp.next;
            temp.next = privious;
            privious = temp;
            temp = front;
        }
        return privious;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newhead = reverseLinkedList(slow.next);
        ListNode frist = head;
        ListNode seconed = newhead;

        while(seconed != null){

            if(frist.val != seconed.val){
                reverseLinkedList(newhead);
                return false;
            }
            //compare is match move next node 
            frist = frist.next;
            seconed = seconed.next;

        }
        reverseLinkedList(newhead);
        return true;
        
    }
}