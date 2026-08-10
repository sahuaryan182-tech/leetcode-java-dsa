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
    public ListNode rotateRight(ListNode head, int k) {
        //edge case:
        // If linked list is empty or has only one node,
        // rotation will not change anything.
        if(head == null || head.next == null) return head;
        //intially we need length
        int len = 1;
        ListNode tail = head;
        //traverse -> make sure reach the tail not beyond the tail -> compute the length
        while(tail.next != null){
            len++; //increase length by 1
            //move the tail
            tail = tail.next;
        }
        //edge case : k is mutiply or equal to length of Linked List
        //ex :if k is same k =5 and len = 5 so rotaion linked list is same as orignal linked list
        //ex: if k is mutiply k = 15 , len = 5 , 15 % 5 reminder -> 0 whole number is divisible
        //ex: k = 14 , len = 5, k = 5+5+4 -> 5+5 =10 same head and we do rotate Linked List for samll number in blow code, 14 % 5 = reminder -> 4
        if(( k % len) == 0){
            return head;
        }
        // k is smaller or not mutiply by length -> we need compute or calculate k
        k = k % len;
        //tail point ot tail
        tail.next = head;

        //locate the new last node , which last node point to the null ->find nth node
        ListNode lastNode = findNthNode(head, len - k);

        //before lastnode point to null update the head
        //update the head, new lastNode .next/new-head in rotate Linked list
        head = lastNode.next;

        //new last node point ot null break/change the link
        lastNode.next = null;

        //above befor lastNode poin to null , we also update the new-head of rotated Linked list
        return head;
    }
    //write a function to compute which is actuall lastnode who point to null
    private static ListNode findNthNode(ListNode temp , int n){
        //we already standing at node 
        //so we need to move n - 1 times. 
        for(int i = 1; i<n; i++){
            //move the temp
            temp = temp.next;
        }
        return temp;
       
    }
}