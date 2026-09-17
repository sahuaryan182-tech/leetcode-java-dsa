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
    // Count and Ans needs to be globel varible beacuse the Recursion inorder() methode need to be update And remember their valuse across diffrent recursion calls
    //count and ans should be shared each recusion call
    int count;
    int ans;

   
    public int kthSmallest(TreeNode root, int k) {
        // count needs because it tell how many nodes we visited so far(door)
        int count = 0;
        inorder(root, k);
        // ans variable needs When we find the kth node deep inside recursion
        return ans;
       
    }

    private void inorder(TreeNode root, int k){
        if(root == null) return;

        inorder(root.left, k);

        count++;  //currnt node count
        if(count == k){
            ans = root.val;
            return;
        }

        inorder(root.right, k);
    }
}