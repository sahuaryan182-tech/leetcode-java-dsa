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
    public ListNode sortList(ListNode head) {
        //edge case 
        if(head == null || head.next == null) return head;

        //find middle
        ListNode middle = findmid(head);

        //left LL start a head
        ListNode left  = head;

        //rigth LL start a middle.next
        ListNode right = middle.next;

        //break the LL
        middle.next = null;

        //function Recusivly call its self and break its list until one ele/node -> baseline, is leftover on both side and return the 
        //Recusivly sort left half
        left = sortList(left);
        //Recusivly sort rigth half
        right = sortList(right);

        //combine/merge sorted both half
        return mergeTwoLists(left, right);
    }
    //funtion to find frist middle by tortoise and hare algo -> two pointer
    private static ListNode findmid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        //to find frist middle -> odd length and even length LL
        while(fast.next != null && fast.next.next != null){
            //move pointer
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; 
    }

    //function merge two sorted linked list
    private static ListNode mergeTwoLists(ListNode list1, ListNode list2){
        //create a dummy node , help us to build ans
        ListNode dummyNode = new ListNode(-1);

        //temp ised to create the new sorted list
        ListNode temp = dummyNode;

        //travse until both list get empty
        while(list1 != null && list2 != null){
            //now compare the both list val/data
            if(list1.val<list2.val){
                //take node form list1
                temp.next = list1;

                //move list1
                list1 = list1.next;
            } 
            else{
                //take node form list2 
                temp.next = list2;

                //move list2
                list2 = list2.next;
            }
            //move temp next
            temp = temp.next;
        }
        //if list1 node/ele is leftover(bach jaye), or if list1 still has ndoe, attach them
        if(list1 != null){
            //take node form the list1
            temp.next = list1;

            //move list1 forward
            list1 = list1.next;
        } //otherwise attach remaining lsit2
        else{
            //take node form list2 
            temp.next = list2;

            //make list2 forward
            list2 = list2.next;
        }
        //return dummyNode itself is not part of answare
        return dummyNode.next;
    }
}