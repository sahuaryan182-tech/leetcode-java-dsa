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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        FindRightView(root, ans, 0);
        return ans;  
    }
    private void FindRightView(TreeNode root, List<Integer> ans, int level){
        if(root == null) return;
        //if level has a same(number) as list size , that mean we came to that level at frist time
        if(level == ans.size()) ans.add(root.val);
        FindRightView(root.right, ans, level + 1);
        FindRightView(root.left, ans, level + 1);
    }
}