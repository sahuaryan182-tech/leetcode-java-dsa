/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //here we compare and return entire Node, not just compare val/data maybe val/data is same on both linked list

        //edge case : if LL1 is empty or LL2 is empty -> means frist node is null on both linked list
        if(headA == null || headB == null) return null;

        //two pointer
        ListNode t1 = headA;
        ListNode t2 = headB;

        //traversing what if frist node is collide ponint means if headA, headB is tand on smae node
        //if not then traversing
        while(t1 != t2){

            //move ponters together
            t1 = t1.next;
            t2 = t2.next;

            //what if both (t1 and t2) has same length -> both condition true-> collied point/null 
            //while travesing what if they collied or both reaches null  together
            if(t1 == t2) return t1; //t1, t2 both stand on collide point or null

            //what if one of them(t1 or t2) not has same length , is t2 larger length
            //if t1 stand last node and raches null go to opposite LL2 head2
            if(t1 == null){
                t1 = headB;
            } //is t1 is larger
            //t2 reaches null and stand on last node go to oppoaite LL1 head1
            if(t2 == null){
                t2 = headA;
            }
        }
        //return any node (t1 or t2) because both stand on frist same node which is collied point  
        return t1;
    }
}