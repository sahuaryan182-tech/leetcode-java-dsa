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
    int maxi = 0;
    public int diameterOfBinaryTree(TreeNode root) {
       FindHeight(root);
       return maxi;
        
    }
    private int FindHeight(TreeNode root){
        
        if(root == null) return 0;
        int lh = FindHeight(root.left);
        int rh = FindHeight(root.right);

        //diameter passing through the currnt node
        maxi = Math.max(maxi, ( lh + rh));

        //now which diameter is largest amonog all node
        return 1 + Math.max(lh, rh);
    }
}