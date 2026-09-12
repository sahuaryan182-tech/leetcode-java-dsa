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
    public boolean checkTree(TreeNode root) {
        return root == null || FindEqual(root.left, root.right, root);
    }
    private boolean FindEqual(TreeNode left, TreeNode right, TreeNode root){
        int leftval = left != null ? left.val : -1;
        int rightval = right != null ? right.val : -1;
        int rootval = root.val;
        int sum = leftval + rightval;
        if(rootval == sum){ 
            return true;
        }
        return false;

    }
}