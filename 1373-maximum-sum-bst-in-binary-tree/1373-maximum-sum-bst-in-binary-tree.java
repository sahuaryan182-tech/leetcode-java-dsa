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
class NodeValue{
    int minValue;
    int maxValue;
    int maxSum;
    
    // Construtor
    NodeValue(int minValue, int maxValue, int maxSum){
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.maxSum = maxSum;
    }
}
class Solution {
    private int ans = 0;
    
    private NodeValue largestBSTHelper(TreeNode root){
        //An empty tree is a BST with sum 0
        if(root == null){   //window -> [smallest, largest, sum/size] smalles -> right, largest -> left, sum in both left + right
           // Calling the Constructor
           return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        // Get values from left and right subtree of current tree
        NodeValue left = largestBSTHelper(root.left);
        NodeValue right = largestBSTHelper(root.right);

        // Current node is Greator then max in left AND min(smaller) then in right, it is a Vaild BST
        if(left.maxValue < root.val && root.val < right.minValue){
            int sum = left.maxSum + right.maxSum + root.val;
            ans = Math.max(ans, sum);
            // It is a BST
            return new NodeValue(Math.min(root.val, left.minValue), Math.max(root.val, right.maxValue), sum);
        }

        // Otherwise, return [-IntMin, IntMax] so that in future no parent can not be Consider as a Valid BST
        // Calling the Constructor
        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSum, right.maxSum));

    }

    public int maxSumBST(TreeNode root) {
        //All values are negatives in the given BSE.so Return an empty BST
        largestBSTHelper(root);
        return ans;
    }
}