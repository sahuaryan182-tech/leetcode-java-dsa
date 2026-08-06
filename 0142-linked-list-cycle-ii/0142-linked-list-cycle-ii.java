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
    public ListNode detectCycle(ListNode head) {
        //edge case: if ll is empty or ll has only one element
        if(head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){ //even or edd length - linear search - loop never exist
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){ //clliode node
                //reset slow to head
                slow = head;
            
                while(slow != fast){ //fast has colliode point , because slow now head 
                slow = slow.next; // move by 1
                fast = fast.next; //move by  1 
                }
            // fast and slow reaches same node - that node is our frist node whre loop/cycle start so return it
            return slow;
            }
        }
        return null; //for return entire node , if no loop exist return null, in linear search loop never exist so while return null, in order to return node(where cycle/loop exist ) if not exist return null 
        
    }
}