/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        //edge case: if ll is empty or ll has only one node 
        if(head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        // even length Node for linear amd odd lenght for liner seach means both not conatins loop
        while(fast != null && fast.next != null){
            slow = slow.next;  //move by 1
            fast = fast.next.next; //move by 2
            //loop exist then fast and slow reaches same NODE/Jointes never go to null beacuse they in loop
            if(slow == fast){
                return true;
            }
        }
        return false; //on linear data-stucture serach on loop so return false 
    }
}