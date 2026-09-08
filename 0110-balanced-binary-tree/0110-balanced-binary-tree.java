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
class Solution {
    public boolean isBalanced(TreeNode root) {
        //if node is null return true
        if(root == null) return true;

        //figure out the left & right subtree height
        int lh = GetHight(root.left);
        int rh = GetHight(root.right);

        //if their(left & right) hight abs diffrence is greator then 1 return false 
        if(Math.abs(rh - lh) > 1) return false;

        //recusivly cheaked the left subtree and the call the funtion itself
        boolean left = isBalanced(root.left);
        //recusivly chekaed the rigth subtree and call the funtion itself
        boolean right = isBalanced(root.right);

        //if any subtree is leaf node give falase either left subtree leafnode or right subtree leaftree node , means diffrence is grator then 1 , return false
        if(!left || !right) return false;

        //f above non of conditions is matched(true-> means fasle) return true
        return true;


    }
    //funtion to calculate the right & left subtree height
    private int GetHight(TreeNode root){
        if(root == null) return 0;

        int lh = GetHight(root.left);
        int rh = GetHight(root.right);

        return 1 + Math.max(lh, rh);
    }
}