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
    public ListNode reverseList(ListNode head) {
        //edge case  is ll is empty or has only one element
        if(head == null || head.next == null) return head;
        ListNode previous = null;
        ListNode temp = head;
        while(temp != null){
            //save the next node , we many time create a new node to front , that has no link to go/traversel so front inside loop , many times created 
            ListNode front = temp.next;
            temp.next = previous;
            //befor moving temp to next fornt update the previous
            previous = temp;
            temp = front;
        }
        return previous;
    }
}