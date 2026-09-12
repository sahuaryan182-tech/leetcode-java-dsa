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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> S = new ArrayList<>();
        if(root == null) return S;
        isTreePath(root, "", S);
        return S;
    }
    private void isTreePath(TreeNode root, String path, List<String> ans){
        //add currnt node (root) in string 
        path = path + root.val;

        //add the final ans into your, if we reaches in leaf node that means path is compete
        if(root.left == null && root.right == null){
            ans.add(path);
            return;
        }

        //go to left subtrre
        if(root.left != null){
            isTreePath(root.left, path + "->",  ans);
        }

        //goto right subtree
        if(root.right != null){
            isTreePath(root.right, path + "->", ans);
        }
      
        
    }
}