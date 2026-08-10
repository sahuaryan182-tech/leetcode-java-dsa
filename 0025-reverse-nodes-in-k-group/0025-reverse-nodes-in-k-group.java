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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode previous = null;
        while( temp != null){
            ListNode KthNode= findKthNode(temp, k);
            //edge case : kth node is not in exist LL length is smaller then k
            //for shoter/smaller linked list
            if(KthNode == null){
                
                //for larger Linked List
                if(previous != null){
                     //now we connect the remaining element whose length is lesser then k
                    previous.next = temp;
                }
                break;
            }
            //rember the kth next node  to link
            ListNode nextNode = KthNode.next;

            //break the kth node link
            KthNode.next = null;

            //call the function to revers the LL
            reverseLL(temp);

            //Identify the reverse is frist gruop or latter grop
            if(temp == head){
                //update the head with new revse head which is KthNode
                head = KthNode;
            }
            else{ //temp is not head means -> not frist group
                //we connect the previous node to Kthnode
                previous.next = KthNode;
            }
            //remember the previous
            previous = temp;

            //move the temp to nextnode
            temp = nextNode;

        } //here head point to the Kth node which reverse LL new-head
        return head;
    }
    //function to compute the Kth node
    private static ListNode findKthNode(ListNode temp , int k){
        k = k-1;
        while(  temp != null && k>0){
            k--;
            //move themp
            temp = temp.next;
        }
        return temp;
    }
 
    //function to compute the Reverse Linked List , here we give the Linked List which alredy temp as new-head and kth-Node point ot null
    private static ListNode reverseLL(ListNode head){
        ListNode previous = null;
        ListNode temp = head;
        while(temp != null){
            //store next node befor break link
            ListNode nextNode = temp.next;

            //temp point to previous
            temp.next = previous;

            //befor temp gose update the previous
            previous = temp;

            //temp gose next node
            temp = nextNode;

        }
        return previous;
    }
}