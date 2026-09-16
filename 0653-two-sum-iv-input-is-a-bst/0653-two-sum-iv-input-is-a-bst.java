/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class BSTItrator{
    //reverse -> ture -> before(all right, then go left and then push all right)
    //reverse -> false -> next(all left, then go right and then push all left)
    private Stack<TreeNode> st = new Stack<>();
    boolean reverse = true;

    public BSTItrator(TreeNode root, boolean isReverse){
        reverse = isReverse;
        pushALL(root);
    }
    public boolean hasNext(){
        return !st.isEmpty();
    }
    public int next(){
        TreeNode temp = st.pop();
        if(reverse == false) pushALL(temp.right);
        else pushALL(temp.left);
        return temp.val;

    }
    private void pushALL(TreeNode node){
        while(node != null){
            st.push(node);
            if(reverse == true){ //for befor call , all right -> left -> all right push
                node = node.right;  
            }
            else {  //for next call
                node = node.left;
            }
        }
    }
}
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        //for next, same class diffrent object
        BSTItrator l = new BSTItrator(root, false); //frist recysion call gose to left
        //for before, same class diffrent object
        BSTItrator r = new BSTItrator(root, true);

        int i = l.next(); //for next call 
        int j = r.next();  //for, before call
        while(i<j){
            if((i+j) == k) return true;
            else if(i+j < k) i = l.next();
            else j = r.next();
        }
        return false;
        
    }
}