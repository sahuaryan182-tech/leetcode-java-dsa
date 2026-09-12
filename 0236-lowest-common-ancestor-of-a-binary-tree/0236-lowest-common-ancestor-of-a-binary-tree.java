/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base case 
        if(root == null || root == p || root == q){
            return root;
        }

        //Search in the left and right subtree
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //result
        //left give null and right has p, or q node then take right
        if(left == null){
            return right;
        }
        //if right give us null and left has p or q node then take/return right
        else if(right == null){
            return left;
        }
        else{ //if both has node let say p in left and q in right ans left, right is not null, that node is our Parent of both node or Loweest Common Anacester(LCA) return / take that node
            return root;
        }

    }
}