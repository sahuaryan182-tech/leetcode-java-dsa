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
    public TreeNode bstFromPreorder(int[] preorder) {
        return BstFromPreorder(preorder, Integer.MAX_VALUE, new int[]{0});
    }
    private TreeNode BstFromPreorder(int[] preorder, int bound, int[] idx){
        if(idx[0] == preorder.length || preorder[idx[0]] > bound) return null;
        TreeNode root = new TreeNode(preorder[idx[0]++]);
        root.left = BstFromPreorder(preorder, root.val, idx);
        root.right = BstFromPreorder(preorder, bound, idx);
        return root;
    }
}