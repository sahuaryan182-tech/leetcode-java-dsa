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
    public int maxPathSum(TreeNode root) {
        int[] maxValue = new int[1];
        maxValue[0] = Integer.MIN_VALUE;
        maxPathDown(root, maxValue);
        return maxValue[0];
    }
    //funtion to calculate matx path
    private int maxPathDown(TreeNode root, int[] maxValue){
        if(root == null) return 0;

        //If the child gives us a negative contribution, don't take that child.
        //do not take any nagative sum, in order to return MaxPathSum
        int leftsum = Math.max(0, maxPathDown(root.left, maxValue));
        int rightsum = Math.max(0, maxPathDown(root.right, maxValue));

        //calue the sum of path trougth the curr node
        maxValue[0] = Math.max(maxValue[0], root.val + leftsum + rightsum);

        //return or choose only maxpth either is leftsum or rigthsum
        return root.val + Math.max(leftsum, rightsum);
    }
}