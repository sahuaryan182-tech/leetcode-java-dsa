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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        if(root.val == key){
            return helper(root);
        }
        TreeNode dummy = root;
        while(root != null){
            if(root.val > key){ //need to go left for smaller value
                if(root.left != null && root.left.val == key){
                    root.left = helper(root.left);
                    break;
                }
                else{
                    root = root.left;
                }
            }
            else{ // if(root.val < key){ need to go right for larger value
                if(root.right != null && root.right.val == key){
                    root.right = helper(root.right);
                    break;
                }
                else{
                    root = root.right;
                }
            }
        }
        return dummy;
    }
    private TreeNode helper(TreeNode root){
        if(root.left == null){
            return root.right;
        }
        else if(root.right == null){
            return root.left;
        }
        else{
            TreeNode RightChild = root.right;
            TreeNode LastRightOFSubLeft = FindLastRight(root.left);
            LastRightOFSubLeft.right = RightChild;
            return root.left;
        }

    }
    private TreeNode FindLastRight(TreeNode root){
        if(root.right  == null) return root;
        return FindLastRight(root.right);
        
    }
}