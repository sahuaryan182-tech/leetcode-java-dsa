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
    public ListNode oddEvenList(ListNode head) {
        //Edge cases
        if(head == null || head.next == null) return head;
        ListNode odd = head;
        ListNode even = head.next;

        //rember the frist even node , after connectiong odd nodes to even nodes
        ListNode evenHead = even;
        while(even != null && even.next != null){
            
            
            //connect the odd node or only od linkes
            odd.next = odd.next.next;

            //connect the even node or only odd linkes
            even.next = even.next.next;

            //move the pointers -> we already connect odd/even nodes likens 
            odd = odd.next;
            even = even.next; 

        }
        //attech/conneted the even nodes after odd nodes , (odd nodes comes frist)
        odd.next = evenHead;

        //return the head of LL (frist node is odd - 1(index))
        return head;

    }
}