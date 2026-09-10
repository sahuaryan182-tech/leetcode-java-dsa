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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //cheack if both tree is null  and thet are indetical(same tree)
        if(p == null && q == null) return true;
        //if only one of them is not null, means they are is not identical(same tree)
        if(p == null || q == null) return false;
        

        //cheak is both nodes has a same value data
        //recusivly traverse(Preorder) in both tree simuntanously , reculsvy chak their lft subtree and rigth sun=b tree
        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}