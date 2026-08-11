/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        //edge case
        if(head == null) return head;
        Node temp = head;
        while(temp != null){
            //create a copy of orignal node

            //create a copy node
            Node copyNode = new Node(temp.val);

            //now place a copy in between
            copyNode.next = temp.next;

            //now temp orignal(frist node -> head)  link to copy node
            temp.next = copyNode;

            //move the temp by 2 places , goes only orignal node
            temp = temp.next.next;

        }
        //step -> 2, now copy node conneted to random pointer to other copy node 
        temp = head;
        while(temp != null){
            //Access the copied node
            Node copyNode = temp.next;

            //if temp random not poin to null, or temp.random not point to null
            if(temp.random != null){
                //now copynode point to the random copy node
                copyNode.random = temp.random.next;
            }
            else{ //if temp.rendom poin to to null
                copyNode.random = null;
            }

            //move the temp ny 2 places , gose only orignal
            temp = temp.next.next;
        }
        //step 3 -> connect the next pointer to onther copy next pointer
        //for creating a new list
        
        //crate a dummy node
        Node dummyNode = new Node(-1);

        //res point to dummy node ,  for crating a ans LL
        Node res = dummyNode;

        temp = head;
        while(temp != null){
            //res poin to the copy head/copy list
            res.next = temp.next;

            //remove/reales the copynode and point to orignal node
            temp.next = temp.next.next;

            //move pointer together
            res = res.next;
            temp = temp.next;
        }
        return dummyNode.next;
    }
}