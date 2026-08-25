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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //craete a dummy node , to build answare
        ListNode dummy = new ListNode(-1);
        //crate temp/currant node point to dummy and move next to build final ans
        ListNode current = dummy;

        //traverse until both reaches null
        while(list1 != null && list2 != null){
            //now cheak the data of list1 and list2
            if(list1.val <= list2.val){
                //current/temp pointer point to the sorting data to build ans
                current.next = list1;
                //move list1 pointer to another compare
                list1 = list1.next;
            }
            else{
                //move current/temp to the list2 for lower data/value in order to return short value
                current.next = list2;
                list2 = list2.next;
            }
            //move the current in order to build final ans
            current = current.next;
        }
        //attach whichever list is leftover node
        current.next = (list1 != null) ? list1 : list2;


        //dummy node is not part of ans
        return dummy.next;
    }
}