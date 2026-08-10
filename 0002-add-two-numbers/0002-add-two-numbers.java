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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1 = l1;
        ListNode t2 = l2;

        //create a dummy node to build ans
        ListNode dummyNode = new ListNode(-1);

        //current is used to add new node is answare
        ListNode curr = dummyNode;

        //itinally carry is 0
        int carray = 0;

        //travese untill both temp(t1, t2) is reaches to null
        while(t1 != null || t2 != null){

            //intially in sum adding carry with previous carray
            int sum = carray;

            //if t1 has node add its val/data into sum
            if(t1 != null){
                sum = sum + t1.val;
            }

            //if t2 has node add its val/data into sum
            if(t2 != null){
                sum = sum + t2.val;
            }

            //create a new node  adding a sum last digit
            //exapmle -> sum = 15 % 10 = 5
            ListNode newNode = new ListNode(sum % 10);

            //current point to the new-Node -> it is ues to build ans
            curr.next = newNode;

            //move forward curr
            curr = curr.next;

            //calucate the carry
            //exaple -> 15 / 10 = 1
            carray = sum / 10;

            // t1 list has leftover nodes
            //move t1 and t2 both temps
            //move t1 if its not null
            //we do not add only frist both nodes(where t1 and t2 stand frist) so move next
            if(t1 != null){
                t1 = t1.next;
            }
            // t2 list has leftover nodes
            //move t2 , if its is not ,  we do not want add only frist both nodes val/data so move to next
            if(t2 != null){
                t2 = t2.next;
            }
        }
        //if caary is left over and both temp reaches null add carray into new node
        if(carray != 0){
            ListNode newNode = new ListNode(carray);

            //cuerrent node point to the new-Node
            curr.next = newNode;
        } //dummy-node itself is not part of ans
        return dummyNode.next;
    }
}