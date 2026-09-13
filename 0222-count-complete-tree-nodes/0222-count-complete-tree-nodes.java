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
    public int countNodes(TreeNode root) {
        if(root == null) return 0;

        int left = getHeightLeft(root);
        int right = getHeightRight(root);

        //if left and right are equal it means that the tree is compelte and  hence
        if(left == right) return ((2<<(left)) - 1);

        //else recursivly calculate the number of nodes in the left and right and
        else return countNodes(root.left) + countNodes(root.right) + 1;
    }
    private int getHeightLeft(TreeNode root){
        int count = 0;
        while(root.left != null){
            count++;
            root = root.left;
        }
        return count;
    }
    private int getHeightRight(TreeNode root){
        int count = 0;
        while(root.right != null){
            count++;
            root = root.right;
        }
        return count;
    }
}